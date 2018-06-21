/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Graph
{	private int V;
	private LinkedList<Integer> adj[];
	
	Grpah(int V) {
		this.V =V;
		adj = new LinkedList[V];
		
		for(int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	public addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	public void DFSUtil(int v, Stack<Integer> stack) {
		visited[v] = true;
		
		Iterator<Integer> it = ad[v].listIterator();
		
		while(it.hasNext()) {
			int n = it.next();
			
			if(!visited[n])
				DFSUtil(n, stack);
		}
		
		stack.push(v);
	}
	public void topSort() {
		boolean visited[] = new booleand[V];
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < V; i++) {
			if(!visited[i]) {
				DFUtil(i, stack);
			}
		}
		
		while(!stack.empty()) {
			System.out.println(stack.pop());
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
	}
}