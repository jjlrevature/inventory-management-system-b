package com.groupb.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.groupb.DAO.ProductStockDAO;
import com.groupb.models.ProductStock;


@Service
public class ProductStockManagerImpl implements ProductStockManager {

	
	
	private static final Logger logger = LogManager.getLogger(ProductStockManagerImpl.class.getName());
	
	@Autowired
	private ProductStockDAO psDAO;

	@Override
	public List<ProductStock> getPlaystation5InStock() {
		// TODO Auto-generated method stub
		return psDAO.getPs5PSQuantity();
	}

	@Override
	public List<ProductStock> getXboxSeriesXInStock() {
		// TODO Auto-generated method stub
		return psDAO.getXbxPSQuantity();
	}

	@Override
	public List<ProductStock> getNintendoSwitchInStock() {
		// TODO Auto-generated method stub
		return psDAO.getNsPSQuantity();
	}
}
