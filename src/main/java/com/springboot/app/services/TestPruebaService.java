package com.springboot.app.services;

import com.springboot.app.persistence.models.ItemsModel;
import com.springboot.app.persistence.models.TestPruebaModel;

public interface TestPruebaService {

	public TestPruebaModel insertTestPrueba (ItemsModel obj) throws Exception;
	
}
