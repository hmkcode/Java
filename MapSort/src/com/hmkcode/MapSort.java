package com.hmkcode;


import java.util.Map;
import java.util.TreeMap;

public class MapSort {

  /* The return type of both methods are of Map type which is a Generic-vesion containing String type of keys and Integer type of values */
  public static Map<String, Integer> sortByValue(Map<String, Integer> unsortedMap){
  	Map<String, Integer> sortedMap = new TreeMap<String, Integer>(new ValueComparator(unsortedMap));
  	sortedMap.putAll(unsortedMap);
  	return sortedMap;
  }
  public static Map<String, Integer> sortByKey(Map<String, Integer> unsortedMap){
  	Map<String, Integer> sortedMap = new TreeMap<String, Integer>();
  	sortedMap.putAll(unsortedMap);
  	return sortedMap;
  }
}
