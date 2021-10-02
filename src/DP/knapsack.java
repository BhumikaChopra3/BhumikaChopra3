package DP;

public class knapsack {

	public static void main(String[] args) {
		
		// int[] wt = new int[1000];
				// int[] price = new int[1000];
				//
				// for (int i = 0; i < price.length; i++) {
				// wt[i] = i + 1;
				// price[i] = i + 1;
				// }
				int[] wt = { 1, 3, 4, 5 };
				int[] price = { 1, 4, 5, 7 };
				int cap = 7;

//				System.out.println(KSRecursion(wt, price, cap, 0));
//				System.out.println(KSTD(wt, price, cap,0, new int[wt.length][cap + 1]));
				System.out.println(KSBU(wt, price, cap));

	}

	public static int KSRecursion(int[] wt, int[] price, int capacity, int vidx) {

		if (vidx == wt.length || capacity == 0)
			return 0;

		int exclude = KSRecursion(wt, price, capacity, vidx+1);

		int include = 0;

		if (capacity >= wt[vidx])
			include = KSRecursion(wt, price, capacity - wt[vidx], vidx+1) + price[vidx];

		return Math.max(exclude, include);

	}
	
	public static int KSTD(int[] wt, int[] price, int capacity, int vidx, int[][] strg) {

		if (vidx == wt.length || capacity == 0)
			return 0;
		
		if(strg[vidx][capacity] != 0)
			return strg[vidx][capacity];

		int exclude = KSTD(wt, price, capacity, vidx+1, strg);

		int include = 0;

		if (capacity >= wt[vidx])
			include = KSTD(wt, price, capacity - wt[vidx], vidx+1, strg) + price[vidx];
		
		strg[vidx][capacity] = Math.max(exclude, include);

		return Math.max(exclude, include);

	}
	
	public static int KSBU(int[] wt, int[] price, int cap) {
		
		int n = wt.length;
		int[][] strg = new int[n+1][cap+1];
		
		for(int row = n - 1; row >= 0; row--) {
			
			for(int col = 1; col <= cap; col++) {
				
				int e = strg[row+1][col];
				
				int  i =0;
				
				if (col >= wt[row])
				 i = strg[row+1][col - wt[row]] + price[row];
				
				strg[row][col] = Math.max(e, i);
				
			}
		}
		
		for(int i = 0; i<strg.length; i++) {
			for(int j = 0; j<strg[0].length; j++) {
				System.out.print(strg[i][j] + " ");
			}
			
			System.out.println();
		}
		
		return strg[0][cap];
		
	}

}
