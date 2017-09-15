package com.springboot.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.persistence.mappers.TestPruebaMapper;
import com.springboot.app.persistence.models.ItemsModel;
import com.springboot.app.persistence.models.TestPruebaModel;
@Service
public class TestPruebaServiceImpl implements TestPruebaService{

	@Autowired
	TestPruebaMapper tMapper;
	
	@Override
	public TestPruebaModel insertTestPrueba(ItemsModel obj) throws Exception {
		
		TestPruebaModel x = tMapper.insertTestPruebaMapper(obj);
		return x;
	}


}
