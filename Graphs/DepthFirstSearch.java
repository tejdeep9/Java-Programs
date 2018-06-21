/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Graph
{	
	private int V;
	private LinkedList<Integer>[] adj;
	
	Graph(int V) {
		this.V = V;
		adj = new LinkedList[V];
		
		for(int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	private void DFSUtil(int s, boolean[] visited) {
		visited[s] = true;
		System.out.println(s);
		
		Iterator<Integer> it = adj[s].listIterator();
		
		while(it.hasNext()) {
			int n = it.next();
			if(!visited[n]) {
				DFSUtil(n, visited);
			}
		}
		
	}
	public void DFS(int s) {
		boolean[] visited = new boolean[V];
		DFSUtil(s, visited);
		
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Graph g = new Graph(4);
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		g.DFS(2);
	}
}