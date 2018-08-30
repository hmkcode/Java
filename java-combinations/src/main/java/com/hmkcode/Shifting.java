package com.hmkcode;

public class Shifting 
{
    public static void main( String[] args )
    {
    	String[] e = {"A","B","C","D","E"};	
    	int K = 3;
    }
	public static void combination(Object[]  e, int K){
	
		int[] ignore = new int[e.length-K]; // --> [0][0]
    	int[] combination = new int[K]; // --> [][][]
    	
    	for(int w = 0; w < ignore.length; w++){ // --> [3][4]
    		ignore[w] = e.length - K +(w+1);
    		//System.out.println(ignore[w]);
    	}
    	
    	int i = 0;
    	int r = 0;
    	int g = 0;
    	boolean terminate = false;
    	while(!terminate){    		
	    	while(i < e.length && r < K){
	    			
	    		if(i != ignore[g]){
	    			combination[r] = i;
	    			System.out.print(e[combination[r]]+" ");
	    			r++;
	    			i++;
	    		}
	    		else{
	    			g++;
	    			
	    			if(g == ignore.length)
	    				g--;
	    			
	    			i++;
	    		}
	    	}
	    	i = 0; r=0; g =0;
			System.out.println("");

	    	terminate = true;
	    	
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
}