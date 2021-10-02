package L11_recursion;

import java.util.Scanner;

public class chessboard2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int minprot[] = minsport(n);
		// System.out.println(Arrays.toString(minprot));
		System.out.println("\n" + Chess1(0, 0, n - 1, n - 1, "", minprot));

	}

	public static int Chess1(int cr, int cc, int er, int ec, String ans, int[] minprot) {
		// TODO Auto-generated method stub
		// +ve Base
		if (cc == ec && cr == er) {
			System.out.print(ans + "{" + er + "-" + ec + "} ");

			return 1;
		}
		// -ve Base Case
		if (cr > er || cc > ec) {
			return 0;
		}
		int c = 0;
		int idx = (cr * (er + 1)) + (cc + 1);

		// min
		if (minprot[idx] == 1) {
			return 0;
		}

		if (minprot[idx] == 2) {
			// do somthing
			c += Chess1(er, ec, er, ec, ans + "{" + cr + "-" + cc + "}P", minprot);

		}
		// Knight
		c += Chess1(cr + 2, cc + 1, er, ec, ans + "{" + cr + "-" + cc + "}K", minprot);
		c += Chess1(cr + 1, cc + 2, er, ec, ans + "{" + cr + "-" + cc + "}K", minprot);

		// rock
		if (cc == 0 || cr == 0 || cc == ec || cr == er) {
			// Horizontal
			for (int move = 1; move <= ec; move++) {
				c += Chess1(cr, cc + move, er, ec, ans + "{" + cr + "-" + cc + "}R", minprot);
			}
			// vertical
			for (int move = 1; move <= er; move++) {
				c += Chess1(cr + move, cc, er, ec, ans + "{" + cr + "-" + cc + "}R", minprot);
			}

		}
		// bishop
		if (cc == cr || cc + cr == er) {
			for (int move = 1; move <= er && move <= ec; move++) {
				c += Chess1(cr + move, cc + move, er, ec, ans + "{" + cr + "-" + cc + "}B", minprot);
			}
		}

		return c;

	}

	public static int[] minsport(int n) {
		int[] minport = new int[(n * n) + 1];
		int count = 1;
		for (int i = 2; i <= n * n; i++) {
			if (isprime(i)) {
				if (count % 2 != 0) {
					minport[i] = 1;
				} else {
					minport[i] = 2;
				}
				count++;
			}
		}
		return minport;
	}

	public static boolean isprime(int n) {
		int div = 2;
		while (div * div <= n) {
			if (n % div == 0) {
				return false;
			}
			div++;
		}
		return true;
	}

}
