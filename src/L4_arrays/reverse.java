package L4_arrays;

import java.util.Scanner;

public class reverse {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] m = takeInput();
		reverse(m);
		display(m);
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

	public static void reverse(int[] arr) {
		int si = 0;
		int ei = arr.length - 1;
		while (si < ei) {
			int temp = arr[si];
			arr[si] = arr[ei];
			arr[ei] = temp;

			si++;
			ei--;
		}
	}

}
