package com.springboot.app.persistence.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.app.persistence.models.ItemsModel;
import com.springboot.app.persistence.models.*;
import com.springboot.app.utils.UtilStr;
@Repository
public class TestPruebaMapperImpl implements TestPruebaMapper{

	@Autowired
	JdbcTemplate JdbcTemplate;
	
	@Override
	public TestPruebaModel insertTestPruebaMapper(ItemsModel obj) throws Exception {
		
		TestPruebaModel x = new TestPruebaModel();	
		
		System.out.println("\n --------------\nEntra en insertItemsMapper\n --------------\n");
		String sql = UtilStr.replaceSpacesToOneSpace(" INSERT INTO items " + " (nombre, " + "  descripcion, " + "  url) " + " VALUES " + " ('"
						+ obj.getNombre() + "'" + " ,'" + obj.getDescripcion() + "'" + " ,'" + obj.getUrl() + "')");

		
		x.setUpdateStr(JdbcTemplate.update(sql));
		return x;
	}


	

}
