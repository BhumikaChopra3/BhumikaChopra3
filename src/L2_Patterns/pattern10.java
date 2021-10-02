package L2_Patterns;

import java.util.Scanner;

public class pattern10 {
public static void main(String[] args) {
	//pascal triangle
	 
	 Scanner scn = new Scanner(System.in);
	  
		int n=scn.nextInt();
		
		for(int i = 0; i<n;i++)
		{
			int c=1;
			
			System.out.print(c + "\t");
			
			for(int j=1; j<=i;j++)
			{
			 c=c*(i-j+1)/j;
			 
			 System.out.print(c + "\t");
			}
			System.out.println();
		  }
	   }
	}
