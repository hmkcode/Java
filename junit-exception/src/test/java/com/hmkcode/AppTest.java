package com.hmkcode;

import java.util.LinkedList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.is;



@RunWith(JUnit4.class)
public class AppTest 
{
  
	 // ( 1 ) Simple way to test exception
	 @Test(expected= NullPointerException.class) 
	  public void testNull() { 
	       String str = null;
	       str.toUpperCase();
	  }
	 
	 // ( 2 ) Test by tyr/catch (test exception message)
	 @Test
	 public void testExceptionMessage(){
		 try{
			 new LinkedList<Object>().get(0);

			 //if no exception thrown the test will fail with the below message.
			 fail("Expected an IndexOutOfBoundsException to be thrown");
			 
	      } catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
	    	 
	    	  //if no exception message is not the same the test will fail with the below message.
	          assertThat(anIndexOutOfBoundsException.getMessage(), is("Index: 0, Size: 0"));
	      }

	 }
	 
	 //( 3 ) Test by @Rule & ExpectedException.expect() | ExpectedException.expectMessage()
	  @Rule
	  public ExpectedException thrown = ExpectedException.none();

	  @Test
	  public void testExceptionByRule() throws ArithmeticException {
		  
	        thrown.expect(ArithmeticException.class);
	        thrown.expectMessage("/ by zero");
	        
	    	double d = 1 / 0;
	   }


}
