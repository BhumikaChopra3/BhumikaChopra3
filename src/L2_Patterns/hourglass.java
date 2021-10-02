package L2_Patterns;

import java.util.Scanner;

public class hourglass {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int val = n;
		int num=1;
		// for loop for printing
		// upper half
		for (int row = 1; row <= n+1; row++) {

			// printing i spaces at
			// the beginning of each row
			for (int csp = 1; csp < row; csp++)
				System.out.print(" ");
			
			val = n-row+1;

			// printing i to rows value
			// at the end of each row
			for (int cst = row; cst <= n+1; cst++)
			{
				System.out.print(val);
				val--;
            }
			val=1;

			for (int cst = row; cst < n+1; cst++) 
			{
				
				System.out.print(val);
				val++;
			}

			System.out.println();
			
		}

		// for loop for printing lower half
		for (int row = n ; row >= 1; row--) {
			// printing i spaces at the
			// beginning of each row
			for (int csp = 1; csp < row; csp++)
				System.out.print(" ");

			// printing i to rows value
			// at the end of each row
			for (int cst = row; cst <= n+1; cst++)
			{
				System.out.print(num);
			    num--;
			}
             num=1;
			for (int cst = row; cst < n+1; cst++)
			{
				
				System.out.print(num);
				num++;
				
			}

			System.out.println();
		}
		scn.close();
	}

}
