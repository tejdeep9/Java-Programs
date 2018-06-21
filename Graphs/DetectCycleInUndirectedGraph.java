import java.util.Map;
import java.util.Set;
import java.util.List;
import java.lang.String;
//time and space complexity O(V+E)
class Graph {
	private HashSet<String> vertices;
	private HashMap<String, List<String>> edges;
	
	Graph() {
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
		edges.get(toVertex).add(fromVertex);
	}
	
	public boolean dfsUtil(String vertex, Set<String> visited, String parent) {
		visited.add(vertex);
		
		for(String neighbour: edges.get(vertex)) {
				if(visited.contains(neighbour) && !neighbour.equals(parent)) {
					System.out.print(neighbour);
					return true;
				} else if(neighbour.equals(parent)) {
					continue;
				} else {
					if(dfsUtil(neighbour, visited, vertex)) {
						System.out.print("-"+neighbour);
						return true;
					}
				}
		}
		return false;
	}
	public boolean detectCycle() {
		HashSet<String> visited = new HashSet<String>();
		for(String vertex: vertices) {
			if(!visited.contains(vertex)) {
				String parent = null;
				if(dfsUtil(vertex, visited, parent)) {
                    System.out.println();
					return true;
				}
			}
		}
		return false;
	}
}

public class Solution {
	public static void main(String[] args) {
		Graph g = new Graph();
		g.addEdge("A", "F");
		g.addEdge("A", "B");
		g.addEdge("B", "C");
		g.addEdge("B", "E");
		g.addEdge("C", "D");
		g.addEdge("D", "E");
		System.out.println(g.detectCycle());
	}
}