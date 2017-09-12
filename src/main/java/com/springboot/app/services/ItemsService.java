package com.springboot.app.services;

import java.util.List;

import com.springboot.app.persistence.models.ItemsModel;
 
/**
 * Servicios de la clase Item
 * @author Lenovo
 */
public interface ItemsService {
    
    public List<ItemsModel> itemService(ItemsModel obj) throws Exception;
            
    /**Recoge todos los items de una tabla.
     *   
     * @param obj
     * @return
     * @throws Exception
     */
    public List<ItemsModel> AllItemService(ItemsModel obj) throws Exception;
  
    public List<ItemsModel> itemNum (ItemsModel obj) throws Exception;
    
    /**
     * Funcion que añade un item a la tabla
     * @param obj
     * @return
     * @throws Exception
     */
    public int insertItemsService (ItemsModel obj) throws Exception;
    
    
    
    
}
