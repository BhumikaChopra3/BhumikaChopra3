package L2_Patterns;

public class pattern_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i, j, n=5;

	    
	    // Loop to print upper half of the pattern
	    for(i=1; i<=n; i++)
	    {
	        for(j=i; j<=n; j++)
	        {
	            System.out.print("*");
	        }

	        for(j=1; j<=(2*i-2); j++)
	        {
	        	 System.out.print(" ");
	        }

	        for(j=i; j<=n; j++)
	        {
	        	 System.out.print("*");
	        }

	        System.out.println();
	    }

	    // Loop to print lower half of the pattern
	    for(i=1; i<=n; i++)
	    {
	        for(j=1; j<=i; j++)
	        {
	        	 System.out.print("*");
	        }

	        for(j=(2*i-2); j<(2*n-2); j++)
	        {
	        	 System.out.print(" ");
	        }

	        for(j=1; j<=i; j++)
	        {
	        	 System.out.print("*");
	        }
	        

            System.out.println();
	    }
	    
	    
	}
}
