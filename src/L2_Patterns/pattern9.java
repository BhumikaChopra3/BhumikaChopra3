package L2_Patterns;

public class pattern9 {
public static void main(String[] args) {
	
	int n=5;
	
	int nst =2, nsp=2*n-3;
	for(int row=1;row<=n;row++)
	{
		//stars
		for(int cst=1;cst<=nst/2;cst++)
			System.out.print("*");
		
		
		
		//spaces
		for(int csp=1;csp<=nsp;csp++)
			System.out.print(" ");
		
		
		 
		int cst=1;
		if(row==n)
		 cst=2;
		
		
		//stars
		for(;cst<=nst/2;cst++)
			System.out.print("*");
		
		
		//rep
		

     
	}
	
	
}

}
