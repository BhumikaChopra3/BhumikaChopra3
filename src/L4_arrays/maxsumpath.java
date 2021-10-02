package L4_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class maxsumpath {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t=scn.nextInt();
		while(t-- > 0) {
			int n1 = scn.nextInt();
			int n2= scn.nextInt();

			int ar1[] = new int[n1];
			for (int i = 0; i < ar1.length; i++)
				ar1[i] = scn.nextInt();
			
			

			int ar2[] = new int[n2];
			for (int i = 0; i < ar2.length; i++)
				ar2[i] = scn.nextInt();


			Arrays.sort(ar1);
			Arrays.sort(ar2);
			int max = maxpath(ar1, ar2);
			System.out.println(max);
		}
		

	}

	

	public static int maxpath(int[] ar1, int[] ar2) {
		int i = 0, j = 0;

		int result = 0, sum1 = 0, sum2 = 0;

		while (i < ar1.length && j < ar2.length) {
			System.out.println(i +" "+j);
			if (ar1[i] < ar2[j])
				sum1 += ar1[i++];

			else if (ar1[i] > ar2[j])
				sum2 += ar2[j++];

			else {

				result += Math.max(sum1, sum2);

				sum1 = 0;
				sum2 = 0;

				int temp = i;
				while (i < ar1.length && ar1[i] == ar2[j])
					sum1 += ar1[i++];

				while (j < ar2.length && ar1[temp] == ar2[j])
					sum2 += ar2[j++];

				result += Math.max(sum1, sum2);

				sum1 = 0;
				sum2 = 0;
			}
		}
		

		while (i < ar1.length)
			sum1 += ar1[i++];

		while (j < ar2.length)
			sum2 += ar2[j++];

		result += Math.max(sum1, sum2);

		return result;
	}

}
