package L11_recursion;

import java.util.Scanner;

public class recursion_print {
   static Scanner scn=new Scanner(System.in);
	public static void main(String[] args) {
		// permutation("abc","");
		// coinToss_HB(3, "", false);
		//climbingStairs(0, 5, "");
		//pallindromePartition("nitin", "");
//		String str=scn.next();
//		Binarystring(str,"");
		subsequencesASCII("AAB", "");

	}

	public static void subsequences(String str, String ans) {
		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = str.charAt(0);
		String roq = str.substring(1);

		subsequences(roq, ans);
		subsequences(roq, ans + ch);

	}

	public static void subsequencesASCII(String str, String ans) {
		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = str.charAt(0);
		//int c = str.charAt(0);
		String roq = str.substring(1);

		subsequencesASCII(roq, ans);
		subsequencesASCII(roq, ans + ch);
		//subsequencesASCII(roq, ans + c);

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

	public static void keypadCombination(String str, String ans) {
		if (str.length() == 0) {
			System.out.print(ans + " ");
			return;
		}
		char ch = str.charAt(0);
		String roq = str.substring(1);
		String code = getCode(ch);
		for (int i = 0; i < code.length(); i++) {
			keypadCombination(roq, ans + code.charAt(i));
		}

	}

	public static void climbingStairs(int curr, int end, String ans) {
		if (curr == end) {
			System.out.print(ans + " ");
			return;
		}
		if (curr > end)
			return;

		climbingStairs(curr + 1, end, ans + 1);
		climbingStairs(curr + 2, end, ans + 2);
		climbingStairs(curr + 3, end, ans + 3);

	}

	public static void printmaxPath_D(int cc, int cr, int er, int ec, String ans) {
		if (cr == er && cc == ec) {
			System.out.print(ans + " ");
			return;
		}
		if (cr > er || cc > ec) {

			return;
		}
		printmaxPath_D(cc + 1, cr, er, ec, ans +  "V");

		printmaxPath_D(cc, cr + 1, er, ec, ans + "H");

		printmaxPath_D(cc + 1, cr + 1, er, ec, ans + "D");
	}

	public static void permutation(String str, String ans) {
		if (str.length() == 0) {
			System.out.print(ans + " ");
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String roq = str.substring(0, i) + str.substring(i + 1);

			permutation(roq, ans + ch);
		}
	}

	public static void permutation2(String str, String ans) {
		if (str.length() == 0) {
			System.out.print(ans + " ");
			return;
		}

		char ch = str.charAt(0);

		String roq = str.substring(1);
		for (int i = 0; i <= ans.length(); i++) {
			permutation2(roq, ans.substring(0, i) + ch + ans.substring(i));
		}
	}

	public static void coinToss(int n, String ans) {
		if (n == 0) {
			System.out.print(ans + " ");
			return;
		}
		coinToss(n - 1, ans + "H");
		coinToss(n - 1, ans + "T");
	}

	public static void coinToss_HB(int n, String ans, boolean isLastHeadIncluded) {
		if (n == 0) {
			System.out.print(ans + " ");
			return;
		}

		if (isLastHeadIncluded)
			coinToss_HB(n - 1, ans + "T", false);
		else {
			coinToss_HB(n - 1, ans + "H", true);
			coinToss_HB(n - 1, ans + "T", false);

		}

	}

	public static void coinToss_H(int n, String ans) {
		if (n == 0) {
			System.out.print(ans + " ");
			return;
		}

		if (ans.length() >= 1 && ans.charAt(ans.length() - 1) == 'H')
			coinToss_H(n - 1, ans + "T");
		else {
			coinToss_H(n - 1, ans + "H");
			coinToss_H(n - 1, ans + "T");

		}

	}

	public static void lexicoCounting(int curr, int n) {
		if (curr > n) {
			return;

		}
		System.out.println(curr);
		int i = 0;
		if (curr == 0)
			i = 1;
		for (; i <= 9; i++) {
			lexicoCounting(curr * 10 + i, n);

		}
	}

	public static void validParenthesis(int open, int close, int n, String ans) {

		if (open == n && close == n) {
			System.out.println(ans);
			return;
		}
		if (open > n)
			return;
		if (close > open)
			return;

		validParenthesis(open + 1, close, n, ans + "(");

		validParenthesis(open, close + 1, n, ans + ")");
	}
	
	public static boolean ispalindrome(String str) {
		int i=0;
		int j=str.length()-1;
		while(i<j) {
			if(str.charAt(i)!=str.charAt(j))
				return false;
			i++;
			j--;
			
		}
		return true;
	}

	public static void pallindromePartition(String ques,String ans) {
		if(ques.length()==0) {
			System.out.println(ans);
			
			return;
			
		}
		
		
		for(int i=1;i<=ques.length();i++) {
			String part=ques.substring(0,i);
			if(ispalindrome(part))
			pallindromePartition(ques.substring(i), ans+part+"  ");
		}
	}
	
	public static void Binarystring(String str,String ans) {
		 if ( str.length()==0) 
	        { 
	            System.out.println(ans); 
	            return; 
	        } 
		 String roq=str.substring(1);
	  
	        if (str.charAt(0) == '?') 
	        {   
	            
	            Binarystring(roq,ans+0); 
	              
	            
	            Binarystring(roq,ans+1); 
	              
	           
	          
	        } 
	        else
	            Binarystring(roq,ans+str.charAt(0)); 
	    } 
	}
	

