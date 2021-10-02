package L5_2DArrays;

import java.util.Scanner;

public class spiralDisplay {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int[][] arr=takeInput();
      display(arr);
      System.out.print("END");
	}

	public static int[][] takeInput() {

		int rows = scn.nextInt();
		int cols = scn.nextInt();
		int[][] arr = new int[rows][cols];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < arr[0].length; c++) {
				arr[r][c] = scn.nextInt();
			}
		}
		return arr;
	}

	public static void display(int[][] arr) {
		int minrow = 0;
		int maxrow = arr.length - 1;
		int mincol = 0;
		int maxcol = arr[0].length - 1;
		int total = arr.length * arr[0].length;
		int count = 0;

		while (count < total) {
			for (int c = mincol; c <= maxcol && count < total; c++) {
				System.out.print(arr[minrow][c] + ", ");
				count++;
			}
			minrow++;
			for (int r = minrow; r <= maxrow && count < total; r++) {
				System.out.print(arr[r][maxcol] + ", ");
				count++;
			}
			maxcol--;;
			for (int c = maxcol; c >= mincol && count < total; c--) {
				System.out.print(arr[maxrow][c] + ", ");
				count++;
			}
			maxrow--;
			for (int r = maxrow; r >= minrow && count < total; r--) {
				System.out.print(arr[r][mincol] + ", ");
				count++;
			}
			mincol++;
			
		}
	}

}
