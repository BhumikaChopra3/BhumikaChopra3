package L33_BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	

		static Scanner scn = new Scanner(System.in);

		public static void main(String[] args) {
			Main m = new Main();
			BinaryTree bt1 = m.new BinaryTree();
			bt1.treeLeftview();
		}

		private class BinaryTree {
			private class Node {
				int data;
				Node left;
				Node right;
			}

			private Node root;
			private int size;

			public BinaryTree() {
				this.root = this.takeInput(null, false);
			}

			public Node takeInput(Node parent, boolean ilc) {

				int cdata = scn.nextInt();
				Node child = new Node();
				child.data = cdata;
				this.size++;

				// left
				boolean hlc = scn.nextBoolean();

				if (hlc) {
					child.left = this.takeInput(child, true);
				}

				// right
				boolean hrc = scn.nextBoolean();

				if (hrc) {
					child.right = this.takeInput(child, false);
				}

				// return
				return child;
			}

			public ArrayList<ArrayList<Integer>> levelArrayList() {

				// write your code here
				ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		        Queue<Node> queue = new LinkedList<>();
		        if(root == null)
		            return ans;
		        
		        queue.add(root);
		        
		        while(queue.isEmpty() == false)
		        {
		            int size = queue.size();
		            ArrayList<Integer> list = new ArrayList<>();
		            for(int i = 0; i < size; i++)
		            {
		               Node node = queue.remove();
		                list.add(node.data);
		                if(node.left != null)
		                    queue.add(node.left);
		                if(node.right != null)
		                    queue.add(node.right);
		            }
		            ans.add(list);
		        }
		        return ans;
			}
			
			public void treeLeftview() {
				treeLeftview(root, 1);
			}
			
			private int max_level = 0;
			
			private void treeLeftview(Node node, int level) {
			     if (node == null)
				 return;

			     if (max_level < level) {
			            System.out.print(" " + node.data);
			            max_level = level;
			     }
			            
			      System.out.println(node.data + " ");
			
			     treeLeftview(node.left,level++);
			     treeLeftview(node.right, level++);
			
			
			
		        }


		}

	}


