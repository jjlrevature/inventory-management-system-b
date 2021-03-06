package project.two.services;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.two.dao.ProductDAO;
import project.two.models.Product;
@Service
public class ProductServiceImpl implements ProductService{

	private static final Logger logger = LogManager.getLogger(ProductServiceImpl.class);
	
	@Autowired
	private ProductDAO productDao;
	
	public List<Map<String, Object>> getInDemand() {
		logger.info("Getting Products Below Threshold");
		List<Object[]> list = productDao.getDemand();
		if(list != null) {
			List<Map<String,Object>> map = new ArrayList<Map<String, Object>>();
			for(Object[] l: list) {
				Map<String, Object> temp = new HashMap<String, Object>();
				temp.put("title", l[0]);
				temp.put("minLimit", l[1]);
				temp.put("demand", (BigInteger.valueOf((Integer)l[1])).subtract(((BigInteger)l[2])));
				map.add(temp);
			}
			return map;
		}
		return null;
	}

	@Override
	public Product findProductById(int productID) {
		logger.info("Getting Product By Id");
		return productDao.getById(productID);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}
	
	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.save(product);
	}

	@Override
	public boolean ifProductExists(int product_id) {
		// TODO Auto-generated method stub
		Optional<Product> product = productDao.findById(product_id);
		return product.isPresent();
	}
	
	@Override
	public Product updateProduct(Product product) {
		Product temp = product;
		Product prod = productDao.getById(product.getProductId());
		prod = temp;
		productDao.save(prod);		
		return prod;
	}

	@Override
	public Product deleteProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.delete(product);
		return product;
	}
}
