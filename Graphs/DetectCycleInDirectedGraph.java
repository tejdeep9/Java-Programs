import java.util.Set;
import java.util.Map;
import java.util.List;
import java.io.*;

//graph is represented as adjacency list complexity: O(V+E)
class Graph {
	private HashSet<String> vertices;
	private HashMap<String, List<String>> edges;
	
	Graph(){
		vertices = new HashSet<String>();
		edges = new HashMap<String, List<String>>();
	}
	
	public void addEdge(String fromVertex, String toVertex) {
		if(!vertices.contains(fromVertex)) {
			vertices.add(fromVertex);
            edges.put(fromVertex, new LinkedList<String>());
		}
		if(!vertices.contains(toVertex)) {
			vertices.add(toVertex);
            edges.put(toVertex, new LinkedList<String>());
		}
        edges.get(fromVertex).add(toVertex);
	}
	
	private void moveVertex(String vertex, Set<String> sourceSet, Set<String> destSet) {
		if(sourceSet.contains(vertex)) {
			sourceSet.remove(vertex);
			destSet.add(vertex);
		}
	}
	
	private boolean dfsUtil(String vertex, Set<String> unVisited, Set<String> visiting, Set<String> visited){
		moveVertex(vertex, unVisited, visiting);
        for(String neighbour: edges.get(vertex)) {
            if(visited.contains(neighbour)) {
                continue;
            } else if(visiting.contains(neighbour)) {
                return true;
            } else {
                if(dfsUtil(neighbour, unVisited, visiting, visited)) {
                    System.out.print(vertex+"->"+neighbour+"->");
                    return true;
                }
            }
        }
    
		moveVertex(vertex,visiting, visited);
		return false;
	}
	public boolean detectCycle() {
		Set<String> unVisited = new HashSet<String>();
		Set<String> visiting = new HashSet<String>();
		Set<String> visited = new HashSet<String>();
		
		unVisited.addAll(vertices);
		
		for(String vertex: vertices) {
            if(!visited.contains(vertex)) {
                if(dfsUtil(vertex, unVisited, visiting, visited)) {
                     System.out.println();
                    return true;
                }
            }   
		}
		
		return false;
	}
};

public class Solution {
	public static void main(String[] args) {
		Graph g = new Graph();
		g.addEdge("5", "6");
		g.addEdge("4", "5");
		g.addEdge("6", "4");
		g.addEdge("1", "2");
		g.addEdge("2", "3");
		g.addEdge("1", "3");
		System.out.println(g.detectCycle());
	}
}
