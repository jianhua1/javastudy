package com.kfit.sharding_jdbc_java2018;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.cj.jdbc.Driver;

import io.shardingsphere.api.config.ShardingRuleConfiguration;
import io.shardingsphere.api.config.TableRuleConfiguration;
import io.shardingsphere.api.config.strategy.InlineShardingStrategyConfiguration;
import io.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;

/**
 * 1. 通过Druid构建数据源.
 * 2. 通过ShardingDataSourceFactory 构建分片数据源.
 * 3. 编写测试例子： 通过DataSource获取到Connection.
 * @author linxiangxian
 *
 */
public class App {
	
	/**
	 * 1. 通过Druid构建数据源.
	 * @return
	 */
	public DataSource createDataSource(String url,String username,String password) {
		DruidDataSource ds = new DruidDataSource();
		/*
		 * driver : 数据库驱动.
		 * url: 数据库地址
		 * username/pwd : 账号和密码.
		 */
		ds.setDriverClassName(Driver.class.getName());
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		
		return ds;
	}
	
	/**
	 * 2. 通过ShardingDataSourceFactory 构建分片数据源.
	 * @return
	 * @throws SQLException 
	 */
	public DataSource getShardingDataSource() throws SQLException {
		/*
		 * 1. 数据源集合：dataSourceMap
		 * 
		 * 2. 分片规则：shardingRuleConfig
		 * 
		 */
		
		//1. 数据源集合：dataSourceMap
		Map<String,DataSource> dataSourceMap = new HashMap<String, DataSource>();
		//添加数据源.两个数据源ds_0和ds_1
		dataSourceMap.put("ds_0", createDataSource("jdbc:mysql://localhost:3306/ds_0", "root", "root"));
		dataSourceMap.put("ds_1", createDataSource("jdbc:mysql://localhost:3306/ds_1", "root", "root"));
		
		/*
		 * 需要构建表规则
		 * 1. 指定逻辑表.
		 * 2. 配置实际节点》
		 * 3. 指定主键字段.
		 * 4. 分库和分表的规则》
		 */
		/*
		 * 这里配置了表：t_order 
		 * ds_0和ds_1
		 * t_order_0 和 t_order_1 构成
		 * 
		 * (order_id,user_id,status)
		 * 
		 * 表的分片策略 order_id  
		 * 库的分片策略 user_id  
		 */
		TableRuleConfiguration orderTableRuleConfiguration = new TableRuleConfiguration();
		orderTableRuleConfiguration.setLogicTable("t_order");
		//ds_0.t_order_0 , ds_0.t_order_1, ds_1.t_order_0 , ds_1.t_order_1
		orderTableRuleConfiguration.setActualDataNodes("ds_${0..1}.t_order_${0..1}");
		orderTableRuleConfiguration.setKeyGeneratorColumnName("order_id");
		
		//表的分片策略.t_order_0,t_order_1
		orderTableRuleConfiguration.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("order_id", "t_order_${order_id%2}") );
		orderTableRuleConfiguration.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("user_id", "ds_${user_id%2}") );
		
		//分片规则：shardingRuleConfig
		ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
		shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfiguration);
		//shardingRuleConfig.setDefaultDatabaseShardingStrategyConfig(defaultDatabaseShardingStrategyConfig);
		
		DataSource ds = ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, new HashMap<String, Object>(), new Properties());
		return ds;
	}
	
	/**
	 * 3. 编写测试例子： 通过DataSource获取到Connection.
	 * @param args
	 * @throws SQLException 
	 */
    public static void main( String[] args ) throws SQLException{
        
    	/*
    	 * 1. 需要到DataSource
    	 * 2. 通过DataSource获取Connection
    	 * 3. 定义一条SQL语句.
    	 * 4. 通过Connection获取到PreparedStament.
    	 * 5. 执行SQL语句.
    	 * 6. 关闭连接.
    	 */
    	App app = new App();
    	
//    	* 1. 需要到DataSource
    	DataSource dataSource = app.getShardingDataSource();
    	
//	   	 * 2. 通过DataSource获取Connection
    	Connection connection = dataSource.getConnection();
//	   	 * 3. 定义一条SQL语句.
    	String sql = "insert into t_order(user_id,status) values(1000,'insert')";
    	//String sql = "insert into t_order(order_id,user_id,status) values(10,1000,'insert')";
    	
//	   	 * 4. 通过Connection获取到PreparedStament.
    	PreparedStatement preparedStatement = connection.prepareStatement(sql);
    	
//	   	 * 5. 执行SQL语句.
    	preparedStatement.execute();
    	
    	
    	//user_id =1000 的话，会被添加到ds0  ,1001 -->ds1
    	
	   	 connection = dataSource.getConnection();
	   	 sql = "insert into t_order(user_id,status) values(1001,'insert')";
	    //String sql = "insert into t_order(order_id,user_id,status) values(11,1000,'insert')";
	   	 preparedStatement = connection.prepareStatement(sql);
	   	preparedStatement.execute();
    	
    	
//	   	 * 6. 关闭连接.
    	preparedStatement.close();
    	connection.close();
    	
    	
    }
}
