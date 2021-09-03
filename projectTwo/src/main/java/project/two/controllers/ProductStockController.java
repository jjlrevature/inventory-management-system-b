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
import org.springframework.web.bind.annotation.RestController;

import project.two.dao.ProductDAO;
import project.two.models.Product;
import project.two.models.ProductStock;
import project.two.services.ProductStockManager;



@RestController
@RequestMapping(path="/stock", produces="application/json")
public class ProductStockController {

	@Autowired
	private ProductStockManager psManager;	
	
	@Autowired
	private ProductDAO pDao;
	
	

	@GetMapping
	public List<ProductStock> getStock(){
		return psManager.getStock();
	}
	
	@PostMapping(value="/add",consumes="application/json")
	public ResponseEntity<ProductStock> createStock(@RequestBody ProductStock stock) {
		try {
			Product proj = pDao.findById(1).get();
			stock.setProduct(proj);
			Date time = new Date();
			stock.setDateOfTrans(time);
			ProductStock add = psManager.addStock(stock);
			return new ResponseEntity<>(add, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
