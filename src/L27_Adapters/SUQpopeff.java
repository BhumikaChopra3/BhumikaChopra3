package L27_Adapters;

import L26_Inhertance.dynamicQueue;

public class SUQpopeff {

	dynamicQueue pq = new dynamicQueue();

	public int pop() {
		return pq.dequeue();
	}

	public int peek() {
		return pq.getFront();
	}
	
	public void push(int item) throws Exception {
		
		try {
		dynamicQueue hq = new dynamicQueue();
		hq.enqueue(item);
		
		while(pq.size() != 0) {
			pq.enqueue(hq.dequeue());
		}
		
		pq = hq;
		} catch(Exception e) {
			throw new Exception("Stack is Full.");
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
	
	public void display() {
		pq.display();
	}

}
