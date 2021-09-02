package project.two.services;

import java.util.List;

import project.two.models.ProductStock;

public interface ProductStockManager {
	
	public List<ProductStock> getCurrentProductStock(int productId);

	public List<ProductStock> getPlaystation5InStock();
	
	public List<ProductStock> getXboxSeriesXInStock();
	
	public List<ProductStock> getNintendoSwitchInStock();
}
