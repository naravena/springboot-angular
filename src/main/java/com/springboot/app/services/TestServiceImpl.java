package com.springboot.app.services;

import java.util.List;

import com.springboot.app.persistence.mappers.ItemsMapper;
import com.springboot.app.persistence.mappers.TestMapper;
import com.springboot.app.persistence.models.ItemModel;
import com.springboot.app.persistence.models.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TestServiceImpl implements TestService
{

  @Autowired
  TestMapper iMapper;


  @Override
  public List<TestModel> testService(TestModel obj) throws Exception
  {
    List<TestModel> x = iMapper.testMapper(obj);

    return x;
  }

}
