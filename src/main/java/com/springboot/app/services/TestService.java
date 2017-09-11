package com.springboot.app.services;

import java.util.List;

import com.springboot.app.persistence.models.TestModel;


public interface TestService
{

  public List<TestModel> testService(TestModel obj) throws Exception;

}
