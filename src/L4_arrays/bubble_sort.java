package L4_arrays;

import java.util.Scanner;

public class bubble_sort {
   static Scanner scn= new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int[] m=takeInput();
    display(m);
    bubblesort(m);
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
			System.out.println(arr[i]);
	}
	
public static void bubblesort(int[] arr) {
	
	 for(int counter=0;counter<arr.length-1;counter++)
	 {
		 for(int j=0;j<arr.length-1-counter;j++)
		 {
			 if(arr[j]>arr[j+1])	 
			 { 
				 int temp=arr[j];
				 arr[j]=arr[j+1];
				 arr[j+1]=temp;
			 }
		 }
	 }
}
	

}
