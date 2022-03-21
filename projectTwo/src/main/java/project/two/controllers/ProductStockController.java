package project.two.controllers;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.two.dao.ProductDAO;
import project.two.models.Product;
import project.two.models.ProductStock;
import project.two.services.ProductService;
import project.two.services.ProductStockManager;

@RestController
@RequestMapping(path="/stock", produces="application/json")
public class ProductStockController {

	private static final Logger logger = LogManager.getLogger(ProductStockController.class);
	
	@Autowired
	private ProductStockManager psManager;	
	
	@Autowired
	private ProductService pManager;

	/**
	 * @author Jesse
	 * refactored method to retrieve a list of all Product Stock.
	 * will return status 200 if the list is found and populated.
	 * will return status 204 if the list is found and not populated.
	 * will return status 500 if there was an error retrieving list.
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public ResponseEntity<List<ProductStock>> getProductStock() {
		ResponseEntity<List<ProductStock>> returnedEntity = null;
		List<ProductStock> list = psManager.getStock();
		
		if(list.size() > 0) {
			// list is populated with objects
			returnedEntity = new ResponseEntity<List<ProductStock>>(list,HttpStatus.OK); // 200
			logger.info("getProductStock was called and returned a populated list");
		} else if (list.size() == 0) {
			// list is empty
			returnedEntity = new ResponseEntity<List<ProductStock>>(list,HttpStatus.NO_CONTENT); // 204
			logger.info("getProductStock was called and returned an unpopulated list");
		} else {
			// error
			returnedEntity = new ResponseEntity<List<ProductStock>>(list,HttpStatus.INTERNAL_SERVER_ERROR); // 500
			logger.error("getProductStock was called and there was an error");
		}		
		return returnedEntity;
	}

	/**
	 * @author Jesse
	 * refactored method to save a new product stock to the database.
	 * returns status code 409 if product stock with attempted ID already exists.
	 * returns status 201 if the stock saves successfully.
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/add/{id}",consumes="application/json")
	public ResponseEntity<ProductStock> createStock(@PathVariable int id, @RequestBody ProductStock stock) {
		ResponseEntity<ProductStock> returnedEntity = null;
		Product proj = pManager.findProductById(id);
		LocalDateTime ldt = LocalDateTime.now();
		if(pManager.ifProductExists(id)) {
			// product already exists
			returnedEntity = new ResponseEntity<ProductStock>(stock, HttpStatus.CONFLICT); // 409
		} else {
			stock.setProduct(proj);
			stock.setDateOfTrans(ldt);
			returnedEntity = new ResponseEntity<ProductStock>(stock, HttpStatus.CREATED); // 201
		}		
		return returnedEntity;
	}
		
}
