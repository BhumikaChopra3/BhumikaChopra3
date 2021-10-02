package L4_arrays;

import java.util.Scanner;

public class calculatethesum {
   static Scanner scn= new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int[] m=takeInput();
    int q=scn.nextInt();
    for (int i=1;i<=q;i++)
    {int A=scn.nextInt();
      check(m,A);
      }
    int sum=sum(m);
    System.out.println(sum);
	}
	
	public static int[] takeInput()
	{
		int n= scn.nextInt();
		
		int arr[]= new int[n];
		for(int i=0;i<arr.length;i++)
			arr[i]=scn.nextInt();
		
		return arr;
	}
	public static int sum(int[] arr)
	{
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum=sum+arr[i];
		}
		return sum;
	}
	public static void check(int[] arr,int x) {
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=arr[i]+arr[(i+x)%arr.length];
		}
	}
	

}
