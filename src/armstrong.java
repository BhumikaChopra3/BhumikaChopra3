import java.util.Scanner;

public class armstrong {
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		
		Scanner scn=new Scanner(System.in);
		 int ll=scn.nextInt();
		 int ul=scn.nextInt();
		 
		 counter(ll,ul);
		 
		 
		
	}

	
	public static void counter(int a,int b)
	{
		for(int i=a;i<=b;i++)
		{
			boolean res= logic_check(i);
			
			if(res)
				System.out.println(i);
		}
	}
	
	public static boolean logic_check(int n)
	{   int sum=0,rem=0,div=n;
		int pow= no_of_digits(n);
		for(int i=0;i<=pow;i++)
		{
		rem=div%10;
		sum=sum+(int) Math.pow(rem, pow);
		div=n/10;
		
		
		}
		
		if(n==sum)
			return true;
		else
			return false;
		
		
	}
	
	
	public static int no_of_digits(int n)
	{ 
		int count=0;
		while(n!=0)
		{
			
			count++;
			n=n/10;
		}
		return count;
	}
}
