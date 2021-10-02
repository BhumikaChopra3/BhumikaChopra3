package L11_recursion;

import java.util.Scanner;

public class tower_of_hanoi {
  static Scanner scn=new Scanner(System.in);
 public static void main(String[] args) {
	 int n=scn.nextInt();
	TOH(n,"T1","T2","T3");
	System.out.println((int)Math.pow(2, n)-1);
   }
   
   public static void TOH(int n,String src,String dis,String help) {
	   if(n==0) {
		 
		   return;
	   }
	   
	   TOH(n-1,src,help,dis);
	 
	   System.out.println("move "+n+"ith "+ "disc from "+src+" to "+dis);
	   
	   TOH(n-1,help,dis,src);
		  
	   
   }
   
   public static int countTOH(int n,String src,String dis,String help) {
	  int count=0;
	   if(n==0) {
			 
		   return 1;
	   }
	   
	   count+=countTOH(n-1,src,help,dis);
	  count+=countTOH(n-1,help,dis,src);
	  
	   
	   return count;
   }
}
