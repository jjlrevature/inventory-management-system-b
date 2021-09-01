package project.two.services;

import java.util.List;
import java.util.Map;

import project.two.models.Product;
import project.two.models.ProductStock;

public interface ProductService {

	public List<ProductStock> getOnDemand();
	
}
