package L2_Patterns;

public class hourglasspattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=5;
		int nst=1,nsp=n-1,nst1=3;
		
		for(int row=1;row<=2*n+1;row++)
		{  
			
			for(int col=1;col<=2*n;col++)
			{  
				
				if(col<=n+1)
		    {
		    int val=n;
			//work
			for(int cst=1;cst<=nst;cst++)
				{
				System.out.print(val+"\t");
				val--;
				}
			
			System.out.println();
			if(row<=(2*n+1)/2)
				nst++;
			else
				nst--;
			
		}
				else
					
				{  
					int val=1;
					for(int csp=1;csp<=nsp;csp++)
					System.out.print("");
					for(int cst=1;cst<=nst1;cst++)
					{
					System.out.print(val+"\t");
					val++;
					}
				
				System.out.println();
				if(row<=(2*n+1)/2)
					
					{
					nst1++;
				  nsp--;
					}
				else
				{
					nst1--; 
				    nsp++;
				}
				
 			}
		}
		
		 
	}

}
}
