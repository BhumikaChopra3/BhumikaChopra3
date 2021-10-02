package L11_recursion;

import java.util.Scanner;

public class KSwap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);

		long n = scn.nextLong();
		int k = scn.nextInt();
		String str = Long.toString(n);
		char[] arr = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);

		}

		System.out.println(maxValue(arr, k));

	}

	public static String maxValue(char[] arr, int k) {
		long max = Long.parseLong(new String(arr));
		if (k == 0) {
			return max + "";

		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if(arr[j]>arr[i]) {
					Swap(arr,i,j);
				String ans=	maxValue(arr, k-1);
					Swap(arr,i,j);
					
					max= Math.max(max, Long.parseLong(ans));
					
				}

			}
		}
		
		return max+"";
	}
	
	public static void Swap(char[] arr,int i,int j) {
		char temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
		
	}

}
