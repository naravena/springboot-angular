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
import com.springboot.app.utils.UtilStr;

/**
 * Servicios que recibira la clase Item.
 * 
 * @author Lenovo
 */
@Service
public class ItemsServiceImpl implements ItemsService {

	@Autowired
	ItemsMapper itemMapper;

	/**
	 * Servicio que recibe una lista de objetos de ItemModel, y devuelve una copia
	 * usando el mapper.
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<ItemsModel> itemService(ItemsModel obj) throws Exception {

		List<ItemsModel> listaItems = itemMapper.itemMapper(obj);

		List<ItemsModel> list = this.replaceSearch(obj, listaItems);

		return list;

		

	}

	/**
	 * Servicio que devuelve un array de items por defecto
	 * 
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
	 * 
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
	 * @param obj
	 *            Cadena a buscar.
	 * @param x
	 *            Lista a reemplazar.
	 *
	 * @return Lista de items reemplazada.
	 */
	private List<ItemsModel> replaceSearch(ItemsModel obj, List<ItemsModel> listaItems) {
		// Creo una lista vacía, que voy a rellenar con los datos reemplazados.
		List<ItemsModel> repList = new ArrayList<ItemsModel>();
		
		
		// Recorre la lista de items
		for (ItemsModel item : listaItems) {
			
			boolean boolNom = false;
			boolean boolDesc = false;
			//String clase CSS
			String redText = "redText";
			// String que recoge los nombres originales.
			String objOrigen = obj.getDatoBuscador();
			String itemOrigen = item.getNombre();
			
			//Descripcion
			String objOrigenDesc = obj.getDatoBuscador();
			String itemOrigenDesc = item.getDescripcion();
			
			//Descripcion Normalizer
			String objRepDesc = UtilStr.normalizerStr(objOrigenDesc);
			String itemRepDesc = UtilStr.normalizerStr(itemOrigenDesc);
			
			
			// String que recoge los nombres reemplazados (normaliza).
			String objRep = UtilStr.normalizerStr(objOrigen);
			String itemRep = UtilStr.normalizerStr(itemOrigen);		
		
			
			// Comprobar la busqueda con la base de datos
			Matcher n = UtilStr.compare(objOrigen , itemRep);
			
			// Si encuentra nombre
			if (n.find()) {
				
				itemOrigen = itemOrigen.substring(n.start(), n.end());
				
				item.setNombre(UtilStr.patternCaseInsensitive(objOrigen)
						.matcher(itemRep).replaceAll(UtilStr.spanHtml(itemOrigen , redText)));
				
				boolNom = true;
			
			}
			
			// Descripcion			
			
			Matcher d = UtilStr.compare(objRepDesc , itemRepDesc);
			if(d.find()) {
				
				itemOrigenDesc = itemOrigenDesc.substring(d.start(), d.end());
				
				item.setDescripcion(UtilStr.patternCaseInsensitive(objRepDesc)
						.matcher(itemRepDesc).replaceAll(UtilStr.spanHtml(itemOrigenDesc , redText)));
			
				boolDesc = true;
			}	
			
			if(boolNom || boolDesc) {
				repList.add(item);		
			}
			

		}

	
		return repList;
	}


}
