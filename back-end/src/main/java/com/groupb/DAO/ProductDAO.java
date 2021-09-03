package com.groupb.DAO;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.groupb.models.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer>{

	@Query("select p.title, p.minimumlimit, sum(quantity) as quantity from product_stock ps join products p on"
			+ "ps.product_ref_id = p.productid group by p.title, p.minimumlimit having sum(quantity) < p.minimumlimit")
	public List<Map<String, Object>>getDemand();
	
}
