package L2_Patterns;

public class pattern17 {
public static void main(String[] args) {
	
	
	
	int n=5,nst=1,val=1;
	
	for(int row=1;row<=2*n+1;row++)
	{
		val=5;
	//work
	for(int cst=1;cst<=nst;cst++)
		{
		System.out.print(val);
		val--;
		
		}
	
	System.out.println();
	if(row<=n)
		nst++;
	else
		nst--;
	
	}
	
}
}
	