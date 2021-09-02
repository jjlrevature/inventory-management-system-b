package project.two.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.two.dao.ProductStockDao;

import project.two.models.ProductStock;

@Service
public class ProductStockManagerImpl implements ProductStockManager{
	
	private static final Logger logger = LogManager.getLogger(ProductStockManagerImpl.class.getName());

	@Autowired
	private ProductStockDao psDao;
	
	@Override
	public List<ProductStock> getPlaystation5InStock() {
		// TODO Auto-generated method stub
		return psDao.getPs5PSQuantity();
	}

	@Override
	public List<ProductStock> getXboxSeriesXInStock() {
		// TODO Auto-generated method stub
		return psDao.getXbxPSQuantity();
	}

	@Override
	public List<ProductStock> getNintendoSwitchInStock() {
		// TODO Auto-generated method stub
		return psDao.getNsPSQuantity();
	}

	@Override
	public List<ProductStock> getCurrentProductStock(int productId) {
		// TODO Auto-generated method stub
		return psDao.getCurrentQuantity(productId);
	}
	

}
