package L4_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class pair_of_roses {
	 static Scanner scn= new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t=scn.nextInt();
		while(t-->0) {
			int n= scn.nextInt();
			
			int arr[]= new int[n];
			for(int i=0;i<arr.length;i++)
				arr[i]=scn.nextInt();
			int x=scn.nextInt();
			
			roseSelection(arr, x);
			System.out.println();
		}
		
		
     
	}
	
	
	public static void roseSelection(int[] arr,int x) {
		Arrays.sort(arr);
		int min=Integer.MAX_VALUE;
		int p1=0;
		int p2=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]+arr[j]==x) {
					if(min>arr[i]-arr[j]) {
						p1=arr[i];
						p2=arr[j];
					}
						
				}
			}
		}
		System.out.println("Deepak should buy roses whose prices are " +p1+"and " +p2+".");
	}
	
}
