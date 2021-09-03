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

	@GetMapping
	public List<ProductStock> getStock(){
		return psManager.getStock();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path="/{productId}",produces="application/json")
	public int getItemCurrentStockById(@PathVariable int productId) {
		List<ProductStock> product = pDao.getById(productId).getStock();
		int total = getTotal(product);
		return total;		
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
	
//	@PostMapping(value="/add2",consumes="application/json")
//	public ResponseEntity<ProductStock> createStock2(@RequestBody ProductStock stock) {
//		try {
//			Product proj = dao.findById(new Integer(2)).get();
//			stock.setProduct(proj);
//			Date time = new Date();
//			stock.setDateOfTrans(time);
//			ProductStock add = pDao.save(stock);
//			return new ResponseEntity<>(add, HttpStatus.CREATED);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//	
//	@PostMapping(value="/add3",consumes="application/json")
//	public ResponseEntity<ProductStock> createStock3(@RequestBody ProductStock stock) {
//		try {
//			Product proj = dao.findById(new Integer(3)).get();
//
//			stock.setProduct(proj);
//			Date time = new Date();
//			stock.setDateOfTrans(time);
//			ProductStock add = repo		
//					.save(stock);
//			return new ResponseEntity<>(add, HttpStatus.CREATED);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//	
//	@PostMapping(value="/add3",consumes="application/json")
//	public ResponseEntity<ProductStock> createStock4(@RequestBody ProductStock stock) {
//		try {
//			Product proj = dao.findById(new Integer(4)).get();
//
//			stock.setProduct(proj);
//			Date time = new Date();
//			stock.setDateOfTrans(time);
//			ProductStock add = repo		
//					.save(stock);
//			return new ResponseEntity<>(add, HttpStatus.CREATED);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
//	
//	@PostMapping(value="/add3",consumes="application/json")
//	public ResponseEntity<ProductStock> createStock5(@RequestBody ProductStock stock) {
//		try {
//			Product proj = dao.findById(new Integer(5)).get();
//
//			stock.setProduct(proj);
//			Date time = new Date();
//			stock.setDateOfTrans(time);
//			ProductStock add = repo		
//					.save(stock);
//			return new ResponseEntity<>(add, HttpStatus.CREATED);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	
	@GetMapping(path="/ps5",produces="application/json")
	public int[] getPs5Stock() {
		List<ProductStock> ps5List = psManager.getPlaystation5InStock();
		int total = getTotal(ps5List);
		int[] returnObj = {1,total};
		return returnObj;
	}
	
	@GetMapping(path="/xbx",produces="application/json")
	public int[] getXbxStock() {
		List<ProductStock> xbxList = psManager.getXboxSeriesXInStock();
		int total = getTotal(xbxList);
		int[] returnObj = {2,total};
		return returnObj;
	}
	
	@GetMapping(path="/ns",produces="application/json")
	public int[] getNsStock() {
		List<ProductStock> nsList = psManager.getNintendoSwitchInStock();	
		int total = getTotal(nsList);
		int[] returnObj = {3,total};
		return returnObj;
	}
	

}
