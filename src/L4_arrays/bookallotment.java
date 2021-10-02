package L4_arrays;

import java.util.Scanner;

public class bookallotment {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub[
		int t=scn.nextInt();
		while(t-->0) {
		int n = scn.nextInt();
		int m = scn.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++)
			arr[i] = scn.nextInt();
		
		System.out.println(maxsum(arr,arr.length, n));
		}

	}

	
    public static boolean isValid(int[] m,int n,int k,int mid) {
    	int student =1, current_pages=0;
    	for(int i=0;i<n;i++) {
    		
    		if(current_pages+m[i]>mid) {
    		
    			current_pages=m[i];
    			
    			student++;
    			if(student>k)
    				return false;
    		}
    		else {
    			current_pages+=m[i];
    			
    		}
    		
    	}
    	return true;
    }
	
    public static int maxsum(int[] m, int n,int k)
     {
    	int beg=0;
    	int end=0, totalpages=0;
    	//int finalans=beg;
    	int ans=Integer.MAX_VALUE;
    	for(int i=0;i<n;i++) {
    		totalpages+=m[i];
    		beg=Math.max(beg, m[i]);
    		
    	}
    	
    	end=totalpages;
    	while(beg<=end) {
    		int mid=(beg+end)/2;
    		
    		if(isValid(m,n,k,mid)) {
    			ans=Math.min(ans,mid);
    			
    			end=mid-1;
    			
    		}
    		else {
    			
    			beg=mid-1;
    			
    		}
    	}
     return ans; 	
    }
   
    
}
