package L4_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class rain_trapping {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = scn.nextInt();

		for (int i = 1; i <= t; i++) {
			int[] m = takeInput();
			int max = maxWater(m, m.length);
			System.out.println(max);
		}
	}

	public static int[] takeInput() {
		int n = scn.nextInt();

		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++)
			arr[i] = scn.nextInt();

		return arr;
	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);
	}

	public static int maxWater(int[] arr, int n) {

		// To store the maximum water
		// that can be stored
		int res = 0;

		// For every element of the array
		// except first and last element
		for (int i = 1; i < n - 1; i++) {

			// Find maximum element on its left
			int left = arr[i];
			for (int j = 0; j < i; j++) {
				left = Math.max(left, arr[j]);
			}

			// Find maximum element on its right
			int right = arr[i];
			for (int j = i + 1; j < n; j++) {
				right = Math.max(right, arr[j]);
			}

			// Update maximum water value
			res += Math.min(left, right) - arr[i];
		}
		return res;
	}

}
