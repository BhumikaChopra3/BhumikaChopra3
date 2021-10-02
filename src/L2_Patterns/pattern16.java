package L2_Patterns;

public class pattern16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   int n =5;
   
   int nst=1;
   
   for(int row=1;row<=n;row++)
   {
	   for(int cst=1;cst<=nst;cst++)
	   {
		   if(cst==1 || cst==nst)
			   System.out.print(row);
		   else
			   System.out.print(0);
	   }
	   System.out.println();
	   nst++;
   }
	}

}
