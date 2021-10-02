package L4_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class painter_partition {
   static Scanner scn= new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t=scn.nextInt();
		while(t-->0) {
		
        int[] m=takeInput();
        int k=scn.nextInt();
        System.out.println(partition(m, m.length, k)); 
		}
   
	}
	
	public static int[] takeInput()
	{
		int n= scn.nextInt();
		
		int arr[]= new int[n];
		for(int i=0;i<arr.length;i++)
			arr[i]=scn.nextInt();
		
		return arr;
	}
	
	static int sum(int arr[], int lo, int hi) 
	{ 
	    int sum = 0; 
	    for (int i = lo; i <= hi; i++) 
	        sum += arr[i]; 
	    return sum; 
	} 
	   
	
	static int partition(int arr[], int n, int k) 
	{ 
	    // base cases     
	    if (k == 1) // one partition 
	        return sum(arr, 0, n - 1);     
	    if (n == 1)  // one board 
	        return arr[0]; 
	   
	    int best = Integer.MAX_VALUE; 
	   
	   
	    for (int i = 1; i <= n; i++) 
	        best = Math.min(best, Math.max(partition(arr, i, k - 1),sum(arr, i, n - 1))); 
	   
	    return best; 
	} 
	

}
