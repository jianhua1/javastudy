package com.kfit.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kfit.demo.bean.OrderInfo;
import com.kfit.demo.service.OrderInfoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShardingJdbcSpringbootJpa2008ApplicationTests {

	@Autowired
	private OrderInfoService orderInfoService;
	
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

