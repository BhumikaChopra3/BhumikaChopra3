package L5_2DArrays;

import java.util.Scanner;

public class Basic {
	
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
	
	public static void display(int[][] arr)
	{
		for(int r=0;r<arr.length;r++)
		{
			for (int c=0;c<arr[0].length;c++) {
				System.out.print(arr[r][c]+" ");
			}
			System.out.println();
	}
	}

}
