package L4_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class aggresivecows {

	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		int n = scn.nextInt();
		int c = scn.nextInt();
		int[] arr = new int[n];
		int i; 
		for ( i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();}
		Arrays.sort(arr);
		int low=0;
		int high=arr[arr.length-1]; 
		int mid=0; 
		int max=1; 
		while(low<high)
		{
			mid=(low+high)/2; 
			if(func(arr,mid,c))
			{
				if(max<mid)
					max=mid; 
				low=mid+1;
			}
			
		else {high=mid; }	
		}
		System.out.println(max);

	}
	public static boolean func(int[] arr, int mid, int c) {
		int a=arr[0]; 
		int cow=1 ; 
		for(int i=1;i<arr.length;i++) {
			if(arr[i]-a>=mid)
			{
				cow++;
				a=arr[i];
				if(cow==c)
					return true ; 
			}
		}
			
				return false;	
		
	}

}