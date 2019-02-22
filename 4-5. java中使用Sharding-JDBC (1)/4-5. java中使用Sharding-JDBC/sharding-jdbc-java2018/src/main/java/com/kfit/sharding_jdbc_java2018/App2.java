package com.kfit.sharding_jdbc_java2018;

import java.io.File;
import java.io.IOException;
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
import io.shardingsphere.shardingjdbc.api.yaml.YamlShardingDataSourceFactory;

/**
 * 1. 通过Druid构建数据源.
 * 2. 通过ShardingDataSourceFactory 构建分片数据源.
 * 3. 编写测试例子： 通过DataSource获取到Connection.
 * @author linxiangxian
 *
 */
public class App2 {
	
	
	/**
	 * 3. 编写测试例子： 通过DataSource获取到Connection.
	 * @param args
	 * @throws SQLException 
	 * @throws IOException 
	 */
    public static void main( String[] args ) throws SQLException, IOException{
        
    	/*
    	 * 1. 需要到DataSource
    	 * 2. 通过DataSource获取Connection
    	 * 3. 定义一条SQL语句.
    	 * 4. 通过Connection获取到PreparedStament.
    	 * 5. 执行SQL语句.
    	 * 6. 关闭连接.
    	 */
    	
//    	* 1. 需要到DataSource
    	String filePath = App2.class.getResource("/sharding.yaml").getFile();
    	DataSource dataSource = YamlShardingDataSourceFactory.createDataSource(new File(filePath));
    	
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
