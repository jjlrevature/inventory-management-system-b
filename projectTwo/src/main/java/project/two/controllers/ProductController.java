package project.two.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.two.models.Product;
import project.two.models.ProductStock;
import project.two.services.ProductService;




@RestController
@RequestMapping(path="/products")
public class ProductController {

	private static final Logger logger = LogManager.getLogger(ProductController.class);
	
	@Autowired
	private ProductService prodService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/inDemand", produces="application/json")
	public ResponseEntity<Object> getInDemand() {
		logger.info("Received Request for Items in Demand");
		return new ResponseEntity<Object>(prodService.getInDemand(), HttpStatus.OK);
	}	

	/**
	 * @author Jesse
	 * refactored method for retrieving all products
	 * will return a 204 status and empty list is retrieved
	 * list is not populated, or a 200 status with a populated
	 * list.
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="", produces="application/json")
	public ResponseEntity<List<Product>> getAllProducts() {		
		ResponseEntity<List<Product>> allProducts = null;
		List<Product> productList = prodService.getAllProducts();
		
		if(productList.size() > 0) {
			allProducts = new ResponseEntity<List<Product>>(productList,HttpStatus.OK); // 200
			logger.info("getAllProducts called but had no content");
		} else {
			allProducts = new ResponseEntity<List<Product>>(productList,HttpStatus.NO_CONTENT); // 204
			logger.info("getAllProducts called and returned all products");
		}
		
		return allProducts;
	}
	
	/**
	 * @author Jesse
	 * refactored method to save a product to the database.
	 * will return status 409 if product with that ID
	 * already exists in the database, will return status 201 if
	 * the product saves successfully
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/addProduct",consumes="application/json")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		ResponseEntity<Product> savedProduct = null;
		if(prodService.ifProductExists(product.getProductId())) {
			// product id already exists
			savedProduct = new ResponseEntity<Product>(product, HttpStatus.CONFLICT); // 409
			logger.error("saveProduct called but product already existed");
		} else {
			// product created
			prodService.saveProduct(product);
			savedProduct = new ResponseEntity<Product>(product,HttpStatus.CREATED); // 201
			logger.info("saveProduct was called and product saved successfully");
		}
		
		return savedProduct;
	}
	
	
	/**
	 * @author Jesse
	 * Method to Update Product 
	 */
	
	/**
	 * @author Jesse
	 * Method to Delete Product 
	 */
	
	
	// method before refactoring
//	@CrossOrigin(origins = "http://localhost:4200")
//	@PostMapping(value="/addProduct",consumes="application/json")
//	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
//		try {
//			Product add = prodService.addProduct(product);
//			return new ResponseEntity<>(add, HttpStatus.CREATED);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	
	// method before refactoring
//	@CrossOrigin(origins = "http://localhost:4200")
//	@GetMapping(path="", produces="application/json")
//	public ResponseEntity<List<Product>> getAllProducts() {
//		List<Product> list = prodService.getAllProducts();
//		for(int x = 0; x < list.size(); x++) {
//			int y = x + 1;
//			List<ProductStock> pStock = list.get(x).getStock();
//			int total = getTotal(pStock);
//			list.get(x).setCurrentStock(total);
//		}
//		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
//	}
	// method was not being used
//	private int getTotal(List<ProductStock> plist) {
//		int total = 0;
//		for(int x = 0; x < plist.size(); x++) {
//			int newQuantity = plist.get(x).getQuantity();
//			if(newQuantity < 0) {				
//				total = total - Math.abs(newQuantity);
//			} else {
//				total = total + newQuantity;							
//			}
//		}		
//		return total;
//	}

	
}
