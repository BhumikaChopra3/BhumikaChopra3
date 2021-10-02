package DP;

import java.util.Arrays;

public class LISn2 {
	
	public static void main(String[] args) {
		
	}
	
	public static int LISBU(int[] arr) {
		
		if(arr.length == 0)
			return 0;
		
		int[] strg = new int[arr.length];
		
		Arrays.fill(strg, 1);
		
		int max = 1 ;
		
		for(int i = 0; i<strg.length; i++) {
			
			for(int j = 0; j<i; j++) {
				
				if(arr[i]<arr[j]) {
					strg[i] = Math.max(strg[i],strg[j]+1);
					
					max = Math.max(strg[i], max);
				}
			}
		}
		
		return max;
	}

}


