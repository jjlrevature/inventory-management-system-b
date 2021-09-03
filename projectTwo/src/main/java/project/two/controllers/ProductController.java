package project.two.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.two.dao.ProductDAO;
import project.two.models.Product;
import project.two.models.ProductStock;
import project.two.services.ProductService;

@RestController
@RequestMapping(path="/products")
public class ProductController {

	@Autowired
	private ProductService prodService;
	
	@Autowired
	private ProductDAO pDao;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="inDemand", produces="application/json")
	public ResponseEntity<Object> getOnDemand() {
		return new ResponseEntity<Object>(prodService.getOnDemand(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/add",consumes="application/json")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		try {
			Product add = prodService.addProduct(product);
			return new ResponseEntity<>(add, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required = false) String title) {
		return null;	
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
		return null;
	}
	/*
	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		return null;
	}*/
	
	
}
