package L4_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class help_ramu {
   static Scanner scn= new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=scn.nextInt();
while(n-->0) {
		
   int c1=scn.nextInt();
   int c2=scn.nextInt();
   int c3=scn.nextInt();
   int c4=scn.nextInt();
   int nor=scn.nextInt();
   int noc=scn.nextInt();
   int[] freqr=new int[nor];
   int[] freqc=new int[noc];
   for(int i=0;i<freqr.length;i++)
		freqr[i]=scn.nextInt();
   for(int i=0;i<freqc.length;i++)
		freqc[i]=scn.nextInt();
   System.out.println(ramu(c1,c2,c3,c4,freqr,freqc));
   }
	}
	
	
	public static int ramu(int c1,int c2,int c3,int c4,int[] freqr,int[] freqc) {
		int cost_r=0;
		int cost_c=0;
		for(int i =0;i<freqr.length;i++) {
			cost_r+=Math.min(freqr[i]*c1, c2);
		}
		for(int i =0;i<freqc.length;i++) {
			cost_c+=Math.min(freqc[i]*c1, c2);
		}
		cost_r=Math.min(cost_r, c3);
		cost_c=Math.min(cost_c, c3);
		return Math.min(cost_r+cost_c,c4);
		
	}
	
	
	

}
