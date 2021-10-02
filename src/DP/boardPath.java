package DP;

public class boardPath {

	public static void main(String[] args) {

		int n = 20;
		//System.out.println(BPRecursion(0, n));
		System.out.println(BPTD(0, n, new int[n]));
		System.out.println(BPBU(n));
		
	}

	// tc : 6^n sc : rec extra space
	public static int BPRecursion(int curr, int end) {

		if (curr == end)
			return 1;

		if (curr > end)
			return 0;

		int count = 0;
		for (int dice = 1; dice <= 6; dice++) {
			count += BPRecursion(curr + dice, end);
		}

		return count;
	}

	// tc : n sc : n + rec extra space
	public static int BPTD(int curr, int end, int[] strg) {

		if (curr == end)
			return 1;

		if (curr > end)
			return 0;

		if (strg[curr] != 0)
			return strg[curr];

		int count = 0;
		for (int dice = 1; dice <= 6; dice++) {
			count += BPTD(curr + dice, end, strg);
		}

		strg[curr] = count;

		return count;
	}

	// tc : n sc : n 
	public static int BPBU(int end) {

		int[] strg = new int[end + 6];

		strg[end] = 1;

		for (int i = end - 1; i >= 0; i--) {

			for (int dice = 1; dice <= 6; dice++) {
				strg[i] += strg[i + dice];
			}
		}

		return strg[0];

	}

	// tc : n sc : const 
	public static int BPBUSE(int end) {

		int[] strg = new int[6];

		strg[0] = 1;

		for (int slide = 1; slide <= end; slide++) {

			int sum = 0;

			for (int i = 0; i < 6; i++)
				sum += strg[i];

			for (int j = 5; j > 0; j--)
				strg[j] = strg[j - 1];

			strg[0] = sum;

		}

		return strg[0];

	}

}
