package com.springboot.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.app.persistence.models.ItemsModel;
import com.springboot.app.persistence.models.TestPruebaModel;
import com.springboot.app.services.TestPruebaService;

@Controller
public class TestPruebaController {
	
	@Autowired
	TestPruebaService tService;
	
	
	@ResponseBody
	@RequestMapping(value = "/testprueba", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public TestPruebaModel testPrueba(@RequestBody ItemsModel obj) throws Exception {
		System.out.println("\n --------------\nEntra en el controlador\n --------------\n");
		
	

		TestPruebaModel x = tService.insertTestPrueba(obj);
		
		return x;
	}
}
