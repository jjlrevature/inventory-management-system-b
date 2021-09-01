package project.two.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.two.dao.ProductDAO;
import project.two.models.Product;
import project.two.models.ProductStock;
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO productDao;
	
	public List<ProductStock> getOnDemand() {
		List<ProductStock> p = productDao.getDemand("Playstation 5");
		return p;
	}
	
}
