package L2_Patterns;

import java.util.Scanner;

public class pattern7 {
	
	public static void main(String[] args) {
		//assign q18
		Scanner scn=new Scanner(System.in);
		
		int n = scn.nextInt();
		int nst=1, nsp=n/2;
		
		for (int row=1;row<=n;row++)
		{
			//spaces
			for(int csp=1;csp<=nsp;csp++)
				System.out.print("\t");
			
			//stars
			for(int cst =1;cst<=nst;cst++)
				System.out.print("*\t");
			
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
