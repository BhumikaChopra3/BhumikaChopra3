package L11_recursion;

import java.util.Scanner;

public class SortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a[] = new int[n];
		int b[] = new int[m];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < b.length; i++) {
			b[i] = sc.nextInt();
		}
		int ans[] = new int[n + m];
		isitPossible(a, b, ans, 0, 0, 0, false);

	}

	public static void isitPossible(int[] a, int[] b, int[] ans, int i, int j, int len, boolean flag) {

		if (!flag) {
			if (len != 0) {
				Display(ans, len + 1);
			}
			for (int k = i; k < a.length; k++) {
				if (len == 0) {
					ans[len] = a[k];
					isitPossible(a, b, ans, k + 1, j, len, true);
				} else if (ans[len] < a[k]) {
					ans[len + 1] = a[k];
					isitPossible(a, b, ans, k + 1, j, len + 1, true);
				}
			}

		} else {
			for (int k = j; k < b.length; k++) {
				if (ans[len] < b[k]) {
					ans[len + 1] = b[k];
					isitPossible(a, b, ans, i, k + 1, len + 1, false);
				}
			}

		}

	}

	public static void Display(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");

		}
		System.out.println();
	}

	public static void split_array(int[] arr, int n, int sum1, String s1,int sum2, String s2) {
		
		if(n == arr.length) {
			
			if(sum1 == sum2)
				System.out.println(s1 + " and " + s2);
		
			return;
		}
		
		split_array(arr, n + 1, sum1 + arr[n], s1 + " " + arr[n], sum2, s2);
		split_array(arr, n + 1, sum1, s1, sum2 + arr[n], s2 + " " + arr[n]);
		

	}

}
