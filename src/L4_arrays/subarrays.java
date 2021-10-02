package L4_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class subarrays {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] m = takeInput();
		int target = scn.nextInt();
		Arrays.sort(m);
		triplets(m, target);
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

	public static void printsubarray(int[] arr) {
		for (int si = 0; si < arr.length; si++) {
			for (int ei = si; ei < arr.length; ei++) {
				for (int k = si; k <= ei; k++)
					System.out.print(arr[k] + " ");
			}
			System.out.println();
		}

	}

	public static void sumsubarrays(int[] arr) {

		for (int si = 0; si < arr.length; si++) {
			int sum = 0;

			for (int ei = si; ei < arr.length; ei++) {
				sum = sum + arr[ei];
			}

			System.out.println(sum);
		}
	}

	public static void bubblesort(int[] arr) {

		for (int counter = 0; counter < arr.length - 1; counter++) {
			for (int j = 0; j < arr.length - 1 - counter; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static void sumof2nos(int[] arr, int item) {
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			int sum = arr[left] + arr[right];
			if (sum == item) {
				System.out.println(arr[left] + " and " + arr[right]);
				left++;
				right--;
			} else if (sum > item) {
				right--;
			} else {
				left++;
			}
		}
	}

	public static void triplets(int[] arr, int target) {

		for (int i = 0; i < arr.length - 1; i++) {
			int left = i+1;
			int right = arr.length - 1;

			while (left < right && left != i && right != i) {
				int sum = arr[left] + arr[i]+arr[right];
				if (sum == target) {
                    // if(left<i && i<right)
					System.out.println(arr[i]+", " +arr[left] + " and " + arr[right]);
					left++;
					right--;
				} else if (sum > target) {
					right--;
				} else {
					left++;
				}
			}
		}

	}
}
