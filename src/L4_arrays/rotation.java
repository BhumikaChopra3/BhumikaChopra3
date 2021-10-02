package L4_arrays;

import java.util.Scanner;

public class rotation {
 static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
	    int[] m=takeInput();
	    display(m);
	    int r=scn.nextInt();
	    
	    rotate (m,r);
	    display(m);
	    
	}
	public static int[] takeInput()
	{
		int n= scn.nextInt();
		
		int arr[]= new int[n];
		for(int i=0;i<arr.length;i++)
			arr[i]=scn.nextInt();
		
		return arr;
	}
	
	public static void display(int[] arr)
	{
		for( int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
	}
//	
//	public static void reverse(int[] arr,int)
//	{
//		
//	}
//	
	
	public static void rotate(int[] arr,int rotate)
	{ 
		rotate=rotate%arr.length;
		if(rotate<0)
			rotate+=arr.length;
		
		
		
		 for(int i=0;i<rotate;i++)
		 {
			 int last =arr[arr.length-1];
			 
			 for(int j=arr.length-1;j>0;j--)
				 arr[j]=arr[j-1];
			 
			 arr[0]=last;
			 
					 
		 }
	}
	
	

}
