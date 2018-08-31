package com.hmkcode;



public class ForwardBackward {

	
	public static void main(String[] args){
		Object[] e = new Object[] {'A','B','C','D','E'};
		int k = 3;
		combination(e,k);
	}
	
	
	public static void combination(Object[]  elements, int k){

		// get the length of the array
		// e.g. for {'A','B','C','D'} => N = 4 
		int N = elements.length;
		
		if(k > N){
			System.out.println("Invalid input, K > N");
			return;
		}
		
		// calculate the possible combinations
		c(N,k);
		
		// init combination index array
		int pointers[] = new int[k];
		

		int r = 0; // index for combination array
		int i = 0; // index for elements array
		
		while(r >= 0){
		
			// forward step if i < (N + (r-K))
			if(i <= (N + (r - k))){
				pointers[r] = i;
					
				// if combination array is full print and increment i;
				if(r == k-1){
					print(pointers, elements);
					i++;				
				}
				else{
					// if combination is not full yet, select next element
					i = pointers[r]+1;
					r++;										
				}				
			}
			
			// backward step
			else{
				r--;
				if(r >= 0)
					i = pointers[r]+1;
				
			}			
		}
	}
	

	
	private static int c(int n, int r){
		int nf=fact(n);
		int rf=fact(r);
		int nrf=fact(n-r);
		int npr=nf/nrf;
		int ncr=npr/rf; 
		
		System.out.println("C("+n+","+r+") = "+ ncr);

		return ncr;
	}
	
	private static int fact(int n)
	{
		if(n == 0)
			return 1;
		else
			return n * fact(n-1);
	}
	

	private static void print(int[] combination, Object[] elements){

		String output = "";
		for(int z = 0 ; z < combination.length;z++){
			output += elements[combination[z]];
		}
		System.out.println(output);
	}
}
