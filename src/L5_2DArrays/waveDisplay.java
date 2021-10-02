package L5_2DArrays;

import java.util.Scanner;

public class waveDisplay {
	static Scanner scn=new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int[][] arr=takeInput();
    display(arr);
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
	public static void display(int[][] arr) {
		
			for (int c = 0; c < arr[0].length; c++) {
				if (c % 2 == 0) {
					for (int k = 0; k < arr.length; k++)
						System.out.print(arr[k][c] + " ");
					}
				else
				{
					for(int k=arr.length-1;k>=0;k--)
					System.out.print(arr[k][c]+" ");
				}
              System.out.println();
			}
		}
	

}
