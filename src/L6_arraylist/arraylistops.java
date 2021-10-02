package L6_arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class arraylistops {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[] takeInput() {
		int n = scn.nextInt();

		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++)
			arr[i] = scn.nextInt();

		return arr;
	}

	public static ArrayList<Integer> Intersection(int[] one, int[] two) {
		ArrayList<Integer> res = new ArrayList<>();

		int j = 0, i = 0;
		while (i < one.length && j < two.length) {
			if (one[i] == two[j]) {
				res.add(one[i]);
				j++;
				i++;
			} else if (one[i] > two[j])
				j++;

			else
				i++;

		}
		return res;
	}
	public static ArrayList<Integer> sum2no(int[] one, int[] two) {
		ArrayList<Integer> res = new ArrayList<>();
		 int i=one.length-1;
		 int j=two.length-1;
		 int carry=0;
		 while(i>=0|| j>=0) {
			 int sum=carry;
			 if(i>=0)
				 sum+=one[i];
			 if(j>=0)
				 sum+=two[j];
			 res.add(0,sum);
			 carry=sum%10;
			 i--;
			 j--;
			 
		 }
		 if(carry>0)
			 res.add(0,carry);
		
		
        return res;
        
	}

}
