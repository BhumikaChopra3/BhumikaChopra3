
package L4_arrays;

import java.util.Scanner;

public class shoppig_game {
	public static void main(String[] args) {
		
	Scanner scn = new Scanner(System.in);
	
	int num=scn.nextInt();
	int i=0;
	
	while(i<=num)
	{
	
	int  M=scn.nextInt();
	int N=scn.nextInt();
	
int count=1, aayush=0,harshit=0;
  while(count<=M || count<=N)
    {
	  aayush = aayush + count;
    count++;
    if (count>N)
  	  {
    	System.out.println("Aayush");
  	  
    break;
  	  }
    
    harshit = harshit+count;
    count++;

    
    if(count>M)
    {
  	  System.out.println("Harshit");
  	  break;
      
    } 
    
	}
  i++;
}

}
}
		
		
		
