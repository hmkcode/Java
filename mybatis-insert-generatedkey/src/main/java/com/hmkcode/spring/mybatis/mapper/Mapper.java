package com.hmkcode.spring.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.hmkcode.spring.mybatis.vo.MyObject;


public interface Mapper {

	//if @Select is used table.column (name) & class.property (name) should be the same

	
	@Select("SELECT * FROM myobject_table")
	public List<MyObject> selectAllMyObjects();
	
	
	//SQL query in "Mapper.xml"
	public int insertMyObject(MyObject myObject);

	@Insert("INSERT INTO myobject_table (objectId,objectName) VALUES (#{objectId}, #{objectName})") 
	@SelectKey(statement="SELECT nextVal('my_sequence')", keyProperty="objectId", before=true, resultType=int.class) 
	int insertMyObject_Annotation(MyObject myObject);
}

