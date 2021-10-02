package L12_Backtracking;

import java.util.Scanner;

public class combination {
	static Scanner scn = new Scanner(System.in);

	public static void main(String args[]) {
		// Your Code Here
		// int n = scn.nextInt();
		// int[] arr= {10,1,2,7,6,1,5};
		// coinChangeCombinationCrespect_case2(arr, n, "", 0);
		NQueen(new boolean[4][4], 0, 0, 0, 4, "");

	}

	public static void queenCombinationQrespect(boolean board[], int qpsf, int tq, String ans, int lastBoxUsed) {
		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}

		for (int i = lastBoxUsed + 1; i < board.length; i++) {
			if (board[i] == false) {
				board[i] = true;
				queenCombinationQrespect(board, qpsf + 1, tq, ans + "q" + qpsf + "b" + i + " ", i);
				board[i] = false;

			}
		}
	}

	public static void coinChangeCombinationUrespect(int[] denom, int amount, String ans, int lastdenomIdx) {
		if (amount == 0) {
			System.out.println(ans);
			return;
		}
		for (int i = lastdenomIdx; i < denom.length; i++) {
			if (amount >= denom[i])
				coinChangeCombinationUrespect(denom, amount - denom[i], ans + denom[i], i);

		}
	}

	public static void queenCombinationBrespect(boolean[] board, int col, int qpsf, int tq, String ans) {
		if (qpsf == tq) {
			System.out.println(ans);
			return;

		}
		if (col == board.length)
			return;

		board[col] = true;
		queenCombinationBrespect(board, col + 1, qpsf + 1, tq, ans + "b" + col);
		board[col] = false;

		queenCombinationBrespect(board, col + 1, qpsf, tq, ans);

	}

	public static void coinChangeCombinationCrespect(int[] denom, int amount, String ans, int vidx) {
		if (amount == 0) {
			System.out.println(ans);
			return;
		}

		if (amount < 0 || vidx == denom.length)
			return;

		coinChangeCombinationCrespect(denom, amount - denom[vidx], ans + denom[vidx], vidx);
		coinChangeCombinationCrespect(denom, amount, ans, vidx + 1);

	}

	public static void coinChangeCombinationUrespect_case2(int[] denom, int amount, String ans, int lastdenomIdx) {
		if (amount == 0) {
			System.out.println(ans);
			return;
		}

		if (amount < 0)
			return; 

		for (int i = lastdenomIdx; i < denom.length; i++) { 
			coinChangeCombinationUrespect_case2(denom, amount - denom[i], ans + denom[i], i + 1);

		}
	}

	public static void coinChangeCombinationCrespect_case2(int[] denom, int amount, String ans, int vidx) {
		if (amount == 0) {
			System.out.println(ans);
			return;
		}

		if (amount < 0 || vidx == denom.length)
			return;

		coinChangeCombinationCrespect_case2(denom, amount - denom[vidx], ans + denom[vidx], vidx + 1);
		coinChangeCombinationCrespect_case2(denom, amount, ans, vidx + 1);

	}

	public static void coinChangeCombinationUrespect_case3(int[] denom, int amount, String ans, int lastdenomIdx) {
		if (amount == 0) {
			System.out.println(ans);
			return;
		}

		if (amount < 0)
			return;

		for (int i = lastdenomIdx; i < denom.length; i++) {
			if (i > lastdenomIdx && denom[i] == denom[i - 1])
				continue;

			coinChangeCombinationUrespect_case2(denom, amount - denom[i], ans + denom[i], i + 1);

		}
	}

	public static void coinChangeCombinationCrespect_case3(int[] denom, int amount, String ans, int vidx, boolean call) {
		if (amount == 0) {
			System.out.println(ans);
			return;
		}

		if (amount < 0 || vidx == denom.length)
			return;
		 
		if (call == false && denom[vidx] == denom[vidx - 1])
			coinChangeCombinationCrespect_case3(denom, amount, ans, vidx + 1, false);
		else {
			coinChangeCombinationCrespect_case3(denom, amount - denom[vidx], ans + denom[vidx], vidx + 1, true);
			coinChangeCombinationCrespect_case3(denom, amount, ans, vidx + 1, false);
		}

	}

	public static void queenCombinationBoxrespect2D(boolean[][] board, int row, int col, int qpsf, int tq, String ans) {
		if (qpsf == tq) {
			System.out.println(ans);
			return;

		}
		if (col == board[0].length) {
//			row++;
//			col=0;
			queenCombinationBoxrespect2D(board, row + 1, 0, qpsf, tq, ans);
			return;
		}

		if (row == board.length)
			return;

		board[row][col] = true;
		queenCombinationBoxrespect2D(board, row, col + 1, qpsf + 1, tq, ans + "{" + row + "-" + col + "}");
		board[row][col] = false;

		queenCombinationBoxrespect2D(board, row, col + 1, qpsf, tq, ans);

	}

	public static void queenCombinationBoxrespect2DKill(boolean[][] board, int row, int col, int qpsf, int tq,
			String ans) {
		if (qpsf == tq) {
			System.out.println(ans);
			return;

		}
		if (col == board[0].length) {
//			row++;
//			col=0;
			queenCombinationBoxrespect2DKill(board, row + 1, 0, qpsf, tq, ans);
			return;
		}

		if (row == board.length)
			return;

		if (isItsafeTodPlaace(board, row, col)) {

			board[row][col] = true;
			queenCombinationBoxrespect2DKill(board, row, col + 1, qpsf + 1, tq, ans + "{" + row + "-" + col + "}");
			board[row][col] = false;
		}

		queenCombinationBoxrespect2DKill(board, row, col + 1, qpsf, tq, ans);

	}

	public static boolean isItsafeTodPlaace(boolean[][] board, int row, int col) {

		int r = row - 1;
		int c = col;

		// vertically upward
		while (r >= 0) {
			if (board[r][c])
				return false;

			r--;
		}

		// horizontally left

		r = row;
		c = col - 1;

		while (c >= 0) {
			if (board[r][c])
				return false;

			c--;

		}

		// diagonally left

		r = row - 1;
		c = col - 1;

		while (r >= 0 && c >= 0) {
			if (board[r][c])
				return false;

			r--;
			c--;
		}

		// diagonally right

		r = row - 1;
		c = col + 1;

		while (r >= 0 && c < board[0].length) {

			if (board[r][c])
				return false;

			r--;
			c++;
		}

		return true;

	}

	public static void NQueen(boolean[][] board, int row, int col, int qpsf, int tq, String ans) {

		if (qpsf == tq) {
			System.out.println(ans);
			return;

		}
		if (col == board[0].length) {
//			row++;
//			col=0;
			NQueen(board, row + 1, 0, qpsf, tq, ans);
			return;
		}

		if (row == board.length)
			return;

		if (isItsafeTodPlaace(board, row, col)) {

			board[row][col] = true;
			NQueen(board, row + 1, 0, qpsf + 1, tq, ans + "{" + row + "-" + col + "}");
			board[row][col] = false;
		}

		NQueen(board, row, col + 1, qpsf, tq, ans);

	}

	public static void NKnights(boolean[][] board, int row, int col, int kpsf, int tk, String ans) {
		if (kpsf == tk) {
			System.out.println(ans);
			return;

		}
		if (col == board[0].length) {
//			row++;
//			col=0;
			NKnights(board, row + 1, 0, kpsf, tk, ans);
			return;
		}

		if (row == board.length)
			return;

		if (isSafetoPlaceKnight(board, row, col)) {
			board[row][col] = true;
			NKnights(board, row, col + 1, kpsf + 1, tk, ans + "{" + row + "-" + col + "}");
			board[row][col] = false;
		}

		NKnights(board, row, col + 1, kpsf, tk, ans);

	}

//	public static boolean isSafetoPlaceKnight(boolean[][] board,int row,int col) {
//		
//		int r = row - 2;
//		int c = col + 1;
//		
//		// vertically upward right
//		
//		if(board[r][c])
//			return false;
//		
//		c = col - 1;
//		
//		//vertically upward left
//		
//		if(board[r][c])
//			return false;
//		
//		r = row - 1;
//		c = col + 2;
//		
//		// horizontally right
//		
//		if(board[r][c])
//			return false;
//		
//		c = col - 2;
//		
//		//horizontally left
//		
//		if(board[r][c])
//			return false;
//		
//		return true;
//		
//	}

	public static boolean isSafetoPlaceKnight(boolean[][] board, int row, int col) {

		int[] rowArr = { -1, -2, -2, -1 };
		int[] colArr = { 2, 1, -1, -2 };

		for (int i = 0; i < 4; i++) {
			int r = row + rowArr[i];
			int c = col + colArr[i];

			if (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {

				if (board[r][c])
					return false;

			}
		}

		return true;
	}

}