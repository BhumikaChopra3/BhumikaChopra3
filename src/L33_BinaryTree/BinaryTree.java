package L33_BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {

	Scanner scn = new Scanner(System.in);

	private class Node {

		int data;
		Node left;
		Node right;

	}

	private Node root;

	public BinaryTree() {
		construct(null, true);

	}

	private Node construct(Node parent, boolean ilc) {

		if (parent == null)
			System.out.println("Enter the data for root node");
		else {

			if (ilc)
				System.out.println("Enter the data for left child of " + parent.data + "?");
			else
				System.out.println("Enter the data for right child of " + parent.data + "?");
		}

		int item = scn.nextInt();

		Node nn = new Node();
		nn.data = item;

		System.out.println(nn.data + " has a left child?");
		boolean hlc = scn.nextBoolean();

		if (hlc == true)
			nn.left = construct(nn, true);

		System.out.println(nn.data + " has a right child?");
		boolean hrc = scn.nextBoolean();

		if (hrc == true)
			nn.left = construct(nn, false);

		return nn;
	}

	public BinaryTree(int[] pre, int[] in) {
		root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}
	
	private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {

		if(plo > phi || ilo > ihi)
			return null ;

		Node nn = new Node();
		nn.data = pre[plo];

		int si = -1;
		int nel = 0;

		for (int i = ilo; i <= ihi; i++) {

			if (in[i] == pre[plo]) {
				si = i;
				break;
			}

			nel++;
		}

		nn.left = construct(pre, plo + 1, plo + nel, in, ilo, si - 1);
		nn.right = construct(pre, plo + nel + 1, phi, in, si + 1, ihi);
		
		return nn;

		
	}

	public void levelOrder() {
		LinkedList<Node> queue = new LinkedList<>();

		queue.add(this.root);
		while (!queue.isEmpty()) {
			Node rv = queue.removeFirst();
			System.out.println(rv.data + ",");
			if (rv.left != null) {
				queue.addLast(rv.left);
			}
			if (rv.right != null) {
				queue.addLast(rv.right);
			}
		}
	}

	public List<List<Integer>> levelorder2() {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;

		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (q.size() > 0) {
			ArrayList<Integer> level = new ArrayList<>();

			int size = q.size();

			for (int i = 0; i < size; i++) {
				Node head = q.remove();
				level.add(head.data);

				if (head.left != null) {
					q.add(head.left);
				}
				if (head.right != null) {
					q.add(head.right);
				}

			}
			res.add(0, level); // ie addFist at index instead going top to bottom the
			// top value shiftgs makes place for new values

		}
		return res;

	}

	public int LCA(int p, int q) {

		if (root == null)
			return 0;

		ArrayList<Integer> plist = new ArrayList<>();
		ArrayList<Integer> qlist = new ArrayList<>();

		nodeTorootPath(root, p, plist);
		nodeTorootPath(root, q, plist);

		int i = plist.size() - 1;
		int j = qlist.size() - 1;
		while (i >= 0 && j >= 0 && plist.get(i) == qlist.get(j)) {
			i--;
			j--;
		}
		i++;
		j++;

		return plist.get(i);

	}

	private boolean nodeTorootPath(Node root, int given, ArrayList<Integer> list) {
		// TODO Auto-generated method stub
		if (root == null)
			return false;

		if (root.data == given) {
			list.add(given);
			return true;
		}
		boolean lans = nodeTorootPath(root.left, given, list);
		if (lans) {
			list.add(root.data);
			return true;
		}
		boolean rans = nodeTorootPath(root.right, given, list);
		if (rans) {
			list.add(root.data);
			return true;
		}
		return false;

	}

	public List<List<Integer>> levelOrderZZ() {

		Queue<Node> q = new LinkedList();
		int count = 0;
		List<List<Integer>> traversal = new ArrayList();

		if (root != null)
			q.add(root);

		while (q.size() > 0) {
			int size = q.size();
			LinkedList<Integer> list = new LinkedList();
			String ans = new String();
			while (size > 0) {
				Node node = q.poll();
				if (count % 2 == 0) {
					list.add(node.data);
					ans += node.data + " ";
				} else {
					list.addFirst(node.data);
				}

				if (node.left != null)
					q.add(node.left);

				if (node.right != null)
					q.add(node.right);

				size--;
			}
			traversal.add(list);
			count++;
		}

		return traversal;

	}

	public void levelOrderZZdisplay() {

		// write your code here
		Queue<Node> q = new LinkedList();
		int count = 0;

		if (root != null)
			q.add(root);

		while (q.size() > 0) {
			int size = q.size();
			while (size > 0) {
				Node node = q.poll();
				if (count % 2 == 0)
					System.out.println(node.data + " ");
				else
					System.out.println(node.data + " ");

				if (node.left != null)
					q.add(node.left);

				if (node.right != null)
					q.add(node.right);

				size--;
			}

			count++;
		}

	}

	public void display() {
		System.out.println("-----------------");
		display(root);
		System.out.println("-----------------");
	}

	private void display(Node node) {

		if (node == null)
			return;

		String str = "";

		if (node.left == null)
			str += ".";
		else
			str += node.left.data;

		str += "->" + node.data + "<-";

		if (node.right == null)
			str += ".";
		else
			str += node.right.data;

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {

		if (node == null)
			return 0;

		int ls = size(node.left);
		int rs = size(node.right);

		return ls + rs + 1;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		if (node == null)
			return Integer.MIN_VALUE;

		int lm = max(node.left);
		int rm = max(node.right);

		return Math.max(node.data, Math.max(lm, rm));

	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null)
			return false;

		if (node.data == item) {
			return true;
		}

		boolean cfl = find(node.left, item);
		boolean cfr = find(node.right, item);

		if (cfl)
			return true;
		else if (cfr)
			return true;

		return false;
	}

	public int ht() {
		return ht(root);
	}

	private int ht(Node node) {

		if (node == null)
			return -1;

		int chl = ht(node.left);
		int chr = ht(node.right);

		return Math.max(chl, chr) + 1;

	}

	private int max = Integer.MIN_VALUE;

	public int diameter() {
		diameter(root);
		return max;
	}

	private void diameter(Node node) {

		if (node == null)
			return;

		diameter(node.left);
		diameter(node.right);

		int presentDiameterRootNode = ht(node.left) + ht(node.right) + 2;

		if (presentDiameterRootNode > max)
			max = presentDiameterRootNode;

	}

	public int diameter2() {
		return diameter2(root);
	}

	private int diameter2(Node node) {

		if (node == null)
			return 0;

		int ld = diameter2(node.left);
		int rd = diameter2(node.right);

		int sd = ht(node.left) + ht(node.right) + 2; // self node diameter root node -> max distance ?

		return Math.max(sd, Math.max(ld, rd));

	}

	private class DiaPair {
		int diameter = 0;
		int ht = -1;
	}

	public int diameter3() {
		return diameter3(root).diameter;
	}

	private DiaPair diameter3(Node node) {

		if (node == null) {
			return new DiaPair();
		}

		DiaPair ldp = diameter3(node.left);
		DiaPair rdp = diameter3(node.right);

		DiaPair sdp = new DiaPair();

		// sdp diameter
		int ld = ldp.diameter;
		int rd = rdp.diameter;
		int sd = ldp.ht + rdp.ht + 2;

		sdp.diameter = Math.max(sd, Math.max(ld, rd));

		// sdp ht
		sdp.ht = Math.max(ldp.ht, rdp.ht) + 1;

		return sdp;

	}

	private boolean res = true;

	public boolean isBalanced() {
		isBalanced(root);
		return res;
	}

	private void isBalanced(Node node) {

		if (node == null)
			return;

		isBalanced(node.left);
		isBalanced(node.right);

		int bf = ht(node.left) - ht(node.right);

		if (bf <= -2 || bf >= 2)
			res = false;

	}

	public boolean isBalanced2() {
		return isBalanced2(root);
	}

	private boolean isBalanced2(Node node) {

		if (node == null)
			return true;

		boolean lb = isBalanced2(node.left);
		boolean rb = isBalanced2(node.right);

		int bf = ht(node.left) - ht(node.right);

		if (lb && rb && (bf == -1 || bf == 0 || bf == 1))
			return true;
		else
			return false;
	}

	private class BalPair {
		boolean isBal = true;
		int ht = -1;
	}

	public boolean isBalanced3() {
		return isBalanced3(root).isBal;
	}

	private BalPair isBalanced3(Node node) {

		if (node == null)
			return new BalPair();

		BalPair lbp = isBalanced3(node.left);
		BalPair rbp = isBalanced3(node.right);

		BalPair sbp = new BalPair();

		// sbp isBal
		boolean lb = lbp.isBal;
		boolean rb = rbp.isBal;
		int bf = lbp.ht - rbp.ht;

		if (lb && rb && (bf == -1 || bf == 0 || bf == 1))
			sbp.isBal = true;
		else
			sbp.isBal = false;

		// sbp ht
		sbp.ht = Math.max(lbp.ht, rbp.ht) + 1;

		return sbp;

	}

	public boolean flipEquivalent(BinaryTree other) {

		return flipEquivalent(this.root, other.root);
	}

	private boolean flipEquivalent(Node n1, Node n2) {

		if (n1 == null && n2 == null)
			return true;

		if (n1 == null || n2 == null)
			return false;

		if (n1.data != n2.data)
			return false;

		boolean flip = flipEquivalent(n1.left, n2.right) && flipEquivalent(n1.right, n2.left);

		if (flip)
			return true;

		boolean noflip = flipEquivalent(n1.left, n2.left) && flipEquivalent(n1.right, n2.right);

		return flip || noflip;

	}

	public void display2() {
		display2(root);
	}

	private void display2(Node node) {

		if (node == null)
			return;

		System.out.println("hii " + node.data);

		display2(node.left);
		System.out.println("coming back from left child and going towards right");
		display2(node.right);

		System.out.println("byee " + node.data);

	}

	public void preOrder() {

		this.preOrder(this.root);
	}

	private void preOrder(Node node) {
		// TODO Auto-generated method stub
		if (node == null)
			return;

		System.out.print(node.data + ",");

		preOrder(node.left);
		preOrder(node.right);

	}
	
	
	
	private class Pair {
		Node n;
		boolean sd;
		boolean ld;
		boolean rd;
	}

	public  void preOrderI() {
	
		Stack<Pair> s = new Stack<>();

		Pair sp = new Pair();
		sp.n = root;

		s.push(sp);

		while (!s.isEmpty()) {

			Pair tp = s.peek();

			if (tp.sd == false) {

				System.out.print(tp.n.data + " ");
				tp.sd = true;

			} else if (tp.ld == false) {

				Pair lp = new Pair();
				lp.n = tp.n.left;

				if (lp.n != null)
					s.push(lp);

				tp.ld = true;

			} else if (tp.rd == false) {

				Pair rp = new Pair();
				rp.n = tp.n.right;

				if (rp.n != null)
					s.push(rp);

				tp.rd = true;

			} else {
				s.pop();
			}

		}

		System.out.println();
		
	}

	public void postOrder() {

		this.postOrder(this.root);
	}

	private void postOrder(Node node) {
		// TODO Auto-generated method stub
		if (node == null)
			return;

		postOrder(node.left);
		postOrder(node.right);

		System.out.print(node.data + ",");

	}

	public void InOrder() {

		this.InOrder(this.root);
	}

	private void InOrder(Node node) {
		// TODO Auto-generated method stub
		if (node == null)
			return;

		InOrder(node.left);

		System.out.print(node.data + ",");

		InOrder(node.right);

	}

	public int sum() {
		return sum(root);
	}

	private int sum(Node node) {

		if (node == null)
			return 0;

		int ls = sum(node.left);
		int rs = sum(node.right);

		return ls + rs + node.data;
	}

	private int maxSum = Integer.MIN_VALUE;

	public int maxSubtreeSum1() {
		return maxSubtreeSum1(root);
	}

	private int maxSubtreeSum1(Node node) {

		if (node == null)
			return 0;

		int ls = maxSubtreeSum1(node.left);
		int rs = maxSubtreeSum1(node.right);

		int ts = ls + rs + node.data;

		if (ts > maxSum)
			maxSum = ts;

		return ts;

	}

	public int maxSubtreeSum2() {
		return maxSubtreeSum2(root);
	}

	private int maxSubtreeSum2(Node node) {

		if (node == null)
			return Integer.MIN_VALUE;

		int lMaxSubtreeSum = maxSubtreeSum2(node.left);
		int rMaxSubtreeSum = maxSubtreeSum2(node.right);

		int selfNodeSum = sum(node.left) + sum(node.right) + node.data;

		return Math.max(selfNodeSum, Math.max(lMaxSubtreeSum, rMaxSubtreeSum));

	}

	// mss : max subtree sum
	private class MSSPair {
		int mss = Integer.MIN_VALUE;
		int entireSum = 0;
	}

	public int maxSubtreeSum3() {
		return maxSubtreeSum3(root).mss;
	}

	private MSSPair maxSubtreeSum3(Node node) {

		if (node == null)
			return new MSSPair();

		MSSPair lp = maxSubtreeSum3(node.left);
		MSSPair rp = maxSubtreeSum3(node.right);

		MSSPair sp = new MSSPair();

		// sp maxSubtreeSum
		sp.mss = Math.max(lp.entireSum + rp.entireSum + node.data, Math.max(lp.mss, rp.mss));

		// sp entiresum
		sp.entireSum = lp.entireSum + rp.entireSum + node.data;

		return sp;

	}

	public void replaceWithSumOfLarger2() {
		System.out.println(replaceWithSumOfLarger2(root, 0));
	}

	private int replaceWithSumOfLarger2(Node node, int val) {

		if (node == null)
			return val;

		int largerSumValues = replaceWithSumOfLarger2(node.right, val);

		int temp = node.data;
		node.data = largerSumValues;

		return replaceWithSumOfLarger2(node.left, largerSumValues + temp);
	}

	public void add(int item) {

		if (root == null) {
			Node nn = new Node();
			nn.data = item;
			root = nn;
		} else {
			add(root, item);
		}
	}

	private void add(Node node, int item) {

		// left
		if (item <= node.data) {

			if (node.left == null) {
				Node nn = new Node();
				nn.data = item;
				node.left = nn;
			} else {
				add(node.left, item);
			}
		}

		// right
		else {
			if (node.right == null) {
				Node nn = new Node();
				nn.data = item;
				node.right = nn;
			} else {
				add(node.right, item);
			}

		}

	}

	public void add2(int item) {

		if (root == null) {
			Node nn = new Node();
			nn.data = item;
			root = nn;
		} else {
			add2(root, null, item);
		}

	}

	private void add2(Node node, Node parent, int item) {

		if (node == null) {
			Node nn = new Node();
			nn.data = item;

			if (item <= parent.data)
				parent.left = nn;
			else
				parent.right = nn;

			return;
		}

		if (item <= node.data)
			add2(node.left, node, item);
		else
			add2(node.right, node, item);

	}
 
	public void add3(int item) {

		root = add3(root, item);
	}

	private Node add3(Node node, int item) {

		if (node == null) {
			Node nn = new Node();
			nn.data = item;
			return nn;
		}

		if (item <= node.data)
			node.left = add3(node.left, item);
		else
			node.right = add3(node.right, item);

		return node;

	}

	public void remove(int item) {

		if (root == null)
			return;

		if (root.data == item) {
			if (root.left == null && root.right == null)
				root = null;
			else if (root.left != null && root.right == null)
				root = root.left;
			else if (root.left == null && root.right != null)
				root = root.right;
			else
				remove(root, null, item);
		} else
			remove(root, null, item);
	}

	private void remove(Node node, Node parent, int item) {

		if (node == null)
			return;

		if (item < node.data)
			remove(node.left, node, item);
		else if (item > node.data)
			remove(node.right, node, item);
		else {

			// case 1 : leaf
			if (node.left == null && node.right == null) {

				if (node.data <= parent.data) // node is left child of parent
					parent.left = null;
				else // node is right child of parent
					parent.right = null;

			}

			// case 2 : left != null && right == null
			else if (node.left != null && node.right == null) {

				if (node.data <= parent.data)
					parent.left = node.left;
				else
					parent.right = node.left;

			}

			// case 3 : left == null && right != null
			else if (node.left == null && node.right != null) {

				if (node.data <= parent.data)
					parent.left = node.right;
				else
					parent.right = node.right;

			}

			// case 4 : left != null && right != null
			else {

				int max = max(node.left);

				remove(node.left, node, max);

				node.data = max;

			}

		}

	}

}
