package L4_arrays;

import java.rmi.server.Operation;
import java.util.Scanner;

public class calculator {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		
		
		while(true)
			{
			
			char ch= scn.next().charAt(0);

			if(ch=='x'|| ch=='X')
				break;
			
		int N1 = scn.nextInt();
		int N2 = scn.nextInt();
		
		
		
		  if(ch=='+')
			System.out.println(N1 +N2);
		
		else if(ch=='-')
			System.out.println(N1-N2);
		
		else if(ch=='*')
			System.out.println(N1 *N2);
		
		else if(ch=='/')
			System.out.println(N1 /N2);
		
		else if(ch=='%')
			System.out.println(N1 %N2);
		else
			System.out.println("Invalid Operation.class Try again");
		}
		
	}
			
			

}
