package project.two.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		if(productList.size() == 0) {
			// method was called but no products were found
			allProducts = new ResponseEntity<List<Product>>(productList,HttpStatus.NO_CONTENT); // 204
			logger.info("getAllProducts called but had no content");
		} else {
			// all products were returned
			allProducts = new ResponseEntity<List<Product>>(productList,HttpStatus.OK); // 200
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
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping(value="/updateProduct", consumes="application/json")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product){
		ResponseEntity<Product> updatedProduct = null;
		
		if(prodService.ifProductExists(product.getProductId())) {
			// product does exist
			logger.info("product was successfully updated in the database");
			updatedProduct = new ResponseEntity<Product>(prodService.updateProduct(product), HttpStatus.ACCEPTED); // 202);
		} else {
			// no product was found
			logger.info("update product was attempted but no product was found");
			updatedProduct = new ResponseEntity<Product>(product, HttpStatus.NO_CONTENT); // 204
		}
		return updatedProduct;
	}
	/**
	 * @author Jesse
	 * Method to Delete Product 
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(value="/deleteProduct",consumes="application/json")
	public ResponseEntity<Product> deleteProduct(@RequestBody Product product){
		ResponseEntity<Product> returnedProduct = null;
		if(prodService.ifProductExists(product.getProductId())) {
			// Product was found
			prodService.deleteProduct(product);
			returnedProduct = new ResponseEntity<Product>(product, HttpStatus.ACCEPTED); // 202
		} else {
			// Product was not found
			returnedProduct = new ResponseEntity<Product>(product, HttpStatus.NOT_FOUND); // 404
		}
		return returnedProduct;
	}
		
}
