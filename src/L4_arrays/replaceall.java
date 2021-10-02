package L4_arrays;

import java.util.Scanner;

public class replaceall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		  
		String n=scn.next();
	    
	     
	     if(n=="0")
	     System.out.println("5");
	     
	     
	     String ans = "";

	     for(int i=0;i<n.length();i++) {
	    	 if (n.charAt(i) == '0') {
	    		 ans += '5';
	    	 } else {
	    		 ans += n.charAt(i);
	    	 }
	     }

	System.out.println(ans);


	    }
	}