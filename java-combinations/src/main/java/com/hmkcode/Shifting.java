package com.hmkcode;

public class Shifting 
{
    public static void main( String[] args )
    {
    	String[] e = {"A","B","C","D","E"};	
    	int k = 3;
    	combination(e,k);
    }
	public static void combination(Object[]  e, int k){
	
		int[] ignore = new int[e.length-k]; // --> [0][0]
    	int[] combination = new int[k]; // --> [][][]
    	
    	// set initial ignored elements 
    	//(last k elements will be ignored)
    	for(int w = 0; w < ignore.length; w++)
    		ignore[w] = e.length - k +(w+1);
    	
    	int i = 0, r = 0, g = 0;
    	
    	boolean terminate = false;
    	while(!terminate){   
    		
    		// selecting N-k non-ignored elements
	    	while(i < e.length && r < k){
	    			
	    		if(i != ignore[g]){
	    			combination[r] = i;
	    			r++; i++;
	    		}
	    		else{	    			
	    			if(g != ignore.length-1)
	    				g++;	    			
	    			i++;
	    		}
	    	}
	    	print(combination, e);
	    	i = 0; r = 0; g = 0;

	    	terminate = true;
	    	
	    	// shifting ignored indices
	    	for(int w = 0 ; w < ignore.length; w++){
	    		if(ignore[w] > w){	    			
	    			ignore[w]--;
	    			
	    			if(w > 0)
	    				ignore[w-1] = ignore[w]-1;
	    			terminate = false;
	    			break;	    			
	    		}
	    	}
    	}    		
	}
	
	private static void print(int[] combination, Object[] elements){

		String output = "";
		for(int z = 0 ; z < combination.length;z++){
			output += elements[combination[z]];
		}
		System.out.println(output);
	}
}