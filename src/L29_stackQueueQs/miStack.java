package L29_stackQueueQs;

import java.util.Stack;

public class miStack {

  
	Stack<Integer> s= new Stack<Integer>();
	int min;
	
	public void push(int val) {
		if(s.isEmpty()) {
			s.push(val) ;
			min=val;
		}
		else if(val>=min) {
			s.push(val);
		}
		else {
			s.push(2*val-min);
			min=val;
			
		}
		
	}
	
	public int peek() throws Exception {
		if(s.isEmpty()) {
			throw new Exception("Stack is Empty");
		}
			
		if(s.peek()>=min) {
			return s.peek();
		}
		else {
			return min;
		}
	
		
	}
	
//	public int pop() throws Exception {
//		if(s.isEmpty()) {
//			throw new Exception("Stack is Empty");
//		}
//			
//		if(s.peek()>=min) {
//			
//		}
//		else {
//			int rv = min;
//			int topMostElement = s.pop();
//			min = 2*min - topMostElement;
//			
//			
//			return rv;
//			
//		}
//	
//		
//	}
}
