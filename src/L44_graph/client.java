package L44_graph;

import java.util.HashSet;

public class client {

	public static void main(String[] args) {

		Graph g = new Graph(4 );

//		g.addEdge(1, 2, 2);
//		g.addEdge(2, 3, 3);
//		g.addEdge(1, 4, 10);
//		g.addEdge(3, 4, 1);
//		g.addEdge(4, 5, 8);
//		g.addEdge(5, 6, 5);
//		g.addEdge(5, 7, 6);
//		
//		
//		g.addEdge(1, 2, 8);
//		g.addEdge(1, 4, 5);
//		g.addEdge(3, 4, -3);
//		g.addEdge(1, 3, 4);
//		g.addEdge(5, 2, 1);
//		g.addEdge(4, 5, 4);
//		g.addEdge(2, 5, -2 );
		
		g.addEdge(1, 2, 3);
		g.addEdge(2, 3, 2);
		g.addEdge(1, 4, 7);
		g.addEdge(3, 4, 1);
		g.addEdge(4, 1, 2);
		g.addEdge(2, 1, 8);
		g.addEdge(3, 1, 5);
		
		
    	g.display();
//
//		System.out.println(g.containsEdge(1, 2));
//		System.out.println(g.numEdges());
//
//	g.removeEdge(4, 5);
////		g.removeEdge(3, 4);
//		
//////		System.out.println(g.haspath(1, 6, new HashSet<Integer>()));
//////		
////		g.printAllPaths(1, 6,new HashSet<Integer>() , "");
////		
////		System.out.println(g.DFS(1, 6));   
//
////		g.BFT();
////
////		g.DFT();
//		
//		System.out.println(g.isCyclic());
//		System.out.println(g.isTree());
//		System.out.println(g.getCC());
		
//		g.Kruskal();
		
//		g.Dijkstra(1);
		
//		g.bellmanFord(1);
    	
    	g.floydWarshall();
		
	}

}
