package project.two.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import project.two.models.Product;
import project.two.services.ProductService;

@RestController
@RequestMapping(path="/under-min-limit", produces="application/json")
public class MinLimitController {

	private static final Logger logger = LogManager.getLogger(ProductStockController.class.getName());
	
	
	
	@Autowired
	private ProductService productManager;
	
	
	@GetMapping
	public ArrayList<Product> getProductsUnderMinimumLimit() {
		ArrayList<Product> productList = new ArrayList<>();
		RestTemplate rest = new RestTemplate();
		
		String ps5Url = "http://localhost:8080/stock/ps5";
		String xbxUrl = "http://localhost:8080/stock/ps5";
		String nsUrl = "http://localhost:8080/stock/ns";
		
		ResponseEntity<Integer[]> ps5Entity = rest.getForEntity(ps5Url, Integer[].class);
		ResponseEntity<Integer[]> xbxEntity = rest.getForEntity(xbxUrl, Integer[].class);
		ResponseEntity<Integer[]> nsEntity = rest.getForEntity(nsUrl, Integer[].class);
		
		Integer[] ps5Data = ps5Entity.getBody();
		Integer[] xbxData = xbxEntity.getBody();
		Integer[] nsData = nsEntity.getBody();
		
		Integer[][] dataArray = {ps5Data, xbxData, nsData};
		
		for(int ph = 0; ph < dataArray.length; ph++) {
			int ph2 = ph + 1;
			if(determineIfUnderML(dataArray[ph])) {
				Product productUnderLimit = productManager.findProductById(ph2);
				productList.add(productUnderLimit);
			}
		}
		
		System.out.println(productList);
		
		return productList;
		//return ps5Entity.getBody();
	}
	
	private boolean determineIfUnderML(Integer[] intArr) {
		int productid = intArr[0];
		int productQuantity = intArr[1];
		boolean state = false;
		if(productQuantity < 10 ) {
			state = true;
		}
		return state;
	}
}
