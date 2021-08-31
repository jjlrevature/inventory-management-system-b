package com.groupb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/jinx")
public class simple {

	
	@GetMapping
	public String jay() {
		return "jay";
	}
}
