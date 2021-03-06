package project.two.services;

import java.util.List;
import java.util.Map;

import project.two.models.Product;

public interface ProductService {

	public List<Map<String, Object>> getInDemand();
	
	public Product findProductById(int productID);
	
	public Product saveProduct(Product product);
	
	public List<Product> getAllProducts();
	
	public boolean ifProductExists(int product_id);
	
	public Product updateProduct(Product product);
	
	public Product deleteProduct(Product product);
	
}
