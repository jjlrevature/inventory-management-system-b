package project.two.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
		logger.info("Recieved Request for Items in Demand");
		return new ResponseEntity<Object>(prodService.getInDemand(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="", produces="application/json")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> list = prodService.getAllProducts();
		for(int x = 0; x < list.size(); x++) {
			int y = x + 1;
			List<ProductStock> pStock = list.get(x).getStock();
			int total = getTotal(pStock);
			list.get(x).setCurrentStock(total);
		}
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/addProduct",consumes="application/json")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		try {
			Product add = prodService.addProduct(product);
			return new ResponseEntity<>(add, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	private int getTotal(List<ProductStock> plist) {
		int total = 0;
		for(int x = 0; x < plist.size(); x++) {
			int newQuantity = plist.get(x).getQuantity();
			if(newQuantity < 0) {				
				total = total - Math.abs(newQuantity);
			} else {
				total = total + newQuantity;							
			}
		}		
		return total;
	}

	
}
