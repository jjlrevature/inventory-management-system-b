package project.two;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import project.two.models.Product;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class ProductControllerTest extends AbstractTest {
	
	String uri = "/products";
	int product_id = 999;
	
	@BeforeEach
	protected void setUp() {
		super.setUp();
	}
	
	@AfterEach
	void tearDown() throws Exception {
		
	}
	
	
	@Test
	@Order(7)
	@DisplayName("**** test getAllProducts method in ProductController")
	void testGetAllProductsWhenthereAreNone() throws Exception {
		
		// expected status
		int expectedStatus = 204;
		
		// run mock transaction
		MvcResult mvcRS = mockMvc.perform(MockMvcRequestBuilders.get(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		
		// save status and content to variable for assert statements
		int actualStatus = mvcRS.getResponse().getStatus();
		String returnedContent = mvcRS.getResponse().getContentAsString();		
		Product[] listOfProducts = super.mapFromJson(returnedContent, Product[].class);
		
		// check if status is equal and that array is populated
		assertEquals(expectedStatus, actualStatus);
		assertTrue(listOfProducts.length == 0);
	}
	
	@Test
	@Order(4)
	@DisplayName("**** test get all method when list is populated")
	void testGetAllProducts() throws Exception {
		// expected status
		int expectedStatus = 200;
		
		// Mock transaction
		MvcResult mvcRS = mockMvc.perform(MockMvcRequestBuilders.get(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();
		
		// save status and content to variable for assert statements
		int actualStatus = mvcRS.getResponse().getStatus();
		String returnedContent = mvcRS.getResponse().getContentAsString();		
		Product[] listOfProducts = super.mapFromJson(returnedContent, Product[].class);
		
		// check if status is equal and that array is populated
		assertEquals(expectedStatus, actualStatus);
		assertTrue(listOfProducts.length > 0);
	}
	
	@Test
	@Order(1)
	@DisplayName("**** test saveProduct method in ProductController")
	void testSaveProduct() throws Exception {
		
		// expected status
		int expectedStatus = 201;
		
		// create mock product and set mock product id
		Product testProduct = new Product();
		testProduct.setProductId(product_id);
		
		// map mock product to json
		String jsonProduct = super.mapToJson(testProduct);
		
		// perform mock transaction
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri+"/addProduct")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(jsonProduct)).andReturn();
		
		// receive result set and save to variables for assert statements
		int actualStatus = mvcResult.getResponse().getStatus();
		
		assertEquals(expectedStatus, actualStatus);
		
	}
	
	@Test
	@Order(2)
	@DisplayName("**** test to saveProduct that already exists")
	void testSaveProductWithConflict() throws Exception {
		// expected status
		int expectedStatus = 409;

		// Mock product
		Product testProduct = new Product();
		testProduct.setProductId(product_id);
		
		// Mapping test product to Json
		String jsonProduct = super.mapToJson(testProduct);
		
		// Attempt to save item to database
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri+"/addProduct")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(jsonProduct)).andReturn();
		
		// returned content
		int actualStatus = mvcResult.getResponse().getStatus();
		
		assertEquals(expectedStatus, actualStatus);
	}
	
	@Test
	@Order(3)
	@DisplayName("**** test to update a product in the database")
	void testUpdateProduct() throws Exception {
		// expected status 
		int expectedStatus = 202;
		
		// Mock product
		Product testProduct = new Product();
		testProduct.setProductId(product_id);
		testProduct.setManufacturer("TestingManufacturer");
		
		// Mapping test to Json
		String jsonProduct = super.mapToJson(testProduct);
		
		// update item in database
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put(uri+"/updateProduct")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(jsonProduct)).andReturn();
		
		// returned content
		int actualStatus = mvcResult.getResponse().getStatus();
		
		assertEquals(expectedStatus, actualStatus);
	}

	@Test
	@Order(5)
	@DisplayName("**** test to delete product from the database")
	void testDeleteProduct() throws Exception {
		// expected status
		int expectedStatus = 202;
		
		// Mock Product
		Product testProduct = new Product();
		testProduct.setProductId(product_id);
		
		// Mapping product to json
		String jsonProduct = super.mapToJson(testProduct);
		
		// delete product from database
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(uri+"/deleteProduct")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(jsonProduct)).andReturn();
		
		// returned content
		int actualStatus = mvcResult.getResponse().getStatus();
		
		assertEquals(expectedStatus, actualStatus);
	}
	
	@Test
	@Order(6)
	@DisplayName("**** test to try to delete a product that doesnt exist")
	void testDeleteProductThatDoesntExist() throws Exception {
		// expected status
		int expectedStatus = 404;
		
		// Mock Product
		Product testProduct = new Product();
		testProduct.setProductId(product_id);
		
		// Mapping to Json
		String jsonProduct = super.mapToJson(testProduct);
		
		// delete product from database
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.delete(uri+"/deleteProduct")
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(jsonProduct)).andReturn();
		
		// returned content
		int actualStatus = mvcResult.getResponse().getStatus();
		
		assertEquals(expectedStatus, actualStatus);
	}
}
