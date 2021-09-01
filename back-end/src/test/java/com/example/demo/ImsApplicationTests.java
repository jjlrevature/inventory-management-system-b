package com.example.demo;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.groupb.DAO.ProductDAO;
import com.groupb.demo.ImsApplication;
import com.groupb.service.ProductManager;

@SpringBootTest(classes=ImsApplication.class)
class ImsApplicationTests {

	@Autowired
	private ProductManager prodmanager;
	
	@Test
	void testOnDemand() {
		List<Map<String,Object>> list = prodmanager.getDemand();
		for(Map<String, Object> l: list) {
			System.out.println(l.get("title"));
			System.out.println(l.get("minimumlimit"));
			System.out.println(l.get("quantity"));
		}
	}

}
