package com.hmkcode.spring.mybatis;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hmkcode.spring.mybatis.service.Service;
import com.hmkcode.spring.mybatis.vo.MyObject;


public class App 
{
	private static Log log = LogFactory.getLog(App.class);

    public static void main( String[] args )
    {

    	ApplicationContext cxt = new ClassPathXmlApplicationContext("spring-config.xml");
    	Service service = (Service) cxt.getBean("service");
		
    	log.info("Running App...");

    	
    	//( 1 ) INSERT MYOBJECT
    	System.out.println("( 1 ) insertMyObject(myObject)");
    	MyObject myObject = new MyObject();
    	myObject.setObjectName("name-2");
    	service.insertMyObject(myObject);
    	System.out.println("myObject.objectId = "+myObject.getObjectId());
    	
    	System.out.println("\n********************************\n");
    	
    	//( 2 ) INSERT MYOBJECT
    	System.out.println("( 2 ) insertMyObject_Annotation(myObject)");
    	myObject = new MyObject();
    	myObject.setObjectName("name-3");
    	service.insertMyObject_Annotation(myObject);
    	System.out.println("myObject.objectId = "+myObject.getObjectId());
    	
    	System.out.println("\n********************************\n");
    	
    	//( 3 ) SELECT ALL MYOBJECTS
    	System.out.println("( 3 ) selectAllMyObjects()");
    	List<MyObject> myObjects = service.selectAllMyObjects();
    	System.out.println(myObjects);
    
    	
    }
}
