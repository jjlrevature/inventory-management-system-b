package project.two.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import project.two.models.ProductStock;

public interface ProductStockDao extends JpaRepository<ProductStock,Integer> {

	@Query(value="select ps from ProductStock ps where ps.product.title='Playstation 5'")
	public List<ProductStock> getPs5PSQuantity();
	
	@Query(value="select ps from ProductStock ps where ps.product.title='Xbox Series X'")
	public List<ProductStock> getXbxPSQuantity();
	
	@Query(value="select ps from ProductStock ps where ps.product.title='Nintendo Switch'")
	public List<ProductStock> getNsPSQuantity();
	
	@Query(value="select product from ProductStock product where product.warehouseStockId=:ProductId")
	public List<ProductStock> getCurrentQuantity(@Param("ProductId") int productid);
}
