package com.hmkcode.spring.mybatis;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hmkcode.spring.mybatis.service.Service;
import com.hmkcode.spring.mybatis.vo.MyObject;



import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;;

/**
 * Unit test for simple App.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/spring-config.xml")
public class AppTest {

	private static Log log = LogFactory.getLog(AppTest.class);
	
	@Autowired private Service service;


	@Test
	public void testSelectAllMyObjects(){
		log.info("testing selectAllParent()...");
		
		List<MyObject> objects = service.selectAllMyObjects();
		
		assertNotNull("failure - object is null", objects);
		
		assertTrue("failure - expected 1 object", objects.size() == 1);

		log.info(objects);
	}
}
