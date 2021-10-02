package L29_stackQueueQs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
//

public class casinogame {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int q = scn.nextInt();

		Stack<Integer> input = new Stack<>();
		Stack<Integer> A = new Stack<>();
		Stack<Integer> B = new Stack<>();
		
		for (int i = 0; i < n; i++) {
			input.push(scn.nextInt());
		}

		ArrayList<Integer> list=prime(10);
		for (int i = 0; i < q; i++) {
			if (input.empty())
				break;
			int prime = list.get(i);
			while (!input.empty()) {
				int element = input.peek();
				input.pop();
				if (element % prime == 0) {
					B.push(element);
				} else {
					A.push(element);
				}
			}
			while (!B.empty()) {

				System.out.println(B.peek());
				B.pop();
			}

			input = A;
			while (!A.empty())
				A = new Stack<>();

		}
		while (!input.empty()) {
			System.out.println(input.peek());
			input.pop();
		}

	}

	public static ArrayList<Integer> prime(int n) {
		
//		ArrayList<Integer> list = new ArrayList<>();
//		int i;
//		int num = 1;
//		int count = 0;
//
//		while (count < n) {
//			num = num + 1;
//
//			for (i = 2; i <= num; i++) {
//				if (num % i == 0)
//					break;
//
//			}
//
//			if (i == num) {
//				list.add(num);
//				count++;
//			}
//		}
//
//		return list;
		ArrayList<Integer> list = new ArrayList<>();
		boolean[] primes= new boolean[n+1];
		Arrays.fill(primes, true);
		primes[0]=false;
		primes[1]=false;
		
		for(int table=2;(table *table)<=n; table++)
		{
			if(primes[table]==false)
			{
				continue;
			}
			
			for(int multi=2;(table*multi)<=n;multi++)
			{
				primes[table*multi]=false;
			}
		}
		
		for(int i=2;i<=n;i++)
		{
			if(primes[i])
				list.add(i);
			}
		return list;
	}

	

}
