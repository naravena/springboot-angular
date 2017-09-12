package com.springboot.app.controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.app.persistence.models.ItemsModel;
import com.springboot.app.services.ItemsService;

@Controller
public class ItemController {

    @Autowired
    ItemsService itemService;

    
     int cont= 0;  

    
    @ResponseBody
    @RequestMapping(value = "/item",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemsModel> item(@RequestBody ItemsModel obj) throws Exception {
      //  System.out.println("Texto dirección mapper: " + obj.getNombre());
        List<ItemsModel> x = itemService.itemService(obj);
       
        
//      if(x.size() > 0)
//      { 
//          System.out.println("Text de vuelta mapper, itemcontroller: \n ID: " + x.get(0).getId() +"\n Nombre: "+ x.get(0).getNombre());
//      } 

        return x;
    }
    

    
    @ResponseBody
    @RequestMapping(value = "/allItems",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemsModel> allItems(@RequestBody ItemsModel obj) throws Exception {
      
        List<ItemsModel> x = itemService.AllItemService(obj);
     
        return x;
    }
    
        @ResponseBody
    @RequestMapping(value = "/itemNum",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemsModel> itemNum(@RequestBody ItemsModel obj) throws Exception {
       
        
        List<ItemsModel> x = itemService.itemNum(obj);
     
        return x;
    }
    
    
        @ResponseBody
        @RequestMapping(value = "/insertItems",
                method = RequestMethod.POST,
                produces = MediaType.APPLICATION_JSON_VALUE)
        public int insertItems(@RequestBody ItemsModel obj) throws Exception {
 
            int x = itemService.insertItemsService(obj);
         
            return x;
        }
            
        
        
        
        
    
}
