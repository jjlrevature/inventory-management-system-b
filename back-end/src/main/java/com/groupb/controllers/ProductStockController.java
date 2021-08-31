package com.groupb.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupb.models.ProductStock;
import com.groupb.service.ProductStockManager;


@RestController
@RequestMapping(path="/stock", produces="application/json")
public class ProductStockController {

	private static final Logger logger = LogManager.getLogger(ProductStockController.class.getName());
	
	private ProductStockManager psManager;	
	
	@GetMapping(path="/ps5")
	public List<ProductStock> getPs5Stock() {
		System.out.println("check1 2");
		return psManager.getPlaystation5InStock();
	}
	
	@GetMapping(path="/xbx",produces="application/json")
	public List<ProductStock> getXbxStock() {
		return psManager.getXboxSeriesXInStock();
	}
	
	@GetMapping(path="/ns",produces="application/json")
	public List<ProductStock> getNsStock() {
		return psManager.getNintendoSwitchInStock();
	}
	
}
