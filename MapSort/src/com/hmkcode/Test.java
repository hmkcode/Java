package com.hmkcode;


import java.util.HashMap;
import java.util.Map;

public class Test {
public static void main(String[] args){
  	
  	/* Creating HashMap with Generic concept in mind is always advisable to improve the readability of the code 
    and it also avoids if someone accidently add any other type of element into HashMap like Integer, Integer type :) */
  	Map<String, Integer> map = new HashMap<String, Integer>();
  
  	//*value Class should implements the Comparable interface
  	//*String implements Comparable by default.
  	
  	map.put("Z", "3");
  	map.put("D", "4");
  	map.put("A", "1");
  	map.put("B", "2");
  	map.put("F", "6");
  	map.put("E", "5");
  			
  	System.out.println("Unsorted Map: "+map);
  	System.out.println("Sorted Map By Values: "+MapSort.sortByValue(map));
  	System.out.println("Sorted Map By Keys: "+MapSort.sortByKey(map));
  		
  }
}
