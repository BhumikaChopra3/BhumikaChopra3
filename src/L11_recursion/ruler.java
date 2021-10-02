package L11_recursion;

public class ruler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public static void Ruler(int x,int n) {
		  if (n==0 || x==0)
			  return;
		
		 
		for(int j=0;j<x;j++) {
			
			
			Ruler(x,n-1);
			 int i=0;
		  for(;i<n;i++) {
			
			System.out.print("-");
		}if(i==4)
		  System.out.print(j);
		  System.out.println();
		
		
		
		}
		
	  }

}

