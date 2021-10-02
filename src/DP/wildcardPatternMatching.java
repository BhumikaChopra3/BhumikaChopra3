package DP;

public class wildcardPatternMatching {

	public static void main(String[] args) {

		String src = "abcd";
		String pat = "?*?c**";

		System.out.println(WildcardMatchingRecursion(src, pat));
		System.out.println(WildcardMatchingRecursion(src, pat, 0, 0));
		System.out.println(WildcardMatchingTD(src, pat, 0, 0, new int[src.length()][pat.length()]));

		 System.out.println(WildcardMatchingBU(src, pat));
	}

	public static boolean WildcardMatchingRecursion(String src, String pat) {

		if (src.length() == 0 && pat.length() == 0)
			return true;

		if (src.length() != 0 && pat.length() == 0)
			return false;

		if (src.length() == 0 && pat.length() != 0) {
			for (int i = 0; i < pat.length(); i++) {
				if (pat.charAt(i) != '*')
					return false;
			}
			return true;
		}

		char chs = src.charAt(0);
		char chp = pat.charAt(0);

		String ros = src.substring(1);
		String rop = pat.substring(1);

		boolean ans;

		if (chp == chs || chp == '?') {
			ans = WildcardMatchingRecursion(ros, rop);
		} else if (chp == '*') {

			boolean blank = WildcardMatchingRecursion(src, rop);
			boolean multiple = WildcardMatchingRecursion(ros, pat);

			ans = blank || multiple;
		} else {

			ans = false;
		}

		return ans;
	}

	public static boolean WildcardMatchingRecursion(String src, String pat, int si, int pi) {

		if (src.length() == si && pat.length() == pi)
			return true;

		if (src.length() != si && pat.length() == pi)
			return false;

		if (src.length() == si && pat.length() != pi) {
			for (int i = pi; i < pat.length(); i++) {
				if (pat.charAt(i) != '*')
					return false;
			}
			return true;
		}

		char chs = src.charAt(si);
		char chp = pat.charAt(pi);

		boolean ans;

		if (chp == chs || chp == '?') {
			ans = WildcardMatchingRecursion(src, pat, si + 1, pi + 1);
		} else if (chp == '*') {

			boolean blank = WildcardMatchingRecursion(src, pat, si, pi + 1);
			boolean multiple = WildcardMatchingRecursion(src, pat, si + 1, pi);

			ans = blank || multiple;
		} else {

			ans = false;
		}

		return ans;

	}

	public static boolean WildcardMatchingTD(String src, String pat, int si, int pi, int[][] strg) {

		if (src.length() == si && pat.length() == pi)
			return true;

		if (src.length() != si && pat.length() == pi)
			return false;

		if (src.length() == si && pat.length() != pi) {
			for (int i = pi; i < pat.length(); i++) {
				if (pat.charAt(i) != '*')
					return false;
			}
			return true;
		}

		if (strg[si][pi] != 0)
			return strg[si][pi] == 2 ? true : false;

		char chs = src.charAt(si);
		char chp = pat.charAt(pi);

		boolean ans;

		if (chp == chs || chp == '?') {
			ans = WildcardMatchingTD(src, pat, si + 1, pi + 1, strg);
		} else if (chp == '*') {

			boolean blank = WildcardMatchingTD(src, pat, si, pi + 1, strg);
			boolean multiple = WildcardMatchingTD(src, pat, si + 1, pi, strg);

			ans = blank || multiple;
		} else {

			ans = false;
		}

		strg[si][pi] = (ans == true ? 2 : 1);

		return ans;

	}

	public static boolean WildcardMatchingBU(String src, String pat) {

		boolean[][] strg = new boolean[src.length() +1][pat.length() +1];
		
		strg[src.length()][pat.length()] = true;
		
		for(int row = src.length( ) ; row >= 0; row--) {
			
			for(int col= pat.length()-1; col>=0; col--) {
				
				if(row == src.length()) {
					
					if(pat.charAt(col) == '*')
						strg[row][col] = strg[row][col + 1];
					else
						strg[row][col] = false;
					
					continue;
				}
				
				char chs = src.charAt(row);
				char chp = pat.charAt(col);

				boolean ans;

				if (chp == chs || chp == '?') {
					ans = strg[row+1][col+1];
				} else if (chp == '*') {

					boolean blank = strg[row][col+1];
					boolean multiple = strg[row+1][col+1];

					ans = blank || multiple;
				} else {

					ans = false;
				}

				strg[row][col] = ans;

			}
		}
		
		return strg[0][0];
	}

}
