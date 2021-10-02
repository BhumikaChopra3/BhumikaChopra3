package L2_Patterns;

public class pattern5 {
public static void main(String[] args) {
	
	//assign q10
	
	int n  = 5, nsp =0, nst=2*n-1;
	      
	  for (int row = 1; row<=n;row++)
	  {
		  //work
		  
		  //spaces
		  
		  for(int csp=1;csp<=nsp;csp++)
			  System.out.print("\t");
		  
		  //stars
		  for (int cst =1;cst<=nst;cst++)
			  System.out.print("* \t");
		  
		  //prep
		  System.out.println();
		  nsp++;
		  nst-=2;
		  
		  
		  
		  
		  
	  }
		  
			

}
}
