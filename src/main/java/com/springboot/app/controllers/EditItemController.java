package com.springboot.app.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.app.persistence.models.ItemsModel;
import com.springboot.app.persistence.models.TestModel;
import com.springboot.app.services.EditItemService;

import com.springboot.app.services.TestService;

@Controller
public class EditItemController {


	  @Autowired
	  EditItemService editItemService;


	  @ResponseBody
	  @RequestMapping(value = "/getTableName",
	                  method = RequestMethod.POST,
	                  produces = MediaType.APPLICATION_JSON_VALUE)
	  //Siempre recibe un modelo (objeto del modelo testModel)
	  public List<TestModel> getTableName(@RequestBody TestModel obj) throws Exception
	  {
	    List<TestModel> x = editItemService.getTableName(obj);
	      System.out.println(obj.getTable());
	      
	    return x;
	  }
	  
	  
	  /**
	   * Envia un String, que es el nombre de la tabla seleccionada y devuelve 
	   * el contenido de la misma en una lista de items.
	   * 
	   * @param tablaBuscador
	   * @return list<ItemsModel>
	   * 
	   */
	  @ResponseBody
		@RequestMapping(value = "/getAllItemsFromTable", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Map<String, Object>> getAllItems(@RequestBody TestModel tablaBuscador) throws Exception {
			System.out.println("\n --------------\nEntra en el controlador\n --------------\n");
			List<Map<String, Object>> x = editItemService.getAllItemsFromTable(tablaBuscador);
			
	
			return x;
		}

	}
