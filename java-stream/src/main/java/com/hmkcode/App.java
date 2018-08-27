package com.hmkcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App 
{
	public static void main( String[] args )
    {
    	String[] arr = new String[]{"a", "b", "c", "d"};
    	Stream<String> stream = Arrays.stream(arr);
    	
    	stream = Stream.of("a", "b", "c", "d");
    	
    	List<String> list = new LinkedList<String>();
     	list.add("a");
     	list.add("b");
     	stream = list.stream();
     	
    	// forEach()
    	stream = Stream.of("a", "b", "c", "d");
    	stream.forEach(e -> System.out.println(e));
    	
    	// distinct() | count()
    	stream = Stream.of("a", "b", "c", "d");
    	System.out.println(stream.distinct().count());
    	
    	// anyMatch()
    	stream = Stream.of("a", "b", "c", "d");
    	System.out.println(stream.anyMatch(e -> e.contains("a")));
    	
    	// filter()
    	stream = Stream.of("a", "b", "c", "d");
    	stream.filter(e -> e.contains("b")).forEach(e -> System.out.println(e));
    	
    	// map()
    	stream = Stream.of("a", "b", "c", "d");
    	stream.map(e -> e.toUpperCase()).forEach(e -> System.out.println(e));
    	
    	// flatMap()
    	stream = getBigList().stream().flatMap(lst -> lst.stream());
    	stream.forEach(e -> System.out.println(e));
    	
    	//[any|all|none]Match()
    	System.out.println(Stream.of("a", "b", "c", "d").allMatch( e -> (e.length() == 1)));
    	System.out.println(Stream.of("a", "b", "c", "d").noneMatch(e -> (e.length() == 2)));
    	System.out.println(Stream.of("a", "b", "c", "d").anyMatch( e ->  e.equals("a") ));
    	    	
    	//reduce()
    	stream = Stream.of("a", "b", "c", "d");
    	System.out.println(stream.reduce("", (x,y) -> apply(x,y)));
    	
    	//collect(Collectors)
    	stream = Stream.of("a", "b", "c", "d");
    	System.out.println(stream.collect(Collectors.toList()));
    	
    	
    }   
   
    private static String apply(String a, String b){    	
    	System.out.println(a+"->"+b);
    	return a+b;
    }
    
    private static List<List<String>> getBigList(){
    	
    	List<List<String>> bigList = new LinkedList<List<String>>();
     	
     	List<String> list1 = new LinkedList<String>();
     	list1.add("a");
     	list1.add("b");
     	
     	List<String> list2 = new LinkedList<String>();
     	list2.add("c");
     	list2.add("d");
     	
     	bigList.add(list1);
     	bigList.add(list2);
     
     	return bigList;
    }


}
