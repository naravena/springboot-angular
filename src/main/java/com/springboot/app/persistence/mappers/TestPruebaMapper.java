package com.springboot.app.persistence.mappers;

import com.springboot.app.persistence.models.ItemsModel;
import com.springboot.app.persistence.models.TestPruebaModel;

public interface TestPruebaMapper  {
	
	public TestPruebaModel insertTestPruebaMapper (ItemsModel obj) throws Exception;
}
