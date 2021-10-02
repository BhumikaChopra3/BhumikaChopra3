package L11_recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class dictonary {

//	public static void main(String[] args) {
//
//		Scanner scn =  new Scanner(System.in);
//		
//		String str= scn.nextLine();
//		
//		permute(str, "", false);
//		
//	}
//
//	public static void permute(String a, String str, boolean flag) {
//
//		if (a.length() == 0) {
//
//			if (str.compareTo(a) != 0) {
//				System.out.println(str);
//				return;
//			}
//
//		}
//		
//		for(int j = 0; a.length() > 0 ;j++) {
//			
//			String ros = a.substring(0,j) + a.substring(j+1);
//			
//			char ch = a.charAt(j);
//			
//			if(flag)
//				permute(ros, str + ch, flag);
//			else {
//				if(a.charAt(j)>=a.charAt(0))
//					permute(ros,str + ch, flag || ch> a.charAt(0));
//				else if(a.charAt(j)<a.charAt(ch));
//				
//			}
//			
//			
//		}
//
//	}
//}
	
	public static void main(String args[]) {

		Scanner kb = new Scanner(System.in);
		String s = kb.nextLine();
		ArrayList<String> list = perm(s);
		Collections.sort(list);//added

		String f = s; //added
		int pos = list.indexOf(f);//added
		for (int i = pos + 1; i < list.size(); i++) {//added
			System.out.println(list.get(i));//added
		}

	}

	public static ArrayList perm(String s) {
		if (s.length() == 0) {
			ArrayList list = new ArrayList<>();
			list.add("");
			return list;
		}
		char c = s.charAt(0);
		String str = s.substring(1);

		ArrayList<String> list1 = perm(str);
		ArrayList<String> result = new ArrayList<>();

		for (int i = 0; i < list1.size(); i++) {
			String s2 = list1.get(i);

			for (int j = 0; j <= s2.length(); j++) {
				String s3 = s2.substring(0, j) + c + s2.substring(j);
				result.add(s3);
			}

		}
		return result;
	}
}

