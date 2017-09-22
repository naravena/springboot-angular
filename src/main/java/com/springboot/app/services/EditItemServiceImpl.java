package com.springboot.app.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.persistence.mappers.EditItemMapper;
import com.springboot.app.persistence.models.ItemsModel;
import com.springboot.app.persistence.models.TestModel;

@Service
public class EditItemServiceImpl implements EditItemService{

	@Autowired
	EditItemMapper editItemMapper;

	@Override
	public List<TestModel> getTableName(TestModel obj) throws Exception {
		
		List<TestModel> x = editItemMapper.getTableName(obj);
		
		return x;
	}

	@Override
	public List<Map<String, Object>> getAllItemsFromTable(TestModel tablaBuscador) throws Exception {
		List<Map<String, Object>> x = editItemMapper.getAllItemsFromTable(tablaBuscador);
		return x;
	}

}
