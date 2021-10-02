package L4_arrays;

import java.util.Scanner;

public class kadane_Algo {
	static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) {
		int[] m=takeInput();
		System.out.println(kadane(m));
	}
	public static int[] takeInput()
	{
		int n= scn.nextInt();
		
		int arr[]= new int[n];
		for(int i=0;i<arr.length;i++)
			arr[i]=scn.nextInt();
		
		return arr;
	}
  public static int kadane(int[] arr) {
	  int sum=arr[0];
	  int max=arr[0];
	  for(int i=1;i<arr.length;i++)
	  {
		sum= Math.max(sum+arr[i], arr[i]);
		if(sum>max)
			max=sum;
	  }
	 return max; 
  }
  

}
