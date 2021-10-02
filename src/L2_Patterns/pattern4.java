package L2_Patterns;

public class pattern4 {
	public static void main(String[] args) {
		//assign q9
		
		int n=5;
		int  nsp =  n-1,nst=1;
		
		for (  int row =1; row<=n; row++)
		{
			//work
			
			//spaces
			for(int csp = 1;  csp<=nsp;csp++)
				System.out.print("\t");
			
			//stars
			for(int cst = 1; cst<=nst;cst++)
			System.out.print("* \t");
			
			//prep
			
			System.out.println();
			nst+=2;
			nsp--;
			
			
			
			
			
			
			
			
		}
		
	}

}
