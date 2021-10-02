package L4_arrays;

import java.util.Scanner;

public class linear_search {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int[] m = takeInput();
		int M = scn.nextInt();

		int n = linearsearch(m, M);
		System.out.println(n);
	}

	public static int[] takeInput()
	{
		int n = scn.nextInt();

		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++)
			arr[i] = scn.nextInt();

		return arr;
	}

	public static int linearsearch(int[] arr, int item)
	{
		for (int i = 0; i < arr.length; i++)
		{

			if (arr[i] == item)
				return i;
		}

		return -1;
	}
	public static int binarysearch(int[] arr,int item)
	{
		int  lo=0;
		int hi=arr.length-1;
		while(lo<=hi)
		{
			int mid=(lo+hi)/2;
			if(arr[mid]<item)
				lo=mid+1;
			else if(arr[mid]>item)
				hi=mid-1;
			else
				return mid;
				
		}
		
		return -1;
	}

}
