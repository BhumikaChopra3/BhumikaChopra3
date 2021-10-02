package L2_Patterns;

public class pattern8 {
 public static void main(String[] args) {
	 
	 
 
	 int n=5;
	 
	 
		int  nsp =  n-1,nst=1,val=1;
		
		for (  int row =1; row<=n; row++)
		{ 
			//work
			val=row;
			//spaces
			for(int csp = 1;  csp<=nsp;csp++)
				System.out.print("\t");
			
			//stars
			
			for(int cst = 1; cst<=nst;cst++)
			{System.out.print(val+"\t");
			 if (cst<=nst/2)
				 val++;
			 else
				 val--; 
			}
				
			
			//prep
			
			System.out.println();
			nst+=2;
			nsp--;
			
			
}
}
}
