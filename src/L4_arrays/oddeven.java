package L4_arrays;

import java.util.Scanner;

public class oddeven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Scanner scn = new Scanner (System.in);
     
     int N = scn.nextInt();;
     
     for(int i = 1; i<=N;i++)
     {
    	 int even=0,odd=0;
    	 int N1= scn.nextInt();
       
     while(N1!=0)
     {
    	 int N2=N1%10;
    	 
    	 if(N2%2==0)
    		 even=even+N2;
    	 else
    		 odd=odd+N2;
    	 N1=N1/10;
    		 
    }
      if(even%4==0 || odd%3==0)
    		 System.out.println("Yes");
      else
    		 System.out.println("No");
     
    	 
    	
     
     
     }
}

}
