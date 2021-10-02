package L29_stackQueueQs;

import java.util.Scanner;

public class Histogram {
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0;i < n;i++)
		    arr[i] = s.nextInt();
		    
    		Histogram mainobj = new Histogram();
    		StacksUsingArrays stack = mainobj.new StacksUsingArrays(1000);
    		System.out.println(hist(arr, stack));
		}
	

	public static long hist(int[] arr, StacksUsingArrays stack) throws Exception {

	    //Write Your Code here
		long max_area = 0; 
        long tp;  
        long area_with_top; 
       
     
        int i = 0;
        while (i < arr.length)
        {
         
            if (stack.isEmpty() || arr[stack.top()] <= arr[i])
                stack.push(i++);
       
           
            else
            {
                tp = stack.top();  
                stack.pop();         
          
                area_with_top = arr[(int) tp] * (stack.isEmpty() ? i : i - stack.top() - 1);
       
                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }
       
       
        while (stack.isEmpty() == false)
        {
            tp = stack.top();
            stack.pop();
            area_with_top = arr[(int) tp] * (stack.isEmpty() ? i : i - stack.top() - 1);
       
            if (max_area < area_with_top)
                max_area = area_with_top;
        }
       
        return max_area;
	    
	}

	private class StacksUsingArrays {
		private int[] data;
		private int tos;

		public static final int DEFAULT_CAPACITY = 10;

		public StacksUsingArrays() throws Exception {
			// TODO Auto-generated constructor stub
			this(DEFAULT_CAPACITY);
		}

		public StacksUsingArrays(int capacity) throws Exception {
			if (capacity <= 0) {
				System.out.println("Invalid Capacity");
			}
			this.data = new int[capacity];
			this.tos = -1;
		}

		public int size() {
			return this.tos + 1;
		}

		public boolean isEmpty() {
			if (this.size() == 0) {
				return true;
			} else {
				return false;
			}
		}

		public void push(int item) throws Exception {
			if (this.size() == this.data.length) {
				throw new Exception("Stack is Full");
			}
			this.tos++;
			this.data[this.tos] = item;
		}

		public int pop() throws Exception {
			if (this.size() == 0) {
				throw new Exception("Stack is Empty");
			}
			int retVal = this.data[this.tos];
			this.data[this.tos] = 0;
			this.tos--;
			return retVal;
		}

		public int top() throws Exception {
			if (this.size() == 0) {
				throw new Exception("Stack is Empty");
			}
			int retVal = this.data[this.tos];
			return retVal;
		}

		public void display() throws Exception {
			if (this.size() == 0) {
				throw new Exception("Stack is Empty");
			}
			for (int i = this.tos; i >= 0; i--) {
				System.out.println(this.data[i]);
			}

		}

	}

}



