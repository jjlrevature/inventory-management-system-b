package com.groupb.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.groupb.models.ProductStock;


public interface ProductStockDAO extends JpaRepository<ProductStock,Integer> {

	@Query(value="select sum(quantity) from playstation5_quantity", nativeQuery=true)
	public List<ProductStock> getPs5PSQuantity();
	
	@Query(value="select sum(quantity) from xbox_series_x_quantity", nativeQuery=true)
	public List<ProductStock> getXbxPSQuantity();
	
	@Query(value="select sum(quantity) from nintendo_switch_quantity", nativeQuery=true)
	public List<ProductStock> getNsPSQuantity();
}
