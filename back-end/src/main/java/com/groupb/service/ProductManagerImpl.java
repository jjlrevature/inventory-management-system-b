package com.groupb.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupb.DAO.ProductDAO;

@Service
public class ProductManagerImpl implements ProductManager{

	@Autowired
	private ProductDAO prodDao;
	
	public List<Map<String, Object>> getDemand() {
		return prodDao.getDemand();
	}
	
}
