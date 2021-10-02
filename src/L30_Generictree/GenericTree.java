package L30_Generictree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class GenericTree {

	Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;

	public GenericTree() {
		construct(null, -1);

	}

	private Node construct(Node parent, int ith) {

		// prompt
		if (parent == null) {
			System.out.println("Enter the data for root node ?");
		} else {
			System.out.println("Enter the data for " + ith + " child of " + parent.data + "?");
		}
		// take input of data
		int item = scn.nextInt();

		Node nn = new Node();

		nn.data = item;

		System.out.println("enter the number of children for" + nn.data + "?");

		int noc = scn.nextInt();

		for (int j = 0; j < noc; j++) {

			Node child = construct(nn, j);
			nn.children.add(child);
		}

		return nn;

	}

	public void display() {
		System.out.println("-------------------------");
		display(root);
		System.out.println("-------------------------");
	}

	private void display(Node node) {

		String str = node.data + "->";

		for (Node child : node.children) {
			str += child.data + " ";

		}

		str += ".";
		System.out.println(str);

		for (Node child : node.children) {
			display(child);
		}
	}
	
	public int size() {
		return size(root);
	}

	private int size(Node node) {

		int ts = 0;

		for (Node child : node.children) {
			int cs = size(child);
			ts += cs;
		}

		return ts + 1;

	}

	public int max() {
		return max(root);
	}
	
	private int max(Node node) {

		int tm = node.data;

		for (Node child : node.children) {
			int cm = max(child);

			if (cm > tm) {
				tm = cm;
			}
		}

		return tm;
	}
	
	public int ht() {
		return ht(root);
	}

	private int ht(Node node) {

		int th = -1;

		for (Node child : node.children) {
			int ch = ht(child);

			if (ch > th) {
				th = ch;
			}
		}

		return th + 1;

	}
	
	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {
		if (node.data == item) {
			return true;
		}

		for (Node child : node.children) {
			boolean cf = find(child, item);

			if (cf)
				return true;

		}

		return false;
	}

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node node) {

		for (Node child : node.children) {
			mirror(child);
		}

		int i = 0;
		int j = node.children.size() - 1;
		while (i < j) {
			Node in = node.children.get(i);
			Node jn = node.children.get(j);

			node.children.set(i, jn);
			node.children.set(j, in);
			i++;
			j--;

		}
	}

	public void AtaLevel(int level) {
		AtaLevel(root, level, 0);
	}

	private void AtaLevel(Node node, int level, int count) {

		if (level == count) {
			System.out.println(node.data);
			return;
		}

		for (Node child : node.children) {
			AtaLevel(child, level, count + 1);

		}

	}

	public void Linearize() {
		Linearize(root);
	}

	private void Linearize(Node node) {

		for (Node child : node.children) {
			Linearize(child);
		}

		while (node.children.size() > 1) {
			Node temp = node.children.remove(1);
			Node tail = getTail(node.children.get(0));
			tail.children.add(temp);
		}

	}

	private Node getTail(Node node) {

		if (node.children.size() == 0)
			return node;

		return getTail(node.children.get(0));
	}

	public void display2() {
		display2(root);
	}

	private void display2(Node node) {

		System.out.println("Hii " + node.data);

		for (int i = node.children.size() - 1; i >= 0; i--) {

			Node child = node.children.get(i);

			System.out.println("Going towards " + child.data);
			display2(child);
			System.out.println("Coming back from " + child.data);

		}

		System.out.println("Bye " + node.data);

	}

	public void preorder() {
		preorder(root);
		System.out.println();
	}

	private void preorder(Node node) {

		// N
		System.out.print(node.data + " ");

		// C
		for (Node child : node.children)
			preorder(child);

	}

	public void postorder() {
		postorder(root);
		System.out.println();
	}

	private void postorder(Node node) {

		// C
		for (Node child : node.children)
			postorder(child);

		// N
		System.out.print(node.data + " ");

	}

	public void levelorder() {

		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {

			// remove
			Node rn = q.remove() ;

			// print
			System.out.print(rn.data + " ");

			// child enqueue
			for(Node child : rn.children)
				q.add(child) ;

		}

		System.out.println();
	}

	public void levelorderLinewise() {

		Queue<Node> q = new LinkedList<>();
		Queue<Node> h = new LinkedList<>();

		q.add(root);
		
		

		while (!q.isEmpty()) {

			// remove
			Node rn = q.remove() ;

			// print
			System.out.print(rn.data + " ");

			// child enqueue
			for(Node child : rn.children)
				h.add(child) ;

			if(q.isEmpty()) {
				System.out.println();
				q = h ;
				h = new LinkedList<>() ;
			}

		}

		System.out.println();
	}

	public void levelorderzigzagwise() {
		Stack<Node> s = new Stack<>();
		Stack<Node> h = new Stack<>();
		

		int c = 0;
		s.add(root);
		
		while(!s.empty()) {
			
			Node rn = s.pop();
			
			System.out.println(rn.data +" ");
			
			if(c  % 2 == 0) {
				for(Node child : rn.children) 
					h.push(child);
			}
				
				else {
					for(int i = rn.children.size()-1; i>=0; i--)
						h.push(rn.children.get(i));
				}
			
			if(s.isEmpty()) {
				System.out.println();
				
				c++;
				
			}
			
			}
		}
		
	private int sumOfNodes(Node node) {
		Queue<Node> q = new LinkedList<>();
	   Queue<Node> h = new LinkedList<>();

	q.add(root);
	
	int sum = 0;

	while (!q.isEmpty()) {

		// remove
		Node rn = q.remove() ;

		// add
		sum += rn.data;

		// child enqueue
		for(Node child : rn.children)
			h.add(child) ;

		if(q.isEmpty()) {
			
			q = h ;
			h = new LinkedList<>() ;
		}

	}
	
	return sum;

		
	}

}


