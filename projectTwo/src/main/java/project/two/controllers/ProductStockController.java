package project.two.controllers;

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
	
	
	private int getTotal(List<ProductStock> plist) {
		logger.info("Calculating total quantity");
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

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public List<ProductStock> getStock(){
		logger.info("Recieved request for Product Stocks");
		return psManager.getStock();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/add/{id}",consumes="application/json")
	public ResponseEntity<ProductStock> createStock(@PathVariable int id, @RequestBody ProductStock stock) {
		try {
			Product proj = pManager.findProductById(id);
			if(proj != null) {
				stock.setProduct(proj);
				Date time = new Date();
				stock.setDateOfTrans(time);
				ProductStock add = psManager.addStock(stock);
				return new ResponseEntity<>(add, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
