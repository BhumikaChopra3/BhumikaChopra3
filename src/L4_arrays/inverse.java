package L4_arrays;

import java.util.Scanner;

public class inverse {
  static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] m=takeInput();
	    display(m);
	    int[] i=Inverse(m);
	    display(i);
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
			System.out.println(arr[i]);
	}
	
	


 public static int[] Inverse(int [] arr)
 {
	int[] na=new int[arr.length];
	
	for(int i=0;i<arr.length;i++)
	
	na[arr[i]]=i;
	
	return na;
 }
 
}

