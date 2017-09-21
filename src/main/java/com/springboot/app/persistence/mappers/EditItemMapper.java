package com.springboot.app.persistence.mappers;

import java.util.List;

import com.springboot.app.persistence.models.ItemsModel;
import com.springboot.app.persistence.models.TestModel;

public interface EditItemMapper {
	
	 public List<TestModel> getTableName(TestModel obj) throws Exception;
	 
	 public List<ItemsModel> getAllItemsFromTable(String tablaBuscador) throws Exception;

}
