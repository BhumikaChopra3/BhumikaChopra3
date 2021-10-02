package L11_recursion;

import java.util.Scanner;

public class ArrayGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Scanner sc = new Scanner(System.in);
		    int t  = sc.nextInt();
		    while(t>0) {
		    	int n = sc.nextInt();
		    	int [] arr = new int [n];
		    	for (int i = 0; i < arr.length; i++) {
					arr[i]=sc.nextInt();
				}
		    	System.out.println(MAxans( arr, 0, n-1));
		    	t--;
		    }
			}

			public  static int  MAxans(int[] arr, int si, int ei) {
				// TODO Auto-generated method stub
				
				
				for(int mid = si; mid<ei; mid++) {
					int sum1 =0;
					for(int i = si; i<=mid; i++) {
						sum1+=arr[i];
					}
					int sum2=0;
					for(int i=mid+1; i<=ei; i++) {
						sum2+=arr[i];
					}
					if(sum1==sum2) {
					int lp = MAxans(arr, si, mid);
					int rp = MAxans(arr, mid+1, ei);
					return Math.max(lp, rp)+1;
					}
				}
				return 0;
				
			}

		}
