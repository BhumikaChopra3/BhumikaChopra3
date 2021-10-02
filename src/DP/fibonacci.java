package DP;

public class fibonacci {

	public static void main(String[] args) {

		// System.out.println(FibRecursion(6));

		// System.out.println(FibTD(50, new int[51]));

		// System.out.println(FibBU(9));

		System.out.println(FibBUSE(7));
	}

	// tc : 2^n sc : rec extra space
	public static int FibRecursion(int n) {

		if (n == 0 || n == 1)
			return n;

		return FibRecursion(n - 1) + FibRecursion(n - 2);
	}

	// tc : n sc : n + rec extra space
	public static int FibTD(int n, int[] strg) {

		if (n == 0 || n == 1)
			return n;

		if (strg[n] != 0)
			return strg[n];

		strg[n] = FibTD(n - 1, strg) + FibTD(n - 2, strg);

		return FibTD(n - 1, strg) + FibTD(n - 2, strg);

	}

	// tc : n sc : n
	public static int FibBU(int n) {

		int[] strg = new int[n + 1];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i < strg.length; i++) {

			strg[i] = strg[i - 1] + strg[i - 2];
		}

		return strg[n];
	}

	// tc : n sc : 2 
	public static int FibBUSE(int n) {

		int[] strg = new int[2];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 1; i <= n - 1; i++) {
			int sum = strg[0] + strg[1];
			strg[0] = strg[1];
			strg[1] = sum;

		}

		return strg[1];
	}

}
