package L25_dataStructures;

public class queue {

	protected int[] data;
	protected int front;
	protected int size;
	
	public queue() {
		// TODO Auto-generated constructor stub
		data = new int[5];
		front = 0;
		size = 0;
	}
	
	public queue(int cap) {
		data = new int[cap];
		front = 0;
		size = 0;
	
		
	}
	
	public void enqueue(int item) throws Exception{
		int idx = (front+ size)% data.length;
		data[idx]=item;
		size++;
	}
	
	public int dequeue() {
		int temp=data[front];
		data[front]=0;
		front=(front+1)%data.length;
		size--;
		return temp;
	}
	
	public int getFront() {
		return data[front];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isFull() {
		return size()==data.length;
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
	
	public void display() {

		System.out.println("----------------");
		   for(int i=0;i<size;i++) {
			   int idx=(i+front)%data.length;
			   System.out.print(data[idx]+"\t");
		   }
		   System.out.println();
		   

		System.out.println("----------------");
	}
}


