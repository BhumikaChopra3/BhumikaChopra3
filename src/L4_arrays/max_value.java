package L4_arrays;

import java.util.Scanner;

public class max_value {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int[] m = takeInput();
		int n = maximum(m);
		System.out.println(n);
	}

	public static int[] takeInput() {
		int n = scn.nextInt();

		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++)
			arr[i] = scn.nextInt();

		return arr;
	}

	public static int maximum(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		return max;
	}

}
