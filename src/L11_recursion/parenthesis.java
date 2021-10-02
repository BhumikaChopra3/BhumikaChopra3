package L11_recursion;

import java.util.Scanner;

public class parenthesis {
	static Scanner scn=new Scanner(System.in);
    public static void main(String args[]) {
     int t=scn.nextInt();
     while(t-->0){
        String str=scn.next();
		Binarystring(str,"");
     }
    }
    public static void Binarystring(String str,String ans) {
		 if ( str.length()==0) 
	        { 
	            System.out.print(ans+" "); 
	            return; 
	        } 
		 String roq=str.substring(1);
	  
	        if (str.charAt(0) == '?') 
	        {   
	            Binarystring(roq,ans+0); 
                Binarystring(roq,ans+1); 
	          
	        } 
	        else
	            Binarystring(roq,ans+str.charAt(0)); 
	    } 
}