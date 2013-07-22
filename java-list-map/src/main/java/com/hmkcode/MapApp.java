package com.hmkcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


import com.hmkcode.vo.Person;


public class MapApp 
{
	
    public static void main( String[] args )
    {
       
        
        // ( 1 ) Map
        
        // A. Initiate
        Map<String,Person> hashMap = new HashMap<String,Person>();
        Map<String,Person> treeMap = new TreeMap<String,Person>();
        
        // B. Populate
        int k = 0 ;
        for(Person person:getPersons()){
        	hashMap.put(""+k,person);
        	treeMap.put(""+k++,person);
        }
        
        // --> print
        System.out.println("--------- Print All -------------");      
        System.out.println("HashMap: "+hashMap);
        System.out.println("TreeMap: "+treeMap);


        // C. Iterate
        // --> print
    	System.out.println("--------- Print Iterate by get(key) -------------");     
        for(String key:treeMap.keySet()){
        		
        	System.out.println("treeMap: [key: "+key+" , value: "+treeMap.get(key));
        }
        // --> print
    	System.out.println("--------- Print Iterate by Entry -------------");  
        for(Entry<String, Person> entry:treeMap.entrySet()){
    		
        	System.out.println("treeMap: [key: "+entry.getKey()+" , value: "+entry.getValue());
        }   
                        
        // D. Sort by value
        TreeMap<String,Person> sorted_map = new TreeMap<String,Person>(new ValueComparator());
        sorted_map.putAll(hashMap);
                
        
        // --> print
        System.out.println("--------- Print Sorted Map by Value -------------");       
        System.out.println("Sorted HashMap: "+sorted_map);
        
        
        // E. Convert Map to List
        
        List<Person> persons = new ArrayList<Person>(sorted_map.values());
        
        // --> print
        System.out.println("--------- Print List<Person> -------------");
        System.out.println("List<Person>: "+persons);
    }
    
    private static Person[] getPersons(){
    	Person[] persons = new Person[5];
    	
    	persons[0] = new Person("Brit", 29);
    	persons[1] = new Person("John", 32);
    	persons[2] = new Person("Jack", 27);
    	persons[3] = new Person("Jenifer", 24);
    	persons[4] = new Person("Brit", 37);

    	return persons;
    }
}
class ValueComparator implements Comparator {
	  
	  Map map;
	  
	  public ValueComparator(){
	  	
	  }
	  public int compare(Object keyA, Object keyB){
	  		  	
	  	return ((String) keyA).compareTo((String) keyB);
	  	
	  }
}