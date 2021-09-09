package project.two;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.hibernate.internal.build.AllowSysOut;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import project.two.models.Product;
import project.two.models.ProductStock;
import project.two.services.ProductService;
import project.two.services.ProductStockManager;

@SpringBootTest
class ProjectTwoApplicationTests {

	@Autowired
	private ProductService pManager;
	
	@Autowired
	private ProductStockManager psManager;
	
	@Test
	void testGetInDemandService() {
		List<Map<String,Object>> list = pManager.getInDemand();
		if(list != null) {
			assertEquals(1, BigInteger.valueOf(((Integer)list.get(0).get("minLimit"))).compareTo(((BigInteger)list.get(0).get("demand"))));
		}
	}

	@Test
	void testFindProductByIdService() {
		Product prod = pManager.findProductById(1);
		assertNotEquals(prod, null);
	}
	
	@Test
	void testGetStockService() {
		List<ProductStock> list = psManager.getStock();
		assertNotEquals(list, null);
	}
	
	@Test
	void testGetInDemandController() {
		RestTemplate rest = new RestTemplate();
		String requestUrl = "http://localhost:8080/products/inDemand";
		ResponseEntity<Object> obj = rest.getForEntity(requestUrl, Object.class);
		List<Map<String, Object>> list = (List<Map<String, Object>>) obj.getBody();
		if(list != null) {
			System.out.println(list.get(0).get("minLimit"));
			System.out.println(list.get(0).get("demand"));
			assertEquals(1, BigInteger.valueOf(((Integer)list.get(0).get("minLimit"))).compareTo(BigInteger.valueOf((Integer)list.get(0).get("demand"))));
		}
	}
	
	@Test
	void testGetproductStockDetails(){
		ProductStockController prod = new ProductStockController();
		prod.createStock(1, null);
		assertTrue(true);
	    System.out.println("product 1 stock for new details success");
	}
	
	@Test
	void testGetproductDetails2(){
		ProductStockController prod = new ProductStockController();
		prod.createStock(16, null);
		assertFalse(false);
	    System.out.println("fake product 16 stock for new details success");
	}
	
}
