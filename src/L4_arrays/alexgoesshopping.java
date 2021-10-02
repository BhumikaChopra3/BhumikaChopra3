package L4_arrays;

import java.util.Scanner;

public class alexgoesshopping {
	static Scanner scn= new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] m=takeInput();
		int q=scn.nextInt();
		while(q-->0) {
			
		
		int a =scn.nextInt();
		int k=scn.nextInt();
		if(IsQuery(m,a,k)>0)
			System.out.println("Yes");
		else
			System.out.println("No");
		
		}
		
		
		
	}
	public static int[] takeInput()
	{
		int n= scn.nextInt();
		
		int arr[]= new int[n];
		for(int i=0;i<arr.length;i++)
			arr[i]=scn.nextInt();
		
		return arr;
	}
	
	public static int IsQuery(int p[], int a,int k){
	    int cnt=0;
	    for(int i=0; i < p.length ; i++){
	        if(a % p[i]==0){
	            cnt++;
	        }
	    }
	    if(cnt >= k){
	        return 1;
	    }
	    else{
	        return 0;
	    }
	}

}
