package com.hmkcode.spring.mybatis.vo;

import org.apache.ibatis.type.Alias;

//@Alias("MyObject") will be used by /src/resources/com/hmkcode/spring/mybatis/mybatis-config.xml
@Alias("MyObject") 
public class MyObject {

	private int objectId;
	private String objectName;
	
	public int getObjectId() {
		return objectId;
	}

	public void setObjectId(int objectId) {
		this.objectId = objectId;
	}

	public String getObjectName() {
		return objectName;
	}
	
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String toString(){
		return "\n Object [ id: "+this.objectId+" - name: "+this.objectName+ "\n]"; 
	}
}
