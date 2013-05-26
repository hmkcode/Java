package com.hmkcode.spring.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hmkcode.spring.mybatis.mapper.Mapper;
import com.hmkcode.spring.mybatis.vo.MyObject;



public class Service {
	
	@Autowired 
	private Mapper mapper;

	public int insertMyObject(MyObject myObject){
		return mapper.insertMyObject(myObject);
	}

	public int insertMyObject_Annotation(MyObject myObject){
		return mapper.insertMyObject_Annotation(myObject);
	}
	public List<MyObject> selectAllMyObjects(){
		return mapper.selectAllMyObjects();
	}
	
}
