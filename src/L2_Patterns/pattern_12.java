package L2_Patterns;

public class pattern_12 {
	
	public static void main(String[] args) {
		
		
		int n=5;
		int nst=1,t1 = 0, t2 = 1;
	
		for(int row=1;row<=n;row++)
		{
		    
			for(int cst=1;cst<=nst;cst++)
			{  
				
					
				int sum = t1 + t2;
				System.out.print(t1 +"\t");
	            t1 = t2; 
	            t2 = sum;
				
				
			}
			
			System.out.println();
			
			nst++;
				
		}
		
		
	}
	

}
