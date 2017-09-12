package com.springboot.app.services;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.Normalizer;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.springboot.app.persistence.mappers.ItemsMapper;
import com.springboot.app.persistence.models.ItemsModel;

/**
 * Servicios que recibira la clase Item. 
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
  public List<ItemsModel> itemService(ItemsModel obj) throws Exception
  {
	  
	  List<ItemsModel> x = itemMapper.itemMapper(obj);

	  List<ItemsModel> list = this.replaceSearch(obj, x);

	  return list;
	  
	  
	  
	  
//    List<ItemsModel> x = itemMapper.itemMapper(obj);
//    
//    
//    for (int i = 0; i < x.size(); i++) {
//               x.get(i).setNombre(x.get(i).getNombre().replaceAll("" + obj.getDatoBuscador() + 
//                        "","<span class=\"sub\">" + obj.getDatoBuscador() + "</span>"));
//               x.get(i).setDescripcion(x.get(i).getDescripcion().replaceAll("" + obj.getDatoBuscador() + 
//                        "","<span class=\"sub\">" + obj.getDatoBuscador() + "</span>"));
//               
//            }
//      System.out.println("Contenido de X.SIZE: " + x.size());
//             
//    return x;
    
  }
   

  
  
/**
 * Servicio que devuelve un array de items por defecto
 * @param obj
 * @return
 * @throws Exception 
 */
    @Override
    public List<ItemsModel> AllItemService(ItemsModel obj) throws Exception {
       
           List<ItemsModel> x = itemMapper.allItemsMapper(obj);
    return x;
    }

    
    /**
     * Servicio que recibe un objeto numerico
     * @param obj
     * @return
     * @throws Exception 
     */
    @Override
    public List<ItemsModel> itemNum(ItemsModel obj) throws Exception {
        
           List<ItemsModel> x = itemMapper.itemNumMapper(obj);
    return x;
    }
    
    /**
     * Servicio que inserta un item en la tabla items
     */
	@Override
	public int insertItemsService(ItemsModel obj) throws Exception {
		int x = itemMapper.insertItemsMapper(obj);
		return x;
	}


	/**
	   * METODO PARA REEMPLAZAR LA CADENA BUSCADA EN UNA LISTA DE ITEMS.
	   *
	   * @param obj Cadena a buscar.
	   * @param x   Lista a reemplazar.
	   *
	   * @return Lista de items reemplazada.
	   */
	  private List<ItemsModel> replaceSearch(ItemsModel obj, List<ItemsModel> listaItems)
	  {
		 //Creo una lista vacía, que voy a rellenar con los datos reemplazados. 
		  List<ItemsModel> repList = new ArrayList<>();
		  repList = null;
		  String nombre = obj.getNombre();
		
		//Recorre la lista de items
	    for (ItemsModel item : listaItems) {
	    
	    //Comprobar la busqueda con la base de datos
	    Matcher n = this.pattern(obj.getNombre()).matcher(item.getNombre());
	
	   
	    
	    	  if (n.find()){
	    		  nombre = nombre.substring(n.start(), n.end());
	    		  nombre = this.pattern(obj.getNombre()).matcher(item.getNombre())
	   	              .replaceAll(this.patternReplaceHtml(nombre));
	    	//Añado el item a la nueva lista
	    		  repList.add(item);
	    }		    	
	      item.setNombre(this.replaceStr(obj.getNombre(), item.getNombre()));
	      item.setDescripcion(this.replaceStr(obj.getDescripcion(),
	                                          item.getDescripcion()));
	    }
	    	    
	    //Devuelve la cadena nueva
	    return repList;
	  }


	  /**
	   * METODO PARA REEMPLAZAR LA CADENA BUSCADA EN UN STRING.
	   *
	   * @param obj  Cadena buscada.
	   * @param item Cadena a procesar.
	   *
	   * @return Cadena reemplazada.
	   */
	  private String replaceStr(String obj, String item)
	  {
	    String replace = item;

	    obj = this.replaceChar(obj);
	    item = this.replaceChar(item);

	    Matcher x = this.pattern(obj).matcher(item);

	    if (x.find() && (obj.length() > 0))
	    {
	      replace = replace.substring(x.start(), x.end());
	      replace = this.pattern(obj).matcher(item)
	              .replaceAll(this.patternReplaceHtml(replace));
	    }

	    return replace;
	  }


	  /**
	   * METODO PARA GENERAR UN PATRON.
	   *
	   * @param str Cadena a insertar en el patron de busqueda.
	   *
	   * @return Patron generado.
	   */
	  private Pattern pattern(String str)
	  {
	    return Pattern.compile("(?i)" + str.replaceAll("\\s", ""));
	  }


	  /**
	   * METODO PARA REALIZAR UN REEMPLAZO DE UNA CADENA POR UN TAG HTML.
	   *
	   * @param str Cadena a insertar en el tag.
	   *
	   * @return tag generado en html.
	   */
	  private String patternReplaceHtml(String str)
	  {
	    return "<span class=\"found\">" + str + "</span>";
	  }


	  /**
	   * CONVERSION DEL TEXTO A SU FORMA CANONICAL DECOMPOSITION, REPRESENTANDO LOS
	   * CARACTERES UTF-8 COMPRENDIDOS ENTRE U+0300 HASTA U+036F.
	   * ------------------------------------
	   * <p>
	   * "[^\\p{ASCII}]"
	   * <p>
	   * "[\\p{InCombiningDiacriticalMarks}]"
	   *
	   * -------------------------------------
	   *
	   *
	   * @param str Cadena a procesar.
	   *
	   * @return Cadena convertida a UTF-8.
	   */
	  private String replaceChar(String str)
	  {
	    String normalize = str.replace("ñ", "\001");

	    normalize = Normalizer.normalize(normalize, Normalizer.Form.NFD);
	    normalize = normalize.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

	    normalize = normalize.replace("\001", "ñ");

	    return normalize;
	  }

	
	
	
	
	
	
   
}
