package L2_Patterns;

public class pattern2 {
	
	public static void main(String[] args) {
		//assign q7
		 
		int n=4;
		
		
		
		for(int row=1; row<=n;row++)
		{
			for(int col=1;col<=n;col++)
			{
				if(row==1||row==n||col==1||col==n)
					System.out.print("* \t");
				else
					System.out.print("\t");
			}
			
		System.out.println();
		}
		
		
				
				
	}

}
