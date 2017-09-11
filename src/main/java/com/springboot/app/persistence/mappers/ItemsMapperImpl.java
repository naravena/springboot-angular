/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springboot.app.persistence.mappers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import com.springboot.app.persistence.models.ItemModel;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Mapper de ItemModel, recibe una cadena de objetos.
 *
 * @author Lenovo
 */
@Repository
public class ItemsMapperImpl implements ItemsMapper {

    //Inyecto la base de datos
    @Autowired
    JdbcTemplate JdbcTemplate;

    //Metodo que recibe una lista de objetos y la devuelve dependiendo del nombre
    //escrito por teclado.
    @Override
    public List<ItemModel> itemMapper(ItemModel obj) throws Exception {

        /**
         * Consulta que selecciona de la tabla items dependiendo de los datos en
         * el buscador. Busca tanto en la columna "nombre" como en
         * "descripcion".
         */
        String sql = "SELECT * "
                + "FROM items "
                + "WHERE (nombre LIKE '%" + obj.getDatoBuscador() + "%')"
                + "OR (descripcion LIKE '%" + obj.getDatoBuscador() + "%')";

        System.out.println("Datos del datobuscador: " + obj.getDatoBuscador());
 
   return JdbcTemplate.query(sql, new BeanPropertyRowMapper(ItemModel.class));
   
    }

    /**
     * Metodo que selecciona todo de la tabla items.
     *
     * @param obj
     * @return list
     * @throws Exception
     */
    @Override
    public List<ItemModel> allItemsMapper(ItemModel obj) throws Exception {

   
        String sql = "SELECT * FROM items";

        return JdbcTemplate.query(sql, new BeanPropertyRowMapper(ItemModel.class));
    }

    /**Metodo que recoge un objeto numerico y lo va a devolver en una
     * consulta anidada que lo devuelve por peso.
     *
     * @param obj
     * @return
     * @throws Exception
     */
    @Override
    public List<ItemModel> itemNumMapper(ItemModel obj) throws Exception {
    
        
      
          String sql = "SELECT * "
                       + " FROM items "
                       + "WHERE id " 
                         + " IN "
                             + "(SELECT iditems " 
                              + " FROM pesoitems "
                                  + " WHERE peso = 500)" ;
          
       

          return JdbcTemplate.query(sql, new BeanPropertyRowMapper(ItemModel.class));
    }

	@Override
	public List<ItemModel> addItemMapper(ItemModel obj) throws Exception {
		

		  String sql = "UPDATE items" +
				  		"SET nombre = 'prueba'" +
				  		"WHERE id = 1";

	        System.out.println("Datos del datobuscador: " + obj.getDatoBuscador());
	 
	   return JdbcTemplate.query(sql, new BeanPropertyRowMapper(ItemModel.class));
	}
}



 /**
         * Recorre las tablas dentro de la base de datos (Spring). Asi saco los
         * nombres de las tablas.
         */
//        for (int i = 0; i < db.tablas().size(); i++) {
//            
//             tablaNombre.setNombre(db.tablas().get(i)); 
//        }
//        
//        System.out.println("mapper: " + tablaNombre.getNombre());
//                
//        
        //CONSULTA SQL, devuelve todo el contenido de la tabla items.
        // String sql = "SELECT * FROM ITEMS WHERE ID" + this.getId();

