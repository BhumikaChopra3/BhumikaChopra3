package L6_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class string {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		String str = scn.nextLine();
		subString(str);

	}

	public static ArrayList<String> subString(String str) {
		ArrayList<String> res = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++)
				res.add(str.substring(i, j));

		}
		return res;
	}

	public static boolean pallindrome(String str) {
		int si = 0, ei = str.length() - 1;
		while (si < ei) {
			if (str.charAt(si) != str.charAt(ei))
				return false;
			si++;
			ei--;
		}
		return true;
	}

	public static int countpallindromicSubstrings(String str) {
		ArrayList<String> res = subString(str);
		int count = 0;
		for (String val : res) {
			if (pallindrome(val))
				count++;
		}
		return count;
	}

	public static void reverse(String str) {
		String res = "";

		while (true) {
			int space = str.lastIndexOf(' ');
			String word = str.substring(space + 1);
			res += word + " ";
			if (space == -1)
				break;
			else
				str = str.substring(0, space);

		}
	}

	public static String duplicate(String str) {
		StringBuilder sb = new StringBuilder();
		int j = 0;
		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) != str.charAt(j))

				j++;

			sb.append(str.charAt(i));

		}
		return sb.toString();
	}

	public static String Compress(String texto) {

		StringBuilder objString = new StringBuilder();

		int count;
		char match;

		count = texto.substring(texto.indexOf(texto.charAt(1)), texto.lastIndexOf(texto.charAt(1))).length() + 1;
		match = texto.charAt(1);

		objString.append(match);
		objString.append(count);

		return objString.toString();
	}

	public static void oddeven(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); ++i) {
			if (i % 2 != 0) {
				int val = str.charAt(i);
				int k = val + 1;

				sb.append((char) k);

			} else {
				int val = str.charAt(i);
				int k = val - 1;

				sb.append((char) k);

			}

		}
		System.out.println(sb);

	}

	public static void toggle(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length() - 1; i++) {
			char ch = str.charAt(i);
			if (ch >= 'a' && ch <= 'z')
				sb.append(Character.toUpperCase(ch));
			else
				sb.append(Character.toLowerCase(ch));
		}
		System.out.println(sb);

	}

	public static void difference(String str) {
		for (int i = 0, j = i + 1; i <= str.length() - 1 && j <= str.length() - 1; i += 2, j += 2) {
			int A1 = str.charAt(i);
			int A2 = str.charAt(i + 1);
			int diff = A1 - A2;
			System.out.print(str.charAt(i));
			System.out.print(diff);
			System.out.print(str.charAt(i + 1));
		}
	}

	public static void maxFrequency(String str) {
		int max = Integer.MIN_VALUE;
		int temp = 0;
		for (int i = 0; i < str.length(); i++) {
			int count = 0;
			for (int j = i + 1; j <= str.length(); j++) {
				if (str.charAt(i) == str.charAt(j))
					count++;
			}
			if (count >= max) {
				max = count;
				temp = i;
			}

		}

		System.out.println(str.charAt(temp));
	}

}
