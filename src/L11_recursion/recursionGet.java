package L11_recursion;

import java.util.ArrayList;

public class recursionGet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(maxPath_D(1, 1, 3, 3));

		//System.out.println(climbingStairs(0, 5));
        // System.out.println(diffWaysToAddParenthesis_S("2*3-4*5"));\\
	  ArrayList<String> str=permutation("abc");
		lexicoCounting(0, str);
	}

	public static ArrayList<String> subsequences(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);

		String ros = str.substring(1);
		ArrayList<String> rr = subsequences(ros);
		ArrayList<String> mr = new ArrayList<>();
		for (String val : rr) {
			mr.add(val);
			mr.add(ch + val);

		}

		return mr;

	}

	public static ArrayList<String> subsequencesASCII(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		int c = str.charAt(0);
		String ros = str.substring(1);
		ArrayList<String> rr = subsequencesASCII(ros);
		ArrayList<String> mr = new ArrayList<>();
		for (String val : rr) {
			mr.add(val);
			mr.add(ch + val);
			mr.add(c + val);
		}

		return mr;

	}

	public static String getCode(char ch) {
		if (ch == '1')
			return "abc";
		else if (ch == '2')
			return "def";
		else if (ch == '3')
			return "ghi";
		else if (ch == '4')
			return "jk";
		else if (ch == '5')
			return "lmno";
		else if (ch == '6')
			return "pqr";
		else if (ch == '7')
			return "stu";
		else if (ch == '8')
			return "vwx";
		else if (ch == '9')
			return "yz";
		else if (ch == 'o')
			return "@#";
		else
			return "";
	}

	public static ArrayList<String> keypadCombination(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = str.charAt(0);
		String res = getCode(ch);
		String ros = str.substring(1);
		ArrayList<String> rr = keypadCombination(ros);
		ArrayList<String> mr = new ArrayList<>();
		for (String val : rr) {
			for (int i = 0; i < res.length(); i++) {
				mr.add(res.charAt(i) + val);

			}
		}
		return mr;

	}

	public static ArrayList<String> permutation(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);

		String ros = str.substring(1);
		ArrayList<String> rr = permutation(ros);
		ArrayList<String> mr = new ArrayList<>();
		for (String val : rr) {
			for (int i = 0; i <= val.length(); i++) {
				mr.add(val.substring(0, i) + ch + val.substring(i));
			}
		}

		return mr;

	}

	public static ArrayList<String> coinToss(int n) {
		if (n == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch1 = 'H';
		char ch2 = 'T';

		ArrayList<String> rr = coinToss(n - 1);
		ArrayList<String> mr = new ArrayList<>();
		for (String val : rr) {

			mr.add(ch1 + val);
			mr.add(ch2 + val);

		}

		return mr;

	}

	public static ArrayList<String> climbingStairs(int curr, int end) {
		if (curr == end) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}
		if (curr > end) {
			ArrayList<String> br = new ArrayList<String>();
			return br;
		}
		ArrayList<String> rr1 = climbingStairs(curr + 1, end);

		ArrayList<String> mr = new ArrayList<String>();

		for (String val : rr1) {
			mr.add(1 + val);
		}

		ArrayList<String> rr2 = climbingStairs(curr + 2, end);
		for (String val : rr2) {
			mr.add(2 + val);

		}

		ArrayList<String> rr3 = climbingStairs(curr + 3, end);
		for (String val : rr3) {
			mr.add(3 + val);

		}

		return mr;
	}

	public static ArrayList<String> maxPath(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}
		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<String>();
			return br;
		}

		ArrayList<String> rrh = maxPath(cr, cc + 1, er, ec);
		ArrayList<String> mr = new ArrayList<String>();
		for (String val : rrh) {
			mr.add("H" + val);
		}
		ArrayList<String> rrv = maxPath(cr + 1, cc, er, ec);
		for (String val : rrv) {
			mr.add("V" + val);
		}
		return mr;
	}

	public static int maxPath_D(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {

			return 1;
		}
		if (cr > er || cc > ec) {

			return 0;
		}

		int rrh = maxPath_D(cr, cc + 1, er, ec);

		int rrv = maxPath_D(cr + 1, cc, er, ec);

		int rrd = maxPath_D(cr + 1, cc + 1, er, ec);

		return rrh + rrv + rrd;
	}

	public static ArrayList<Integer> diffWaysToAddParenthesis_I(String str) {
		ArrayList<Integer> mr = new ArrayList<Integer>();
		
		if(str.indexOf('+')==-1&& str.indexOf('-')==-1&&str.indexOf('*')==-1) {
			mr.add(Integer.parseInt(str));
			return mr;
		}

		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*') {
				ArrayList<Integer> rr1 = diffWaysToAddParenthesis_I(str.substring(0, i));
				System.out.println(rr1);
				ArrayList<Integer> rr2 = diffWaysToAddParenthesis_I(str.substring(i + 1));
				System.out.println(rr2);

				for (int val1 : rr1) {
					for (int val2 : rr2) {
						if (str.charAt(i) == '+')
							mr.add(val1 + val2);
						else if (str.charAt(i) == '-')
							mr.add(val1 - val2);
						else if (str.charAt(i) == '*')
							mr.add(val1 * val2);
                           
					}
					
				}
			}
		}
		
		return mr;

	}
	public static ArrayList<String> diffWaysToAddParenthesis_S(String str) {
		ArrayList<String> mr = new ArrayList<String>();
		
		if(str.indexOf('+')==-1&& str.indexOf('-')==-1&&str.indexOf('*')==-1) {
			mr.add(str);
			return mr;
		}

		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*') {
				ArrayList<String> rr1 = diffWaysToAddParenthesis_S(str.substring(0, i));
				System.out.println(rr1);
				ArrayList<String> rr2 = diffWaysToAddParenthesis_S(str.substring(i + 1));
				System.out.println(rr2);

				for (String val1 : rr1) {
					for (String val2 : rr2) {
						if (str.charAt(i) == '+')
							mr.add(val1 +str.charAt(i)+ val2+')');
						else if (str.charAt(i) == '-')
							mr.add(val1 +str.charAt(i)+val2+')');
						else if (str.charAt(i) == '*')
							mr.add(val1 +str.charAt(i)+val2+')');
                           
					}
					
				}
			}
		}
		
		return mr;

	}
	public static void lexicoCounting(int curr, ArrayList<String> str) {
		if (curr > str.size()) {
			return;

		}
		System.out.println(curr);
		int i = 0;
		if (curr == 0)
			i = 1;
		for (; i <= 9; i++) {
			ArrayList<String> roq=(ArrayList<String>) str.subList(1,str.size());
			lexicoCounting(curr * 10 + i,roq );

		}
    }
	


	
}

