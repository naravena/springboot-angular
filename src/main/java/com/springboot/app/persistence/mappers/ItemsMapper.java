package com.springboot.app.persistence.mappers;


import com.springboot.app.persistence.models.*;

import java.util.List;
/**
 * Interfaz mapper de ItemModel, recibe una cadena de objetos.
 * @author Lenovo
 */
public interface ItemsMapper {
    
    public List<ItemModel> itemMapper(ItemModel obj) throws Exception;
    
    public List<ItemModel> allItemsMapper(ItemModel obj) throws Exception;
    
     public List<ItemModel> itemNumMapper(ItemModel obj) throws Exception;
     
     public List<ItemModel> addItemMapper (ItemModel obj) throws Exception;
     
}
