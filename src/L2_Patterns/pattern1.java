package L2_Patterns;

public class pattern1 {
	
	public static void main(String[] args) {
		 //assign q6
		
		int n =5;
		int nsp = 0, nst=  n-1, row = 1;
		
        while (row<=n)
        {
        	// working
        	
        	//spaces
        	for(int csp=1;csp<=nsp;csp++)
        		System.out.print("\t");
        	
        	//stars
        	for(int cst=1;cst<=nst;cst++)
              System.out.print("* \t");
				
		   //prep
        	System.out.println();
        	row++;
        	nst--;
        	nsp+=2;
        }
	}

}
