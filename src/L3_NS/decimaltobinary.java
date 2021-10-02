package L3_NS;

import java.util.Scanner;

public class decimaltobinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scn= new Scanner (System.in);
		 
	        long binary= scn.nextLong();

	    long ans = 0;
			long mult = 1; // 2^0 = 1

			while (binary != 0) {

				long rem = binary % 2;

				ans = rem * mult + ans;

				mult = mult * 10;
				binary = binary / 2;

			}

			System.out.println(ans);

		}

	}

	

	
