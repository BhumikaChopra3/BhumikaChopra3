package L44_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	HashMap<Integer, HashMap<Integer, Integer>> map;

	public Graph(int V) {
		map = new HashMap<>();

		for (int i = 1; i <= V; i++) {
			map.put(i, new HashMap<>());

		}
	}

	public void addEdge(int v1, int v2, int cost) {

		map.get(v1).put(v2, cost);
		// map.get(v2).put(v1, cost);

	}

	public boolean containsEdge(int v1, int v2) {

		return map.get(v1).containsKey(v2);

	}

	public void removeEdge(int v1, int v2) {

		map.get(v1).remove(v2);
		map.get(v2).remove(v1);
	}

	public int numEdges() {

		int sum = 0;

		for (int key : map.keySet()) {
			sum += map.get(key).size();

		}

		return sum / 2;

	}

	public void display() {

		for (int key : map.keySet()) {
			System.out.println(key + ":" + map.get(key));
		}

	}

	public boolean haspath(int src, int dst, HashSet<Integer> visited) {

		visited.add(src);

		if (src == dst)
			return true;

		for (int nbr : map.get(src).keySet()) {

			if (!visited.contains(nbr)) {

				boolean res = haspath(nbr, dst, visited);

				if (res)
					return true;

			}
		}

		return false;

	}

	public void printAllPaths(int src, int dst, HashSet<Integer> visited, String str) {

		visited.add(src);

		if (src == dst) {
			System.out.println(str + dst);
			visited.remove(src);
			return;

		}

		for (int nbr : map.get(src).keySet()) {

			if (!visited.contains(nbr)) {

				printAllPaths(nbr, dst, visited, str + src);
			}
		}

		visited.remove(src);
	}

	public boolean BFS(int src, int dst) {

		HashSet<Integer> visited = new HashSet<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();

		q.add(src);

		while (!q.isEmpty()) {

			int rn = q.remove();

			if (visited.contains(rn))
				continue;

			visited.add(rn);

			if (rn == dst)
				return true;

			for (int nbrs : map.get(rn).keySet()) {

				if (!visited.contains(nbrs)) {
					q.add(nbrs);
				}

			}

		}

		return false;

	}

	public boolean DFS(int src, int dst) {

		HashSet<Integer> visited = new HashSet<Integer>();
		Stack<Integer> q = new Stack<Integer>();

		q.push(src);

		while (!q.isEmpty()) {

			int rn = q.pop();

			if (visited.contains(rn))
				continue;

			visited.add(rn);

			if (rn == dst)
				return true;

			for (int nbrs : map.get(rn).keySet()) {

				if (!visited.contains(nbrs)) {
					q.push(nbrs);
				}

			}

		}

		return false;

	}

	public void BFT() {

		HashSet<Integer> visited = new HashSet<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();

		for (int src : map.keySet()) {
			q.add(src);

			if (visited.contains(src))
				continue;

			while (!q.isEmpty()) {

				int rn = q.remove();

				if (visited.contains(rn))
					continue;

				visited.add(rn);

				System.out.print(rn);

				for (int nbrs : map.get(rn).keySet()) {

					if (!visited.contains(nbrs)) {
						q.add(nbrs);
					}

				}

			}
			System.out.println();

		}

	}

	public void DFT() {

		HashSet<Integer> visited = new HashSet<Integer>();
		Stack<Integer> q = new Stack<Integer>();

		for (int src : map.keySet()) {
			q.push(src);

			if (visited.contains(src))
				continue;

			while (!q.isEmpty()) {

				int rn = q.pop();

				if (visited.contains(rn))
					continue;

				visited.add(rn);

				System.out.print(rn);

				for (int nbrs : map.get(rn).keySet()) {

					if (!visited.contains(nbrs)) {
						q.push(nbrs);
					}

				}

			}

			System.out.println();

		}

	}

	public boolean isCyclic() {

		HashSet<Integer> visited = new HashSet<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();

		for (int src : map.keySet()) {

			if (visited.contains(src))
				continue;

			q.add(src);

			while (!q.isEmpty()) {

				int rn = q.remove();

				if (visited.contains(rn))
					return true;

				visited.add(rn);

				for (int nbrs : map.get(rn).keySet()) {

					if (!visited.contains(nbrs)) {
						q.add(nbrs);
					}

				}

			}

		}

		return false;

	}

	public boolean isConnected() {

		int components = 0;

		HashSet<Integer> visited = new HashSet<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();

		for (int src : map.keySet()) {

			if (visited.contains(src))
				continue;

			components++;

			q.add(src);

			while (!q.isEmpty()) {

				int rn = q.remove();

				if (visited.contains(rn))
					continue;

				visited.add(rn);

				for (int nbrs : map.get(rn).keySet()) {

					if (!visited.contains(nbrs)) {
						q.add(nbrs);
					}

				}

			}

		}

		return components == 1;

	}

	public boolean isTree() {

		return isConnected() && !isCyclic();

	}

	public ArrayList<ArrayList<Integer>> getCC() {

		ArrayList<ArrayList<Integer>> bl = new ArrayList<>();

		HashSet<Integer> visited = new HashSet<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();

		for (int src : map.keySet()) {

			if (visited.contains(src))
				continue;

			ArrayList<Integer> sl = new ArrayList<>();

			bl.add(sl);

			q.add(src);

			while (!q.isEmpty()) {

				int rn = q.remove();

				if (visited.contains(rn))
					continue;

				visited.add(rn);

				sl.add(rn);

				for (int nbrs : map.get(rn).keySet()) {

					if (!visited.contains(nbrs)) {
						q.add(nbrs);
					}

				}

			}

		}

		return bl;

	}

	private class DisjointSet {

		private class Node {
			int data;
			Node parent;
			int rank;
		}

		private HashMap<Integer, Node> mapping = new HashMap<>();

		public void create(int value) {

			Node nn = new Node();
			nn.data = value;
			nn.parent = nn;
			nn.rank = 0;

			mapping.put(value, nn);

		}

		public void union(int value1, int value2) {

			Node n1 = mapping.get(value1);
			Node n2 = mapping.get(value2);
			Node re1 = find(n1);
			Node re2 = find(n2);

			if (re1 == re2)
				return;
			else {

				if (re1.rank == re2.rank) {
					re2.parent = re1;
					re1.rank++;

				} else if (re1.rank > re2.rank) {
					re2.parent = re1;

				} else {
					re1.parent = re2;

				}

			}

		}

		public int find(int value) {

			Node n = mapping.get(value);
			return find(n).data;

		}

		private Node find(Node node) {

			if (node.parent == node)
				return node;

			Node rr = find(node.parent);
			// path compression
			node.parent = rr;
			return rr;

		}
	}

	private class EdgePair implements Comparable<EdgePair> {

		int v1;
		int v2;
		int cost;

		public EdgePair(int v1, int v2, int cost) {
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}

		@Override
		public int compareTo(EdgePair o) {

			return this.cost - o.cost;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return v1 + "-" + v2 + "@" + cost;
		}
	}

	public ArrayList<EdgePair> getAllEdges() {

		ArrayList<EdgePair> edges = new ArrayList<>();

		for (int vertex : map.keySet()) {

			for (int nbr : map.get(vertex).keySet()) {

				EdgePair np = new EdgePair(vertex, nbr, map.get(vertex).get(nbr));
				edges.add(np);
			}
		}

		return edges;

	}

	// minimum spanning tree algos

	public void Kruskal() {

		DisjointSet ds = new DisjointSet();

		for (int vertex : map.keySet()) {

			// create a new set for all the vertices
			ds.create(vertex);
		}

		// get all edges
		ArrayList<EdgePair> edges = getAllEdges();
		// edges sort on the basis of cost
		Collections.sort(edges);

		for (EdgePair e : edges) {

			int re1 = ds.find(e.v1);
			int re2 = ds.find(e.v2);

			if (re1 == re2) {
				// do nothing
			} else {
				System.out.println(e);
				ds.union(e.v1, e.v2);
			}

		}

	}

	private class PrimsPair implements Comparable<PrimsPair> {

		int vname;
		int acqvname;
		int cost;

		public PrimsPair(int vname, int acqvname, int cost) {
			this.vname = vname;
			this.acqvname = acqvname;
			this.cost = cost;

		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return vname + "via" + acqvname + "@" + cost;
		}

		@Override
		public int compareTo(PrimsPair o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}

	public void prims() {

		PriorityQueue<PrimsPair> pq = new PriorityQueue<>();

		boolean[] visited = new boolean[map.size() + 1];

		// creating a starting pair
		PrimsPair sp = new PrimsPair(1, 0, 0);
		// put pair in priority queue
		pq.add(sp);

		while (!pq.isEmpty()) {

			// remove pair with min cost
			PrimsPair rp = pq.remove();

			if (visited[rp.vname])
				continue;

			visited[rp.vname] = true;

			if (rp.acqvname != 0)
				System.out.println(rp);

			for (int nbr : map.get(rp.vname).keySet()) {

				if (!visited[nbr]) {
					PrimsPair np = new PrimsPair(nbr, rp.vname, map.get(rp.vname).get(rp.acqvname));
					pq.add(np);
				}

			}

		}
	}

	// Single source shortest path algos

	private class DijkstraPair implements Comparable<DijkstraPair> {

		int vname;
		String psf;
		int csf;

		public DijkstraPair(int vname, String acqvname, int cost) {
			this.vname = vname;
			this.psf = acqvname;
			this.csf = cost;

		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return vname + " via " + psf + " " + "@ " + csf;
		}

		@Override
		public int compareTo(DijkstraPair o) {
			// TODO Auto-generated method stub
			return this.csf - o.csf;
		}
	}

	public void Dijkstra(int src) {

		PriorityQueue<DijkstraPair> pq = new PriorityQueue<>();

		boolean[] visited = new boolean[map.size() + 1];

		// creating a starting pair
		DijkstraPair sp = new DijkstraPair(src, src + "", 0);
		// put pair in priority queue
		pq.add(sp);

		while (!pq.isEmpty()) {

			// remove pair with min cost
			DijkstraPair rp = pq.remove();

			if (visited[rp.vname])
				continue;

			visited[rp.vname] = true;

			System.out.println(rp);

			for (int nbr : map.get(rp.vname).keySet()) {

				if (!visited[nbr]) {
					DijkstraPair np = new DijkstraPair(nbr, rp.psf + nbr, rp.csf + map.get(rp.vname).get(nbr));
					pq.add(np);
				}

			}

		}
	}

	public void bellmanFord(int src) {

		int V = map.size();

		int[] distance = new int[V + 1];

		Arrays.fill(distance, 100000);

		distance[src] = 0;

		ArrayList<EdgePair> edges = getAllEdges();

		// relax v-1 times
		for (int i = 1; i <= V; i++) {

			for (EdgePair edge : edges) {

				int oc = distance[edge.v2];
				int nc = distance[edge.v1] + edge.cost;

				if (nc < oc) {
					if (i < V - 1)
						distance[edge.v2] = nc;
					else {
						System.out.println("-ve wt cycle is present");
						return;
					}
				}

			}
		}

		for (int i = 1; i <= V; i++) {
			System.out.println(i + " -> " + distance[i]);
		}

	}

	// All pair shortest path

	public void floydWarshall() {

		int V = map.size();

		int[][] dist = new int[V + 1][V + 1];

		for (int i = 1; i < dist.length; i++) {

			for (int j = 1; j < dist[0].length; j++) {

				if (i == j)
					dist[i][j] = 0;
				else
					dist[i][j] = 100000;
			}
		}

		for (int vertex : map.keySet()) {

			for (int nbr : map.get(vertex).keySet()) {

				dist[vertex][nbr] = map.get(vertex).get(nbr);
			}
		}

		// logic
		for (int k = 1; k <= V; k++) {

			for (int i = 1; i <= V; i++) {

				for (int j = 1; j <= V; j++) {

					int oc = dist[i][j];

					int nc = dist[i][k] + dist[k][j];

					if (nc < oc)
						dist[i][j] = nc;

				}
			}
		}

		for (int i = 1; i <= V; i++) {

			for (int j = 1; j <= V; j++) {

				System.out.print(dist[i][j] + "\t");
			}

			System.out.println();
		}

	}

}
