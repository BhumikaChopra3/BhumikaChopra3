package L48_BitManupilation;

import java.util.Scanner;

public class Bit_Masking {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 2, 5, 7, 5 };
		//UniqueNumbers2(arr, arr.length);
		// System.out.println(unique_no1(arr));
		//System.out.println(3^7);
		
		Scanner scn = new Scanner(System.in);

        int t = scn.nextInt();

        while(t-- > 0){

            	 String str1 = scn.next();
                 String str2 = scn.next();
             XORString(str1,str2);

               

        }
	}

	public static boolean OddEven(int n) {
		if ((n & 1) == 1)
			return true;
		else
			return false;

	}

	public static int unique_no1(int[] arr) {
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			ans ^= arr[i];
		}

		return ans;
	}

	public static void check_bit() {

		int n = 13;
		int pos = 3;
		int mask = 1 << pos - 1;
		if ((mask & n) > 0)
			System.out.println(1);
		else
			System.out.println(0);
	}

	public static void clear_bit() {
		int n = 13;
		int pos = 3;
		int mask = 1 << pos - 1;
		mask = ~mask;
		n = n & mask;
		System.out.println(n);
	}

	public static int count_setBit(int n) {
		int count = 0;
		while(n>0) {
			if((n&1) == 1)
				count++;
			n>>=1;
		}
		
		return count;
	}
	
	public static int fastCountSetBit(int n) {
		int count = 0;
		while(n!=0) {
			count++;
			n= (n&(n-1));
		}
		return count;
	}
	

	public static void UniqueNumbers2(int[] arr, int n) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum = (sum ^ arr[i]);
		}

		sum = (sum & -sum);

		int sum1 = 0;
		int sum2 = 0;

		for (int i = 0; i < arr.length; i++) {

			if ((arr[i] & sum) > 0) {
				sum1 = (sum1 ^ arr[i]);
			} else {
				sum2 = (sum2 ^ arr[i]);
			}
		}

		if(sum1 > sum2)
			System.out.println(sum2 + " " + sum1 );
		else
			System.out.println(sum1 + " " + sum2);
	}
	
	public static int unique_no3(int[] arr) {
		
		int ans = 0;
		int[] cnt = new int[64];
		for(int i = 0;i< arr.length;i++) {
			
			int a =0;
			int no = arr[i];
			while(no>0) {
				cnt[a] += no & 1;
				a++;
				no = no>>1;
			}
		}
		
		int p = 1;
	
		for(int i = 0; i<64; i++) {
			cnt[i] %= 3;
			ans += cnt[i]*p;
			p= p<< 1;
		}
		
		return ans;
	}
	
	public static boolean AlternatingBits(int n) {
		
		int prev = n%2;
		n= n/2;
		
		while(n>0) {
			
			int curr = n%2;
			if(curr == prev)
				return false;
			
			prev = curr;
			n= n/2;
		}
		
		return true;
	}

	public static void XORString(String str1, String str2){
		
		String ans = "";

        for(int i = 0 ; i < str1.length(); i++) {
        	
        	if( str1.charAt(i) == str2.charAt(i)) {
        		ans += "0";
        	}
        	else {
        		ans += "1";
        	}
        		
        }
        
        System.out.println(ans);
    }
	

}
