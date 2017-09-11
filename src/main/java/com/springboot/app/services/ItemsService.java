package com.springboot.app.services;

import java.util.List;

import com.springboot.app.persistence.models.ItemModel;
 
/**
 * Servicios de la clase Item
 * @author Lenovo
 */
public interface ItemsService {
    
    public List<ItemModel> itemService(ItemModel obj) throws Exception;
            
    /**Recoge todos los items de una tabla.
     *   
     * @param obj
     * @return
     * @throws Exception
     */
    public List<ItemModel> AllItemService(ItemModel obj) throws Exception;
  
    public List<ItemModel> itemNum (ItemModel obj) throws Exception;
    
    
}
