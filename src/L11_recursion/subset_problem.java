package L11_recursion;

import java.util.Scanner;

public class subset_problem {
	
	public static void main(String[] args) {
		 Scanner scn=new Scanner(System.in);
			int n=scn.nextInt();
			int []arr=new int[n];
			for(int i=0;i<n;i++)
			{
				arr[i]=scn.nextInt();
			}

	        int t = scn.nextInt();

	        printSubset(arr, 0, 0 , t , "");

	        //System.out.println(getSubSet(arr,0,0,t));
	    }

	    public static void printSubset(int[] arr,int n,int sum,int target, String s){

	        if(n == arr.length){

	            if(sum == target){
	                System.out.println(s);
	                //return;
	            }
	            return;
	        }

	       printSubset(arr,n+1,sum + arr[n],target,s + " " + arr[n]);
	    }

	    public static int getSubSet(int[] arr,int n,int sum,int target){

	        if(n == arr.length){
	            if(sum == target)
	                return 1;
	            else
	                return 0;
	        }

	        return getSubSet(arr,n+1,sum + arr[n],target);
	    }
	
	    

}
