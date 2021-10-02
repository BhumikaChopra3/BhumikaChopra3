package L50_TrieHuffman;

import java.util.HashMap;

public class Trie {

	private class Node {
		char ch;
		boolean eow;
		HashMap<Character, Node> map;

		public Node(char ch) {
			this.ch = ch;
			this.eow = false;
			map = new HashMap<>();

		}

	}

	private Node root;

	public Trie() {
		root = new Node('*');

	}
	
	public void addWord(String word) {
		addWord(root,word);
	}

	private void addWord(Node node, String word) {
		
		char ch = word.charAt(0);
		String row = word.substring(1);
		
		boolean charIsPresent = node.map.containsKey(ch);
		
		if(charIsPresent) {
			addWord(node.map.get(ch), row);
		}
		
	}
	
}
