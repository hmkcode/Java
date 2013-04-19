package com.hmkcode.junit;

import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.is;


/**
 * Tests for {@link Math}.
 *
 * @author hmkcode@gmail.com (Hani HMK)
 */
@RunWith(JUnit4.class)
public class MathTest {

   @Rule
   public Timeout globalTimeout = new Timeout(3000); // 3 seconds max per method tested

  
  com.hmkcode.junit.Math math = new com.hmkcode.junit.Math();

  
  @Test
  @Ignore
   public void testAssertNotNull() {
      org.junit.Assert.assertNotNull("should not be null", math);
  }

    @Test
    public void testSum(){
      org.junit.Assert.assertTrue("failure - not equal", math.sum(3, 2) == 5);
      
      //to test timeout
      /*for (;;) {
        }*/
    }
    
    @Test
    public void testMultiply(){
       org.junit.Assert.assertTrue("failure - not equal", math.multiply(3, 2) == 6);
    }
    
    @Test
    public void testDivide(){
      double x = 3,y = 2;
      assertThat("failure - can't divide by 0",y, is(not(0.0)));
      org.junit.Assert.assertTrue("failure - not equal", math.divide(x, y) == 1.5);
    }
    
    @Test
    public void testSubtract(){
       org.junit.Assert.assertTrue("failure - not equal", math.subtract(3, 2) == 1);
    }
    
  
}