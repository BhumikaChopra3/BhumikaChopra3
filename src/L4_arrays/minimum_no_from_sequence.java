package L4_arrays;

import java.util.Scanner;

public class minimum_no_from_sequence {
   static Scanner scn= new Scanner(System.in);
	public static void main(String[] args) {
		int t= scn.nextInt();
		while(t-->0) {
			String str=scn.next();
			int count =1;
			int ans[]= new int[str.length()+1];
			for(int i=0;i<=str.length();i++) {
				if(i==str.length()||str.charAt(i)=='I') {
					
					ans[i]=count;
					count++;
				
				for(int j=i-1;j>=0&&str.charAt(j)!='I';j--) {
					ans[j]=count;
					count++;
				}
				}
					
			}
			for(int i=0;i<ans.length;i++)
				System.out.print(ans[i]);
			System.out.println();
		}
	}
}
