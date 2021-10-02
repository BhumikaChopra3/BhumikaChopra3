package L31_linkedlist;

import java.util.LinkedList;
import java.util.Scanner;



public class sumof2list {
	
	public class Main {
		private class Node {
			int data;
			Node next;

			Node(int data, Node next) {
				this.data = data;
				this.next = next;
			}

			public Node(int carry) {
				// TODO Auto-generated constructor stub
				 if (head == null)
					 	        {
					 	            head = new Node(carry);
					 	            return;
					 	        }
					 	        
					 	        Node n = new Node(carry);
					 	        n.next = head;
					         head   = n;
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
		
		private Node addListsRecursive(Node node1, Node node2, int carry)
	    {
	          
	 	        if (node1 == null && node2 == null)
		        {
	             if (carry > 0)
	            {
	                 return new Node(carry);
		            }
	             return null;
	 	        }
	 	        
		         
	        int value1 = (node1 != null) ? node1.data : 0;
		        int value2 = (node2 != null) ? node2.data : 0;
	         
		         
		        int sum = (value1 + value2 + carry) % 10;
		        carry   = (value1 + value2 + carry) / 10;
	        
	 	         
		        Node currentHead = new Node(sum);
	         
	          
	 	        Node node1Next = (node1 != null) ? node1.next : null;
	 	        Node node2Next = (node2 != null) ? node2.next : null;
	 	
		         
		         
		        currentHead.next = addListsRecursive(node1Next, node2Next, carry);
		        
	 	        return currentHead;
	 	    }
		
		public Node addLists(Node node1, Node node2)
		   {
		        return addListsRecursive(node1, node2, 0);
		    }

	}
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int M = scn.nextInt();
		int N = scn.nextInt();

		LinkedList<Integer> list1 = new LinkedList<>();
		LinkedList<Integer> list2 = new LinkedList<>();
		LinkedList<Integer> sumlist = new LinkedList<>();

		while (M > 0) {
			list1.add(scn.nextInt());
			M--;
		}

		while (N > 0) {
			list2.add(scn.nextInt());
			N--;
		}

		//sumlist = addl
		

	}
	
	

	public static void sumwithextraspace(LinkedList<Integer> list1, LinkedList<Integer> list2) {

		String sum1 = new String();
		String sum2 = new String();
		String sum = new String();

		for (int i = 0; i < list1.size(); i++) {
			sum1 += list1.get(i);
		}

		int s1 = Integer.parseInt(sum1);

		for (int i = 0; i < list2.size(); i++) {
			sum2 += list2.get(i);
		}
		int s2 = Integer.parseInt(sum2);

		int ts = s1 + s2;

		sum += ts;

		for (int i = 0; i < sum.length(); i++) {
			System.out.print(sum.charAt(i) + " ");
		}

	}


		 

}
