package L4_arrays;

import java.util.Scanner;

public class quadratic_equation {
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scn=new Scanner(System.in);
		 int a=scn.nextInt();
		 int b=scn.nextInt();
		 int c=scn.nextInt();
		 int d=(int) Math.sqrt(b*b - 4*a*c);
		 int root1= (-b + d )/2*a ;
		 int root2= (-b - d )/2*a ;
		 check(root1,root2);
		 
	}
   public static void check(int a,int b)
   {
	   if(a!=b&& a>0 && b>0)
	   {  
		   System.out.println("Real and Distinct");
		   if(a>b)
			   System.out.println(b+" "+a);
		   else
			   System.out.println(a+" "+b);
	   }
	   
	   else if(a==b && a>0 && b>0)
	   {
		   System.out.println("Real and Equal");
		   
		   System.out.println(a+" "+a);
		   
	   }
	   
	   else
	   System.out.println("Imaginary"); 
	   }
  
}
