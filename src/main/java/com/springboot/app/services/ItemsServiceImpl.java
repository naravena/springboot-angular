package com.springboot.app.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.persistence.mappers.ItemsMapper;
import com.springboot.app.persistence.models.ItemModel;

/**
 * Servicios que recibirÃ¡ la clase Item. 
 * @author Lenovo
 */
@Service
public class ItemsServiceImpl implements ItemsService{
    
  @Autowired
  ItemsMapper itemMapper;


/**
 * Servicio que recibe una lista de objetos de ItemModel,
 * y devuelve una copia usando el mapper.
 * @param obj
 * @return
 * @throws Exception 
 */
  @Override
  public List<ItemModel> itemService(ItemModel obj) throws Exception
  {
    List<ItemModel> x = itemMapper.itemMapper(obj);
    
    
    for (int i = 0; i < x.size(); i++) {
               x.get(i).setNombre(x.get(i).getNombre().replaceAll("" + obj.getDatoBuscador() + 
                        "","<span class=\"sub\">" + obj.getDatoBuscador() + "</span>"));
               x.get(i).setDescripcion(x.get(i).getDescripcion().replaceAll("" + obj.getDatoBuscador() + 
                        "","<span class=\"sub\">" + obj.getDatoBuscador() + "</span>"));
               
            }
      System.out.println("Contenido de X.SIZE: " + x.size());
             
    return x;
    
  }
   
//    private void itemReplace (ItemModel obj) throws Exception{
//  
//       List<ItemModel> x = itemMapper.itemMapper(obj);
//       obj.getDatoBuscador();
//            for (int i = 0; i < x.size(); i++) {
//                x.get(i).getNombre().replaceAll("" + obj.getDatoBuscador() + 
//                        "","<span class='sub'>" + obj.getDatoBuscador() + "<span>");
//            }
//        
//    }
  
  
  
/**
 * Servicio que devuelve un array de items por defecto
 * @param obj
 * @return
 * @throws Exception 
 */
    @Override
    public List<ItemModel> AllItemService(ItemModel obj) throws Exception {
       
           List<ItemModel> x = itemMapper.allItemsMapper(obj);
    return x;
    }

    
    /**
     * Servicio que recibe un objeto numerico
     * @param obj
     * @return
     * @throws Exception 
     */
    @Override
    public List<ItemModel> itemNum(ItemModel obj) throws Exception {
        
           List<ItemModel> x = itemMapper.itemNumMapper(obj);
    return x;
    }

	@Override
	public List<ItemModel> addItem(ItemModel obj) throws Exception {
		List<ItemModel> x = itemMapper.addItemMapper(obj);
		return x;
	}


   
}
