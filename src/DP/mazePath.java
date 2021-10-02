package DP;

import java.util.Arrays;

public class mazePath {

	public static void main(String[] args) {

		int n = 20;

		// System.out.println(MPRecursion(0, 0, n, n));
		System.out.println(MPTD(0, 0, n, n, new int[n + 1][n + 1]));
		System.out.println(MPBU(n, n));
	}

	// tc : 2 ^(er + ec) sc : rec extra space

	public static int MPRecursion(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec)
			return 1;

		if (cr > er || cc > ec)
			return 0;

		return MPRecursion(cr, cc + 1, er, ec) + MPRecursion(cr + 1, cc, er, ec);
	}

	// tc : (er * ex) sc : (er * ec) + rec extra space

	public static int MPTD(int cr, int cc, int er, int ec, int[][] strg) {

		if (cr == er && cc == ec)
			return 1;

		if (cr > er || cc > ec)
			return 0;

		if (strg[cr][cc] != 0)
			return strg[cr][cc];

		int ch = MPTD(cr, cc + 1, er, ec, strg);
		int cv = MPTD(cr + 1, cc, er, ec, strg);

		strg[cr][cc] = ch + cv;

		return ch + cv;
	}
	
	//tc : er*ec sc : er*ec

	public static int MPBU(int er, int ec) {

		int[][] strg = new int[er + 2][ec + 2];

		for (int row = er; row >= 0; row--) {
			for (int col = ec; col >= 0; col--) {

				if (row == er && col == ec)
					strg[row][col] = 1;
				else
					strg[row][col] = strg[row][col + 1] + strg[row + 1][col];

			}
		}

		return strg[0][0];
	}
	
	//tc : er*ec sc : ec 
	public static int MPBUSE(int er, int ec) {
		
		int[] strg = new int[ec+1];
		
		Arrays.fill(strg, 1);
		
		for(int i = er; i>=1; i--) {
			
			for(int col = ec; col>=0; col--) {
				if(col == ec)
					strg[col] = 1;
				else
					strg[col] = strg[col] +strg[col+1];
			}
			
		}
		
		return strg[0];
 		 
	}
	
	
}
