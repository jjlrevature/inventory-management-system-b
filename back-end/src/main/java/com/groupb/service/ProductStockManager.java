package com.groupb.service;

import java.util.List;

import com.groupb.models.ProductStock;

public interface ProductStockManager {

	public List<ProductStock> getPlaystation5InStock();
	
	public List<ProductStock> getXboxSeriesXInStock();
	
	public List<ProductStock> getNintendoSwitchInStock();
}
