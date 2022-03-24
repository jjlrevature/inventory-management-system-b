package project.two;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import project.two.models.ProductStock;

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
		//expected status
		int expectedStatus = 201;
		
		// create mock productStock and convert to json
		ProductStock mock = new ProductStock();
		mock.setWarehouseStockId(productStock_id);
		String jsonMock = super.mapToJson(mock);
		
		// run mock transaction
		MvcResult mvc = mockMvc.perform(MockMvcRequestBuilders.post(uri+"/add/"+productStock_id)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(jsonMock)).andReturn();
		
		//receive result status and assert
		int actualStatus = mvc.getResponse().getStatus();
		assertEquals(expectedStatus, actualStatus);
	}
	
	@Test
	@Order(2)
	@DisplayName("**** test addProduct in ProductStockController when ProductStock already exists")
	void testAddProductStockError() throws Exception {
		//expected status
		int expectedStatus = 409;
		
		// create mock productStock and convert to json
		ProductStock mock = new ProductStock();
		mock.setWarehouseStockId(productStock_id);
		String jsonMock = super.mapToJson(mock);
		
		// run mock transaction
		MvcResult mvc = mockMvc.perform(MockMvcRequestBuilders.post(uri+"/add/"+productStock_id)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(jsonMock)).andReturn();
		
		//receive result status and assert
		int actualStatus = mvc.getResponse().getStatus();
		assertEquals(expectedStatus, actualStatus);
	}
	
	@Test
	@Order(3)
	@DisplayName("**** test updateProduct in ProductStockController")
	void testUpdateProductStock() throws Exception {
		// expected status
		int expectedStatus = 202;
		
		// mock product and map to json
		ProductStock mock = new ProductStock();
		mock.setWarehouseStockId(productStock_id);
		String jsonMock = super.mapToJson(mock);
		
		// perform mock transaction
		MvcResult mvc = mockMvc.perform(MockMvcRequestBuilders.put(uri+"/updateProductStock/"+productStock_id)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(jsonMock)).andReturn();
		
		// returned status and assert
		int actualStatus = mvc.getResponse().getStatus();
		assertEquals(expectedStatus, actualStatus);
	}
	
	@Test
	@Order(7)
	@DisplayName("**** test updateProduct in ProductStockController when ProductStock does not exist")
	void testUpdateProductStockError() throws Exception {
		// expected status
		int expectedStatus = 404;
		
		// mock product and map to json
		ProductStock mock = new ProductStock();
		mock.setWarehouseStockId(productStock_id);
		String jsonMock = super.mapToJson(mock);
		
		// perform mock transaction
		MvcResult mvc = mockMvc.perform(MockMvcRequestBuilders.put(uri+"/updateProductStock/"+productStock_id)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(jsonMock)).andReturn();
		
		// returned status and assert
		int actualStatus = mvc.getResponse().getStatus();
		assertEquals(expectedStatus, actualStatus);
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
