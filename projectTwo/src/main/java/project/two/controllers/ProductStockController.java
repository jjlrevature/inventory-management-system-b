package project.two.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.two.models.ProductStock;
import project.two.services.ProductStockManager;

@RestController
@RequestMapping(path="/stock", produces="application/json")
public class ProductStockController {

	@Autowired
	private ProductStockManager psManager;	
	
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
