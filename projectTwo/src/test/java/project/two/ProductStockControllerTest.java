package project.two;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class ProductStockControllerTest extends AbstractTest {
	
	String uri = "/'productStock";
	int productStock_id = 999;
	
	@BeforeEach
	protected void setUp() {
		super.setUp();
	}

	@Test
	@Order(1)
	@DisplayName("**** test addProduct in ProductStockController")
	void testAddProductStock() throws Exception {
		
	}
	
	@Test
	@Order(2)
	@DisplayName("**** test addProduct in ProductStockController when ProductStock already exists")
	void testAddProductStockError() throws Exception {
		
	}
	
	@Test
	@Order(3)
	@DisplayName("**** test updateProduct in ProductStockController")
	void testUpdateProductStock() throws Exception {
		
	}
	
	@Test
	@Order(7)
	@DisplayName("**** test updateProduct in ProductStockController when ProductStock does not exist")
	void testUpdateProductStockError() throws Exception {
		
	}
	
	@Test
	@Order(4)
	@DisplayName("**** test getProduct in ProductStockController")
	void testGetProductStock() throws Exception {
		
	}
	
	@Test
	@Order(5)
	@DisplayName("**** test getAllProduct in ProductStockController")
	void testGetAllProductStock() throws Exception {
		
	}
	
	@Test
	@Order(6)
	@DisplayName("**** test deleteProduct in ProductStockController")
	void testDeleteProductStock() throws Exception {
		
	}
	
	@Test
	@Order(8)
	@DisplayName("**** test deleteProduct in ProductStockController when ProductStock does not exist")
	void testDeleteProductStockError() throws Exception {
		
	}
}
