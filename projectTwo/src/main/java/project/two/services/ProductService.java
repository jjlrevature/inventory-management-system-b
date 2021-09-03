package project.two.services;

import java.util.List;
import java.util.Map;

import project.two.models.Product;

public interface ProductService {

	public List<Map<String, Object>> getInDemand();
	
	public Product findProductById(int productID);
	
	public Product addProduct(Product product);
	
}
