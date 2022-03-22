package project.two.services;

import java.util.List;

import project.two.models.Product;
import project.two.models.ProductStock;

public interface ProductStockManager {
	
	public List<ProductStock> getCurrentProductStock(int productId);
	
	public List<ProductStock>getStock();
	
	public ProductStock addStock(ProductStock prod);
	
	public ProductStock updateProduct(ProductStock prod);
	
	public boolean ifProductStockExists(int productStockId);
}
