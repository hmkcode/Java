package com.hmkcode;

import java.util.Arrays;
import java.util.List;

public class Recursive {

	public static void main(String[] args) {
		
		List<String> e = Arrays.asList("A", "B", "C", "D", "E");		
		combination(e, 3, "");
		
	}
	static int counter = 0;
	public static void combination(List<String> e, int K, String c){
	
		if(e.size() < K)
			return;
				
		if(K == 1)
			for(String s:e)
				print(c+s);
		else if(e.size() == K){
			for(String s:e)
				c+=s;
			print(c);
		}
		else if(e.size() > K)
			for(int i = 0 ; i < e.size() ; i++)
				combination(e.subList(i+1, e.size()), K-1, c+e.get(i));
		
	}
		
	public static void print(String c){
		counter++;
		System.out.println(counter+"\t"+c);
	}
}
