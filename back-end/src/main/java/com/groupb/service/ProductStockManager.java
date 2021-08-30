package com.groupb.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupb.models.Product;
import com.groupb.models.ProductStock;

public interface ProductStockManager  extends JpaRepository<ProductStock, Integer>{

}
