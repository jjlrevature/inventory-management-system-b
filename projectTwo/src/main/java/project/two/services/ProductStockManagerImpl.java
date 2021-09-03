package project.two.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.two.dao.ProductStockDAO;
import project.two.models.Product;
import project.two.models.ProductStock;

@Service
public class ProductStockManagerImpl implements ProductStockManager{
	
	private static final Logger logger = LogManager.getLogger(ProductStockManagerImpl.class.getName());

	@Autowired
	private ProductStockDao psDao;
	
	public List<ProductStock>getStock() {
		logger.info("Getting all Product Stock");
		return psDAO.findAll();
	}
	
	public ProductStock addStock(ProductStock prod) {
		logger.info("Adding Product Stock");
		if(prod.getTransType().equals("OUT")) {
			prod.setQuantity(prod.getQuantity() * -1);
		}
		return psDAO.save(prod);
	}

	@Override
	public List<ProductStock> getCurrentProductStock(int productId) {
		// TODO Auto-generated method stub
		return psDao.getCurrentQuantity(productId);
	}
	

}
