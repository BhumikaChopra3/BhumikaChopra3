package L3_NS;

import java.util.Scanner;

public class BINARYTODECIMAL {
	
	public static void main(String[] args) {
		 Scanner scn= new Scanner (System.in);
 
	        int binary= scn.nextInt();

	    int ans = 0;
			int mult = 1; // 2^0 = 1

			while (binary != 0) {

				int rem = binary % 10;

				ans = rem * mult + ans;

				mult = mult * 2;
				binary = binary / 10;

			}

			System.out.println(ans);

		}

	}

	
