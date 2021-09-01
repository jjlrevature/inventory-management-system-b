package project.two.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.two.models.Product;
import project.two.models.ProductStock;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer>{

	@Query("select ps from ProductStock ps where ps.product.title = :Title")
	public List<ProductStock> getDemand(@Param("Title") String title);
	
}

//"select p.title, p.minimumlimit, sum(quantity) as quantity from product_stock ps join products p on"
//+ "ps.product_ref_id = p.productid group by p.title, p.minimumlimit having sum(quantity) < p.minimumlimit"