  package L27_Adapters;

import L26_Inhertance.dynamicQueue;

public class SUQpusheff {
	
	dynamicQueue pq = new dynamicQueue();

	public void push(int item) throws Exception {
		
		try {
          pq.enqueue(item);
		} catch(Exception e) {
			throw new Exception("Stack is full");
		}
	}
	
	public int pop() throws Exception {
		
		try {
		dynamicQueue hq = new dynamicQueue();
		
		while(pq.size() != 1) {
			hq.enqueue(pq.dequeue());
		}
		
		int temp = pq.dequeue();
		
		pq = hq;
		
		return temp;
		} catch(Exception e) {
			throw new Exception("Stack is empty");
		}
	}

	public int peek() throws Exception {
		
		try {
		dynamicQueue hq = new dynamicQueue();
		
		while(pq.size() != 1) {
			hq.enqueue(pq.dequeue());
		}
		
		int temp = pq.dequeue();
		hq.enqueue(temp);
		pq = hq;
		
		return temp;
		} catch(Exception e) {
			throw new Exception("Stack is empty");
		}
	}
	
	public int size() {
		return pq.size();
	}
	
	public boolean isEmpty() {
		return pq.isEmpty();
	}

	public boolean isFull() {
		return pq.isFull(); 
	}
 	
	public void display() throws Exception {
		display(0);
	}

	private void display(int count) throws Exception {
		
		try {
		if(count == pq.size()) 
			return;
		
		
		int temp = pq.dequeue();
		
			pq.enqueue(temp);
			
			display(count + 1);
			
			System.out.println(temp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
            throw new Exception("Stack is full");
		}
		
		
	}
}
