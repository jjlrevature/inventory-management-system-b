package com.groupb.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.groupb.service.ProductManager;

public class Main {
	@Autowired
	public ProductManager pManager;
	
	public static void main(String[] args) {
		Main m = new Main();
		List<Map<String,Object>> list = m.pManager.getDemand();
		for(Map<String, Object> l: list) {
			System.out.println(l.get("title"));
			System.out.println(l.get("minimumlimit"));
			System.out.println(l.get("quantity"));
		}
	}
}
