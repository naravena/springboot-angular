package com.springboot.app.persistence.mappers;

import java.util.List;
import java.util.Map;

import com.springboot.app.persistence.models.TestModel;

public interface EditItemMapper {
	
	 public List<TestModel> getTableName(TestModel obj) throws Exception;
	 
	 public List<Map<String, Object>> getAllItemsFromTable(TestModel tablaBuscador) throws Exception;

}
