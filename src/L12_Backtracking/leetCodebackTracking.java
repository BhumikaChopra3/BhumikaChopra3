package L12_Backtracking;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class leetCodebackTracking {

	static boolean ans;

	public static void main(String[] args) {
		List<String> main = new ArrayList<String>();
		// ipAddress("010023", "", 0, main);

		// System.out.println(main);

		//int[] time = { 1, 2, 4, 8, 1, 2, 4, 8, 16, 32 };
		validIPaddress("1111", 0, "", main);
		System.out.println(main);

	}

	public static void coinChangeCombinationUrespect(int[] denom, int amount, int lastdenomIdx,
			List<List<Integer>> main, List<Integer> temp) {
		if (amount == 0) {
			main.add(new ArrayList<Integer>(temp));
			return;
		}
		for (int i = lastdenomIdx; i < denom.length; i++) {
			if (amount >= denom[i]) {
				temp.add(denom[i]);
				coinChangeCombinationUrespect(denom, amount - denom[i], i, main, temp);
				temp.remove(temp.size() - 1);
			}

		}
	}

	public static void BinaryWatch(int[] ques, int vidx, int n, int hr, int min, List<String> main) {
		if (hr > 11 || min > 59) {
			return;
		}
		if (n == 0) {
			String fmin = min + "";
			if (fmin.length() == 1)
				fmin = "0" + fmin;

			main.add(hr + ":" + fmin);
			return;
		}
		if (vidx == ques.length)
			return;
		// include:on
		if (vidx < 4) // hr
			BinaryWatch(ques, vidx + 1, n - 1, hr + ques[vidx], min, main);
		else // min
			BinaryWatch(ques, vidx + 1, n - 1, hr, min + ques[vidx], main);

		// exclude:off
		BinaryWatch(ques, vidx + 1, n, hr, min, main);

	}

	public static void combinationUrespect(int sp, int n, int k, List<Integer> temp, List<List<Integer>> ans) {

		if (k == 0) {
			ans.add(new ArrayList<Integer>(temp));
			return;
		}

		for (int i = sp; i <= n; i++) {
			temp.add(i);
			combinationUrespect(i + 1, n, k - 1, temp, ans);
			temp.remove(temp.size() - 1);

		}

	}

	public static void combinationErespect(int sp, int n, int k, String ans) {

		if (k == 0) {
			System.out.println(ans);
			return;
		}

		// exclude
		combinationErespect(sp + 1, n, k, ans);

		// include
		combinationErespect(sp + 1, n, k - 1, ans + sp);

	}

	public static void subsetErespectcase1(int[] arr, int vidx, List<Integer> temp, List<List<Integer>> result) {

		if (vidx == arr.length) {
			result.add(new ArrayList<Integer>(temp));
			return;
		}

		// exclude
		subsetErespectcase1(arr, vidx + 1, temp, result);

		// include
		temp.add(arr[vidx]);
		subsetErespectcase1(arr, vidx + 1, temp, result);
		temp.remove(temp.size() - 1);
	}

	public static void subsetUrespectcase1(int[] arr, int vidx, String ans) {

		System.out.println(ans);

		for (int i = vidx; i < arr.length; i++) {
			subsetUrespectcase1(arr, i + 1, ans + arr[i]);
		}
	}

	public static void subsetErespectcase2(int[] arr, int vidx, List<Integer> temp, List<List<Integer>> result,
			boolean call) {

		if (vidx == arr.length) {
			result.add(new ArrayList<Integer>(temp));
			return;
		}

		// exclude
		if (call == false && arr[vidx] == arr[vidx - 1])
			subsetErespectcase2(arr, vidx + 1, temp, result, false);

		// include
		else {
			subsetErespectcase2(arr, vidx + 1, temp, result, false);
			temp.add(arr[vidx]);
			subsetErespectcase2(arr, vidx + 1, temp, result, true);
			temp.remove(temp.size() - 1);
		}
	}

	public static void subsetUrespectcase2(int[] arr, int vidx, String ans) {

		System.out.println(ans);

		for (int i = vidx; i < arr.length; i++) {

			if (i > vidx && arr[i] == arr[i - 1])
				continue;

			subsetUrespectcase2(arr, i + 1, ans + arr[i]);
		}
	}

	public int numTilePossibilities(String tiles) {

		count = 0;

		int[] freq = new int[26];

		for (int i = 0; i < tiles.length(); i++) {
			char ch = tiles.charAt(i);
			freq[ch - 'A']++;
		}

		letterTilePossiblity(freq);

		return count - 1;
	}

	static int count;

	public static void letterTilePossiblity(int[] freq) {

		count++;

		for (int i = 0; i < freq.length; i++) {
			if (freq[i] > 0) {
				freq[i]--;
				letterTilePossiblity(freq);
				freq[i]++;
			}
		}

	}

	public static void splitarrayFibonacci(String ques, List<Integer> temp, List<Integer> ans) {

		if (ques.length() == 0) {
			if (temp.size() >= 3 && ans.size() == 0)
			 ans.addAll(temp) ;
			return;
		}

		for (int i = 1; i <= ques.length() && i <= 10; i++) {
			String part = ques.substring(0, i);
			String roq = ques.substring(i);

			if (isInRange(part)) {
				int num = Integer.parseInt(part);
				if (isFibonnaciSeries(temp, num) && noLeadingZeros(part)) {
					temp.add(num);
					splitarrayFibonacci(roq, temp, ans);
					temp.remove(temp.size() - 1);
				}
			}
		}

	}

	public static boolean isFibonnaciSeries(List<Integer> temp, int num) {

		if (temp.size() <= 1)
			return true;

		int lastnum = temp.get(temp.size() - 1);
		int lastsecondnum = temp.get(temp.size() - 2);

		return lastnum + lastsecondnum == num;

	}

	public static boolean noLeadingZeros(String str) {
		if (str.length() <= 1)
			return true;

		return str.charAt(0) != 0;
	}

	public static boolean isInRange(String str) {

		if (str.length() >= 11)
			return false;

		return Long.parseLong(str) <= Math.pow(2, 31) - 1;
	}

	public static boolean validPart(String str) {
		int Num = Integer.parseInt(str);

		return Num <= 255;
	}
	
	 public static void validIPaddress(String ques,int dot, String ans, List<String> main){
	        
		 if(ques.length() == 0 ) {
			 if(dot == 4)
			    main.add(ans.substring(0,ans.length() - 1));
				 return;
		 }
		 if (ques.length() > ((4 - dot) * 3))
				return;
		 
	        for(int i = 1; i<=3 && i<=ques.length() ; i++){
	        	
	        	
	             String part = ques.substring(0,i);
	             String roq = ques.substring(i);
	             
	             if(validPart(part) && noLeadingZeros(part) )
	             validIPaddress(roq,dot+1, ans + part +".",main);
	        }
	    }

	public static void ipAddress(String ques, String ans, int dots, List<String> main) {
		if (ques.length() == 0) {
			if (dots == 4)
				main.add(ans.substring(0, ans.length() - 1));
			return;
		}
		if (ques.length() > (4 - dots * 3))
			return;

		for (int i = 1; i <= 3 && i <= ques.length(); i++) {

			String part = ques.substring(0, i);
			String roq = ques.substring(i);

			if (validPart(part) && noLeadingZeros(part))
				ipAddress(roq, ans + part + ".", dots + 1, main);

		}
	}

	public static void additiveNumber(String ques, List<BigInteger> temp) {
		if (ques.length() == 0) {

			if (temp.size() >= 3)
				ans = true;
			return;
		}

		for (int i = 1; i <= ques.length(); i++) {
			String part = ques.substring(0, i);
			String roq = ques.substring(i);

			BigInteger num = new BigInteger(part);

			if (AdditiveSeq(temp, num) && noLeadingZeros(part)) {
				temp.add(num);
				additiveNumber(roq, temp);
				temp.remove(temp.size() - 1);
			}
		}
	}

	public static boolean AdditiveSeq(List<BigInteger> temp, BigInteger num) {
		if (temp.size() <= 1)
			return true;

		BigInteger lastNum = temp.get(temp.size() - 1);
		BigInteger lastSecondNum = temp.get(temp.size() - 2);
		BigInteger sum = lastNum.add(lastSecondNum);

		return sum.compareTo(num) == 0;

	}

}
