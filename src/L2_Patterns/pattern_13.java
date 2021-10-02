package L2_Patterns;

import java.util.Scanner;

public class pattern_13 {
   public static void main(String[] args) {
	
	   
	   Scanner scn=new Scanner(System.in);
		
		int n = scn.nextInt();
		int nst=1, nsp=n/2;
		int val=1;
		
		for (int row=1;row<=n;row++)
		{
			//spaces
			for(int csp=1;csp<=nsp;csp++)
				System.out.print("\t");

			//stars
			for(int cst =1;cst<=nst;cst++)
				{ 
				if(row<=n/2)
				{
					val=row;
				System.out.print(val+"\t");
				if(cst <= nst/2)
					val++;
					
					else
						val--;
				}
				else
				{
					val=n/2-1;
					System.out.print(val+"\t");
					if(cst <= nst/2)
						val++;
						
						else
							val--;
					
				  	
				}
				}
			
			//prep
			System.out.println();
			if( row<=n/2)
				{
				   nsp--;
				
			    nst+=2;
				}
			else
				
			{
				nsp++;
				nst-=2;
			}
			
			
			
			
			
			
		}
		scn.close();
	}
}
   
   


