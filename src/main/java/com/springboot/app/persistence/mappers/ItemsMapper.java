package com.springboot.app.persistence.mappers;


import com.springboot.app.persistence.models.*;

import java.util.List;
/**
 * Interfaz mapper de ItemModel, recibe una cadena de objetos.
 * @author Lenovo
 */
public interface ItemsMapper {
    
    public List<ItemsModel> itemMapper(ItemsModel obj) throws Exception;
    
    public List<ItemsModel> allItemsMapper(ItemsModel obj) throws Exception;
    
     public List<ItemsModel> itemNumMapper(ItemsModel obj) throws Exception;
     
     
     /**
      * Añade un item a una lista de items
      * @param obj
      * @return
      * @throws Exception
      */
     public int insertItemsMapper (ItemsModel obj) throws Exception;
     
     /**
      * Elimina un item de una lista de items
      * @param obj
      * @return
      * @throws Exception
      */
     public int deleteItemsMapper (ItemsModel obj) throws Exception;
     
     /**
      * Actualiza un item de una lista de items.
      * @param obj
      * @return
      * @throws Exception
      */
     public int updateItemsMapper (ItemsModel obj) throws Exception;
     
}
