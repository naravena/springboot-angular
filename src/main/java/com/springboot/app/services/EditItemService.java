package com.springboot.app.services;


import java.util.List;

import com.springboot.app.persistence.models.ItemsModel;
import com.springboot.app.persistence.models.TestModel;


public interface EditItemService {
	
	public List<TestModel> getTableName (TestModel obj) throws Exception;
	
	public List<ItemsModel> getAllItemsFromTable (String tablaBuscador) throws Exception;
	
	
}
