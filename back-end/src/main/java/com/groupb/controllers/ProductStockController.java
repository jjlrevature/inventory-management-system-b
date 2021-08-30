package com.groupb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupb.models.Product;
import com.groupb.models.ProductStock;
import com.groupb.service.ProductManager;
import com.groupb.service.ProductStockManager;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProductStockController {
	@Autowired
	ProductStockManager repo;
	
	@PutMapping("/details/{id}")
	public ResponseEntity<ProductStock> updateTutorial(@PathVariable("id") Integer id, @RequestBody ProductStock details) {
		Optional<ProductStock> Data = repo.findById(id);

		if (Data.isPresent()) {
			ProductStock model = Data.get();
			model.setVendor(details.getVendor());
				return new ResponseEntity<>(repo.save(details), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
