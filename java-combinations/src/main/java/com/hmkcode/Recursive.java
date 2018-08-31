package com.hmkcode;

import java.util.Arrays;
import java.util.List;

public class Recursive {

	public static void main(String[] args) {
		
		List<String> e = Arrays.asList("A", "B", "C", "D", "E");
		int k = 3;
		combination(e, k, "");
		
	}
	static int counter = 0;
	public static void combination(List<String> e, int k, String accumulated){
	
		// 1. stop
		if(e.size() < k)
			return;
		
		// 2. add each element in e to accumulated
		if(k == 1)
			for(String s:e)
				print(accumulated+s);
		
		// 3. add all elements in e to accumulated
		else if(e.size() == k){
			for(String s:e)
				accumulated+=s;
			print(accumulated);
		}
		
		// 4. for each element, call combination
		else if(e.size() > k)
			for(int i = 0 ; i < e.size() ; i++)
				combination(e.subList(i+1, e.size()), k-1, accumulated+e.get(i));
		
	}
		
	public static void print(String c){
		counter++;
		System.out.println(counter+"\t"+c);
	}
}
