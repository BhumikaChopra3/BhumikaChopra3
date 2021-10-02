package L3_NS;

import java.util.Scanner;

public class anytoany {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn= new Scanner (System.in);
		 
        int sb= scn.nextInt();
        int db= scn.nextInt();
        int sn= scn.nextInt();

    int ans = 0;
		int mult = 1; // 2^0 = 1

		while (sn!= 0) {

			int rem = sn % 10;

			ans = rem * mult + ans;

			mult = mult * sb;
			sn = sn/ 10;

		}

		int count = ans;

        	
    int ans1 = 0;
		int mult1 = 1; // 2^0 = 1

		while (count != 0) {

			int rem1 = count % db;

			ans1 = rem1 * mult1 + ans1;

			mult1 = mult1 * 10;
			count = count / db;

		}

		System.out.println(ans1);

	}

}




	


