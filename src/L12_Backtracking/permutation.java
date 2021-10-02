package L12_Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutation {
 
	static boolean ans;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     //queenPermutation(new boolean[4], 0, 2,"");
		int[] arr= {1,2,3};
		boolean[] available=new boolean[arr.length];
		Arrays.fill(available, true);
		List<List<Integer>> main= new ArrayList<List<Integer>>();
		List<Integer> temp=new ArrayList<Integer>();
		
		permutations(arr, available, main, temp);
		System.out.println(main
				);
	}
	
	public static void queenPermutation(boolean board[],int qpsf,int tq,String ans) {
		if(qpsf==tq) {
			System.out.println(ans);
			return;
		}
		
		for(int i=0;i<board.length;i++) {
			if(board[i]==false) {
				board[i]=true;
				queenPermutation(board, qpsf+1, tq, ans+"q"+qpsf+"b"+i+" ");
				board[i]=false;
				
			}
		}
	}
	
	public static void permutations(int[] arr,boolean[] available,List<List<Integer>> main,List<Integer> temp) {
		if(temp.size()==arr.length) {
			main.add(new ArrayList<Integer>(temp));
			return;
		}
		for(int i=0;i<available.length;i++) {
			if(available[i]==false)
				continue;
			
			available[i]=false;
			
			temp.add(arr[i]);
			permutations(arr, available,main,temp);
			temp.remove(temp.size()-1);
			
			available[i]=true;
		}
	}
	
	public static void permutationsDuplicates(int[] arr,boolean[] available,String ans,List<List<Integer>> main,List<Integer> temp) {
		if(temp.size()==arr.length) {
			main.add(new ArrayList<Integer>(temp));
			return;
		}
		for(int i=0;i<available.length;i++) {
			if(available[i]==false)
				continue;
			
			if(i>0&&arr[i]==arr[i-1]&&available[i]&&available[i-1])
				continue;
			
			available[i]=false;
			
			temp.add(arr[i]);
			permutationsDuplicates(arr, available, ans+available[i],main,temp);
			temp.remove(temp.size()-1);
			
			available[i]=true;
		}
	}
	
	public static String permutationSequence(int n,int k,int[] factorial,ArrayList<Integer> list,String ans) {
		if(n == 0) {
			return ans;
		}
		
		int group =k/factorial[n-1];
		 
		if(k % factorial[n-1]!=0)
			group++;
		
		int newk=k % factorial[n-1];
		
		if(newk == 0)
			newk = factorial[n-1];
		

		int num=list.remove(group);
		
		return permutationSequence(n-1, newk, factorial, list, ans+num);
		
	}
   
	public static void wordSearch(char[][] board,int row,int col,String word,int vidx,boolean[][] visited) {
		if(row<0 || row>=board.length || col<0 || col>=board[0].length || board[row][col]!=word.charAt(vidx))
			return;
		
		if(vidx==word.length()-1) {
			
			ans=(true);
			return;
			
		}
		
		visited[row][col]=true;
		wordSearch(board, row-1, col, word, vidx+1,visited); //top
		
		if(ans) 
			return;
		
		wordSearch(board, row, col+1, word, vidx+1,visited); //right
		if(ans) 
			return;
		wordSearch(board, row, col-1, word, vidx+1, visited); //left
		if(ans) 
			return;
		wordSearch(board, row+1, col, word, vidx+1, visited); //bottom
		
		visited[row][col]=false;
	}
	
	public static List<Integer> greyCode(int n) {
		if(n==1) {
			List<Integer> br= new ArrayList<Integer>();
			br.add(0);
			br.add(1);
			return br;
			
		}
		
		List<Integer> rr=greyCode(n-1);
		List<Integer> mr= new ArrayList<Integer>(rr);
		
		for(int i=rr.size()-1;i>=0;i--) {
			int factor=(int) Math.pow(2, n-1);
			mr.add(factor+rr.get(i));
			
		}
		
		return mr;
		
	}
	
}
	