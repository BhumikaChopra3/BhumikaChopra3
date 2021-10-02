package L4_arrays;

import java.util.Scanner;

public class simple_input {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner scn = new Scanner(System.in);
      
      int sum=0;
      
     while(true)
      {
    	  int n = scn.nextInt();
    	  
    	 sum=sum+n;
    	 if (sum>=0)
    	 System.out.println(n);
    	 else
        
    	 break;
         
    	 
    	
    	 
      }
      
      
		
	}

}
