package L31_linkedlist;

import java.util.Scanner;

public class Main {
	private class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node head;
	private Node tail;
	private int size;

	public Main() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public Main(Node head, Node tail, int size) {
		this.head = head;
		this.tail = tail;
		this.size = size;
	}

	// O(1)
	public int size() {
		return this.size;
	}

	// O(1)
	public boolean isEmpty() {
		return this.size() == 0;
	}

	// O(1)
	public int getFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty.");
		}

		return this.head.data;
	}

	// O(1)
	public int getLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty.");
		}

		return this.tail.data;
	}

	// O(N)
	public int getAt(int idx) throws Exception {
		Node temp = this.getNodeAt(idx);
		return temp.data;
	}

	// O(N)
	private Node getNodeAt(int idx) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		if (idx < 0 || idx >= this.size()) {
			throw new Exception("Invalid arguments");
		}

		Node retVal = this.head;
		for (int i = 0; i < idx; i++) {
			retVal = retVal.next;
		}

		return retVal;
	}

	// O(1)
	public void addFirst(int data) {
		Node node = new Node(data, this.head);

		if (this.size() == 0) {
			this.head = node;
			this.tail = node;
		} else {
			this.head = node;
		}

		this.size++;
	}

	// O(1)
	public void addLast(int data) {
		Node node = new Node(data, null);

		if (this.size() == 0) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}

		this.size++;
	}

	// O(n)
	public void addAt(int idx, int data) throws Exception {
		if (idx < 0 || idx > this.size()) {
			throw new Exception("Invalid arguments");
		}

		if (idx == 0) {
			this.addFirst(data);
		} else if (idx == this.size()) {
			this.addLast(data);
		} else {
			Node nm1 = this.getNodeAt(idx - 1);
			Node n = nm1.next;

			Node node = new Node(data, n);
			nm1.next = node;

			this.size++;
		}
	}

	// O(1)
	public int removeFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		int retVal = this.head.data;

		if (this.size() == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
		}

		this.size--;
		return retVal;
	}

	// O(n)
	public int removeLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		int retVal = this.tail.data;

		if (this.size() == 1) {
			this.head = null;
			this.tail = null;
		} else {
			Node sm2 = this.getNodeAt(this.size() - 2);
			sm2.next = null;
			this.tail = sm2;
		}

		this.size--;
		return retVal;
	}

	// O(n)
	public int removeAt(int idx) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		if (idx < 0 || idx >= this.size()) {
			throw new Exception("Invalid arguments");
		}

		if (idx == 0) {
			return this.removeFirst();
		} else if (idx == this.size() - 1) {
			return this.removeLast();
		} else {
			Node nm1 = this.getNodeAt(idx - 1);
			Node n = nm1.next;
			Node np1 = n.next;

			nm1.next = np1;
			this.size--;

			return n.data;
		}
	}

	// O(n)
	public void display() {
		Node node = this.head;

		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}

		// System.out.println("END");
	}

	public void kReverse(int k) {

		head = kReverse(head, k);
	}

	private Node kReverse(Node node, int k) {

		if (node == null)
			return null;

		// smaller problem argument
		Node temp = node;
		for (int i = 1; i <= k && temp != null; i++) {
			temp = temp.next;
		}

		// smaller problem
		Node prev = kReverse(temp, k);

		// self work
		Node curr = node;
		while (curr != temp) {

			Node ahead = curr.next;
			curr.next = prev;

			prev = curr;
			curr = ahead;
		}

		return prev;
	}

	void reverseList() {
		Node current = head;
		Node prev = null;
		Node next;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}

	public void deleteLarger() throws Exception {

		if (this.isEmpty()) {
			throw new Exception("List is empty");
		}

		this.reverseList();
		Node current = head;

		Node maxnode = head;
		Node temp;

		while (current != null && current.next != null) {
			if (current.next.data < maxnode.data) {

				temp = current.next;
				current.next = temp.next;
				temp = null;
			} else {
				current = current.next;
				maxnode = current;
			}
		}
		this.reverseList();

	}

	public void appendLastN(int n) throws Exception {

		appendLast(head, n);
	}

	private void appendLast(Node node, int n) {

		Node temp = node;
		for(int i = 0; i < this.size-n;i++) {
			temp = temp.next;
		}
		
		
		
	}
	
	public int kthformlast(int k) {
		return kthformlast(head,k);
	}

	private int kthformlast(Node head,int k){
		
		Node temp = head;
		 int len = 0;
		
		while(temp!=null) {	
			temp = temp.next;
			len++;
		}
		
		if(len<k)
			return -1;
		
		temp = head;
		
		for(int i=1;i<len-k+1;i++) 
			temp=temp.next;
		
			return temp.data;
		
	}
	
	public void merge_sorted_list(Main other) throws Exception {

		// write your code here
		merge_sorted_list(head,other);
		
	}
	


		

 private void merge_sorted_list(Node head, Main other) throws Exception {
		// TODO Auto-generated method stub
		Node temp = head;
		int len = 0;
		while(temp!=null) {
			len++;
			temp=temp.next;
		}
		
		for(int i = 1;i<=other.size;i++) {
			for(int j = 1;j<=len;j++) {
			if(this.getAt(j)<=other.getAt(i))
				this.addAt(j+1, other.getAt(i));
			else if(this.getAt(j)>=other.getAt(i))
				this.addAt(j-1, other.getAt(i));
			}
		}
		
	}





//	public static void main(String[] args) throws Exception {

	static Scanner scn = new Scanner(System.in);
//		int N = scn.nextInt();
//		// int M = scn.nextInt();
//
//		Main list = new Main();
//
//		for (int i = 0; i < N; i++) {
//			list.addLast(scn.nextInt());
//		}
//		int n = scn.nextInt();
//		list.appendLastN(n);
//		list.display();
//	}
		public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
			
			    int t = scn.nextInt();
			    
			    while(t > 0){

				   Main list1 = new Main();
				    int n1 = scn.nextInt();
				 
				    for (int j = 0; j < n1; j++) {
					    int item = scn.nextInt();
					    list1.addLast(item);
				}

	                Main list2 = new Main();
				    int n2 = scn.nextInt();
				 
				    for (int j = 0; j < n2; j++) {
					    int item = scn.nextInt();
					    list2.addLast(item);
				}
				   list1.merge_sorted_list(list2);
				   list1.display();

	            t--;
	            }
			
		}
}
