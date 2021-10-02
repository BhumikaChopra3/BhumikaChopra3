package L2_Patterns;

public class pattern6 {
	
public static void main(String[] args) {
	//assign q12
	

	int n  = 5, nsp =n-1, nst=1;
	      
	  for (int row = 1; row<=n;row++)
	  {
		  //work
		  
		  //spaces
		  
		  for(int csp=1;csp<=nsp;csp++)
			  System.out.print("\t");
		  
		  //stars
		  for (int cst =1;cst<=nst;cst++)
		  {
	           if(cst%2 !=0)
		  	  System.out.print("* \t");
	           else
	        	   System.out.print("! \t");
		  }
		  
		  //prep
		  System.out.println();
		  nsp--;
		  nst+=2;
	  }	
}

}
