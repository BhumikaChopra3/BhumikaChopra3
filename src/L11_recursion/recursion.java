package L11_recursion;

public class recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10, 30, 50,30,60 };
		System.out.println(lastoccindex(arr, 0, 30));

	}

	public static void PD(int n) {
		if (n == 0)
			return;

		System.out.println(n);
		PD(n - 1);
	}

	public static void PI(int n) {

		if (n == 0)
			return;

		PI(n - 1);

		System.out.println(n);

	}

	public static void PDI(int n) {
		if (n == 0)
			return;
		System.out.println(n);
		PDI(n - 1);
		System.out.println(n);
	}

	public static int power(int x, int n) {
		if (n == 0)
			return 1;

		return power(x, n - 1) * x;
	}

	public static int fibonaci(int n) {

		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		return fibonaci(n - 1) + fibonaci(n - 2);
	}

	public static void displayArray(int[] arr, int idx) {
		if (idx == arr.length)
			return;

		System.out.print(arr[idx] + " ");
		displayArray(arr, idx + 1);
	}

	public static int maximum(int[] arr, int idx) {
		if (idx == arr.length)
			return arr[0];

		return Math.max(arr[idx], maximum(arr, idx + 1));
	}

	public static int firstoccindex(int[] arr, int idx, int item) {

		if (idx == arr.length)
			return -1;

		if (arr[idx] == item)
			return idx;
		
		return firstoccindex(arr, idx + 1, item);
	}
	public static int lastoccindex(int[] arr,int idx,int item) {
		
		if(idx==arr.length)
			return -1;
		int sp=lastoccindex(arr,idx+1,item);
		
		if(arr[idx]==item && sp==-1)
		{
			return idx;
		    
		}
		return sp;
	}
//    public static int[] allIndex(int[] arr,int idx,int item) {
//    	
//    }
  }
