package project.two.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
