package L4_arrays;

import java.util.Scanner;

public class chewbacca {
	   public static void main(String args[]) {
	        // Your Code Here
		   Scanner scn = new Scanner(System.in);
			  
			String n=scn.next();
		    
		     
		     if(n=="0")
		     System.out.println("5");
		     
		     
		     String ans = "";

		     for(int i=0;i<n.length();i++) {
		    	 if (n.charAt(i) >= '5') {
		    		 if(!(i==0 && n.charAt(i)=='9'))
		    			 ans += '9' - n.charAt(i);
		    		 else
		    			 ans += n.charAt(i);
		    	 } else {
		    		 ans += n.charAt(i);
		    	 }
		     }

		System.out.println(ans);


		    }
	}



