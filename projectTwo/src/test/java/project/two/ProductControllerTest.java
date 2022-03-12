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
	
	String uri = "/product";
	int product_id = 999;
	
	@BeforeEach
	protected void setUp() {
		super.setUp();
	}
	
	@AfterEach
	void tearDown() throws Exception {
		
	}
	
	
	@Test
	@Order(1)
	@DisplayName("**** test getAllProducts method in ProductController")
	void testGetAllProducts() throws Exception {
		
		// expected status
		int expectedStatus = 200;
		
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
		assertTrue(listOfProducts.length > 0);
	}
	
	@Test
	@Order(2)
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
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(jsonProduct)).andReturn();
		
		// receive result set and save to variables for assert statements
		int actualStatus = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		
		assertEquals(expectedStatus, actualStatus);
		assertEquals(testProduct, content);
		
	}
}
