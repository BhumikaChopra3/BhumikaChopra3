package L12_Backtracking;

import java.util.Scanner;

public class sudukoSolver {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int[][] arr = new int[9][9];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {

				arr[i][j] = scn.nextInt();

			}

		}

		suduko(arr, 0, 0);
	}

	public static void suduko(int[][] arr, int row, int col) {

		if (col == arr[0].length) {
			row++;
			col = 0;
		}

		if (row == arr.length) {
			display(arr);
			return;
		}
		

		if (arr[row][col] != 0) {
			suduko(arr, row, col + 1);
			return;
		}


		for (int i = 1; i <= 9; i++) {

			if (isItSafe(arr, row, col, i)) {
				arr[row][col] = i;
				suduko(arr, row, col + 1);
				arr[row][col] = 0;
			}
		}

	}

	public static boolean isItSafe(int[][] arr, int row, int col, int i) {

		return isItSafeRow(arr, row, i) && isItSafecol(arr, col, i) && isItSafeCell(arr, row, col, i);
	}

	public static boolean isItSafeCell(int[][] arr, int row, int col, int i) {

		int bsr = row - row % 3;
		int bsc = col - col % 3;

		for (int r = bsr; r < bsr + 3; r++) {
			for (int c = bsc; c < bsc + 3; c++) {
				;
				if (arr[r][c] == i)
					return false;
			}
		}

		return true;
	}

	public static boolean isItSafecol(int[][] arr, int col, int i) {

		for (int r = 0; r < arr.length; r++) {

			if (arr[r][col] == i)
				return false;
		}

		return true;
	}

	public static boolean isItSafeRow(int[][] arr, int row, int i) {
		for (int c = 0; c < arr[0].length; c++) {

			if (arr[row][c] == i)
				return false;
		}

		return true;
	}

	public static void display(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {

				System.out.print(arr[i][j] + " ");
			}

			System.out.println();
		}
	}

}
