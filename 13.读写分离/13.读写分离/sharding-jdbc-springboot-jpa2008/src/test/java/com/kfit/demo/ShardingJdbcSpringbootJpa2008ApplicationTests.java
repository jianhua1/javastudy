package com.kfit.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.kfit.demo.bean.OrderInfo;
import com.kfit.demo.repository.OrderInfoRepository;
import com.kfit.demo.service.OrderInfoService;
import com.kfit.demo.service.OrderItemService;

import io.shardingsphere.core.api.HintManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingJdbcSpringbootJpa2008ApplicationTests {

	@Autowired
	private OrderInfoService orderInfoService;
	
	@Autowired
	private OrderItemService orderItemService;
	
	
	@Autowired
	private OrderInfoRepository orderInfoRepository;
	
	/**
	 * 强制路由的 - ds0
	 */
	@Test
	public void testPageForce() {
		
		HintManager hintManager = HintManager.getInstance();
		hintManager.addDatabaseShardingValue("order_info","uid",0);
		//page 是从0开始的.
		Pageable pageable = PageRequest.of(1, 2, Sort.by("oid"));
		Page<OrderInfo> page = orderInfoRepository.findAll(pageable);
		for(OrderInfo info:page.getContent()) {
			// oid =4,6
			System.out.println("oid="+info.getOid()+",uid="+info.getUid());
		}
		
		hintManager.close();
		
	}
	
	
	@Test
	public void testPage() {
		
		//HintManager hintManager = HintManager.getInstance();
		//hintManager.setMasterRouteOnly();

		
		//page 是从0开始的.
		Pageable pageable = PageRequest.of(1, 2, Sort.by("oid"));
		Page<OrderInfo> page = orderInfoRepository.findAll(pageable);
		for(OrderInfo info:page.getContent()) {
			// oid = 2,3
			System.out.println("oid="+info.getOid()+",uid="+info.getUid());
		}
	}
	
	
	@Test
	public void testBindTable() {
		orderItemService.testBindTable();
	}
	
	@Test
	public void test() {
		
		for(int i=0;i<10;i++) {
			OrderInfo orderInfo = new OrderInfo();
			orderInfo.setUid(1000+i);
			orderInfo.setStatus("save.jpa.sharding");
			orderInfoService.save(orderInfo);
		}
		
	}

}

