package DP;

public class LongestPalindromicSS {

	public static void main(String[] args) {

		String str = "abccga";
		System.out.println(LongestPalindromicSSRec(str, 0, str.length() - 1));
		System.out.println(LongestPalindromicSSTD(str, 0, str.length() - 1, new int[str.length()][str.length()]));
		 System.out.println(LongestPalindromicSSBU(str));
	}

	private static int LongestPalindromicSSRec(String str, int si, int ei) {

		if (si > ei)
			return 0;

		if (si == ei)
			return 1;

		int ans = 0;

		if (str.charAt(si) == str.charAt(ei))
			ans = LongestPalindromicSSRec(str, si + 1, ei - 1) + 2;
		else {
			int start = LongestPalindromicSSRec(str, si + 1, ei);
			int end = LongestPalindromicSSRec(str, si, ei - 1);

			ans = Math.max(start, end);
		}

		return ans;
	}

	private static int LongestPalindromicSSTD(String str, int si, int ei, int[][] strg) {

		if (si > ei)
			return 0;

		if (si == ei)
			return 1;

		if (strg[si][ei] != 0)
			return strg[si][ei];

		int ans = 0;

		if (str.charAt(si) == str.charAt(ei))
			ans = LongestPalindromicSSRec(str, si + 1, ei - 1) + 2;
		else {
			int start = LongestPalindromicSSRec(str, si + 1, ei);
			int end = LongestPalindromicSSRec(str, si, ei - 1);

			ans = Math.max(start, end);
		}

		strg[si][ei] = ans;

		return ans;
	}

	private static int LongestPalindromicSSBU(String str) {

		int n = str.length();

		int[][] strg = new int[n][n];

		for (int slide = 0; slide <= n - 1; slide++) {

			for (int si = 0; si <= n - slide - 1; si++) {

				int ei = si + slide;
				
				if (si == ei)
					strg[si][ei] = 1;
				else {
					int ans = 0;

					if (str.charAt(si) == str.charAt(ei))
						ans = strg[si+1][ei-1] + 2;
					else {
						int start = strg[si+1][ei];
						int end =  strg[si][ei-1];

						ans = Math.max(start, end);
					}

					strg[si][ei] = ans;

				}

			}
		}
		
		return strg[0][n-1];

	}
}
