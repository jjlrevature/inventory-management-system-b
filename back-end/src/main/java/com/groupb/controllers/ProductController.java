package com.groupb.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupb.service.ProductManager;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductManager prodManager;
	
	@GetMapping(path="/showDemand", produces="application/json")
	public ResponseEntity<Object> getDemand() {
		List<Map<String, Object>> list = prodManager.getDemand();
		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}
}
