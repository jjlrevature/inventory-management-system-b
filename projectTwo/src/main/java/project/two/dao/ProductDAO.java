package project.two.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.two.models.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer>{

	@Query(value = "select p.title, p.minimumlimit, sum(ps.quantity) from inventory.product_stock ps join inventory.products p on ps.product_ref_id = p.productid group by p.title, p.minimumlimit having sum(ps.quantity) < p.minimumlimit", nativeQuery=true)
	public List<Object[]> getDemand();
	
	@Query(value = "select product from Product product where product.productid=:ID")
	public Product getProductById(@Param("ID") int id);
	
}

