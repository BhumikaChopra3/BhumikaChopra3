package L11_recursion;

import java.util.Scanner;

public class ratChase {
	
	    public static void main(String args[]) {
	        Scanner sc = new Scanner(System.in);
	        int M = sc.nextInt();
	        int N = sc.nextInt();
	        char[][] arr = new char[M][N];
	        for (int i = 0; i < M; i++) {
	            String str = sc.next();
	            for (int j = 0; j < N; j++) {
	                arr[i][j] = str.charAt(j);
	            }
	            System.out.println();
	        }
	        int[][] ans = new int[M][N];
	        chesePath(arr, 0, 0, ans);
	        if(ans[M-1][N-1]==0)
	            System.out.println("NO PATH FOUND");
	    }
	    public static void chesePath(char[][] arr, int row, int col, int[][] ans) {
	        if (row >= arr.length || col >= arr[0].length || row < 0 || col < 0
	                || arr[row][col] == 'X' || ans[row][col] == 1)
	            return ;
	        if (row == arr.length - 1 && col == arr[0].length - 1) {
	            ans[row][col] = 1;
	            display(ans);
	            return ;
	        }
	        ans[row][col] = 1;
	        chesePath(arr, row + 1, col, ans);
	        chesePath(arr, row - 1, col, ans);
	        chesePath(arr, row, col + 1, ans);
	        chesePath(arr, row, col - 1, ans);
	        ans[row][col] = 0;
	    }
	    public static void display(int[][] ans) {
	        
	        for(int i=0;i<ans.length;i++){
	            for(int j=0;j<ans[0].length;j++){
	                System.out.print(ans[i][j]+" ");
	            }
	            System.out.println();
	        }
	    }
	}

