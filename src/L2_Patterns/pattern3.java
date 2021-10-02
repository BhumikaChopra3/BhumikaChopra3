package L2_Patterns;

public class pattern3 {
	
	public static void main(String[] args) {
		//asigm q8
		
		int n =5;
				for(int row= 1;row<=n;row++) 
				{
					for(int col=1;col<=n;col++)
					{
						if (row==col||row +col==n+1)
							System.out.print("* \t");
						
						else
							System.out.print("\t");
							
					}
					
					System.out.println();
				}
	}

}
