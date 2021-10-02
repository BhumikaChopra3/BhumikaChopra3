package L5_2DArrays;

import java.util.Scanner;

public class matrixmultiplication {
	static Scanner scn=new Scanner(System.in);
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
public static int[][] takeInput() {
		
		int rows=scn.nextInt();
		int cols=scn.nextInt();
		int[][] arr= new int[rows][cols];
		for(int r=0;r<arr.length;r++)
		{
			for (int c=0;c<arr[0].length;c++) {
				arr[r][c]=scn.nextInt();
			}
		}
		return arr;
	}
	public static int[][] multiplication(int[][] one,int[][] two)
	{
		int r1=one.length;
		int c1=one[0].length;
		int r2=two.length;
		int c2=two[0].length;
		int[][] res= new int[r1][c2];
		
		for(int r=0;r<res.length;r++)
		{
			for (int c=0;c<res[0].length;c++) {
				int sum=0;
				for(int k=0;k<c1;k++)
				sum+=(one[r][k]*two[k][c]);
				res[r][c]=sum;
			
			}
	}
		return res;
	}

}
