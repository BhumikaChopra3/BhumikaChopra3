package L4_arrays;

import java.util.Scanner;

public class bar_graph {
 static Scanner scn = new Scanner (System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] m=takeInput();
	    graph(m);
	    
	}
	
	public static int[] takeInput()
	{
		int n= scn.nextInt();
		
		int arr[]= new int[n];
		for(int i=0;i<arr.length;i++)
			arr[i]=scn.nextInt();
		
		return arr;
	}

	
	public static int maximum(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		return max;
	}


	public static void graph(int[] arr)
	{
		int max=maximum(arr);
		for(int row=1;row<=max;row++)
		{
			for(int col=1;col<=arr.length;col++)
			{
				if(row<=max-arr[col])
					System.out.print("  ");
				else
					System.out.print("|  ");
			}
		}
	}

}
