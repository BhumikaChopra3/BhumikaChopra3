package L29_stackQueueQs;

import java.util.Scanner;
import java.util.Stack;

import L26_Inhertance.dynamicStack;

public class stackQs {
	public static void main(String[] args) throws Exception {
//
//		dynamicStack ds = new dynamicStack();
//
//		ds.push(10);
//		ds.push(20);
//		ds.push(30);
//		ds.push(40);
//		ds.push(50);
//
//		ds.display();
//		displayReverse(ds);
//		System.out.println();
//		ds.display();
		
		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		while (t > 0) {
			int n = scn.nextInt();
			int[] arr = new int[n];

			for (int i = 0; i < arr.length; i++)
				arr[i] = scn.nextInt();

			nextLarger(arr);

			t--;
		}

	}

	public static void displayReverse(dynamicStack s) throws Exception {

		if (s.isEmpty())
			return;

		int temp = s.pop();

		displayReverse(s);

		System.out.print(temp + "\t");

		s.push(temp);

	}

	public static void actualReverse(dynamicStack s, dynamicStack extra) throws Exception {

		if (s.isEmpty()) {
			actualReverseHelper(s, extra);
			return;
		}

		int temp = s.pop();
		extra.push(temp);

		actualReverse(s, extra);

	}

	public static void actualReverseHelper(dynamicStack s, dynamicStack extra) throws Exception {

		if (extra.isEmpty())
			return;

		int temp = extra.pop();

		actualReverseHelper(s, extra);

		s.push(temp);

	}

	
	public static void nextLarger(int[] arr) {

//		Stack<Integer> s = new Stack<Integer>();
//
//		for (int i = 0; i < arr.length; i++) {
//
//			while (!s.isEmpty() && arr[i] > s.peek()) {
//				System.out.println(arr[s.pop()] + " -> " + arr[i]);
//			}
//
//			s.push(i);
//		}
//
//		while (!s.isEmpty()) {
//			System.out.println(s.pop() + " -> -1");
//		}
		
		 Stack<Integer> stc=new Stack<Integer>();
			int[] ans = new int[arr.length];
	        stc.push(0);
	        for(int i=1;i<arr.length;i++)
	        {
	            while(stc.size()!=0 && arr[i]>arr[stc.peek()])
	            {
					ans[stc.peek()] = arr[i];
	                stc.pop();
	            }
	            stc.push(i);
	        }
	        while(stc.size()!=0)
	        
	            ans[stc.pop()] = -1;
	        
			for(int i=0;i<ans.length;i++)
				System.out.println(arr[i]+","+ans[i]);

	}

}
