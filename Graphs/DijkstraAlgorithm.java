import java.util.*;
import java.lang.*;
import java.io.*;


class Graph
{
	class Edge {
		String toVertex;
		String fromVertex;
		Integer weight;
		
		Edge(String toVertex, String fromVertex, Integer weight) {
			this.toVertex = toVertex;
			this.fromVertex = fromVertex;
			this.weight = weight;
		}	
	}
	
	class Node {
		String key;
		Integer weight;
		
		Node(String key, Integer weight) {
			this.key = key;
			this.weight = weight;
		}
	}
	
	private Set<String> vertices;
	private List<Edge>  edges;
	
	Graph() {
		vertices = new HashSet<String>();
		edges = new ArrayList<Edge>();
	}
	
	public void addEdge(String fromVertex, String toVertex, Integer weight) {
		if(!vertices.contains(fromVertex))
			vertices.add(fromVertex);
		if(!vertices.contains(toVertex))
			vertices.add(toVertex);
		
		Edge edge = new Edge(fromVertex, toVertex, weight);
		edges.add(edge);
	}
	
	private List<Node> getNeighbours(String vertex) {
		List<Node> neighbours = new ArrayList<Node>();
		if(!vertices.contains(vertex))
				return neighbours;
			
		for(Edge edge: edges) {
			if(vertex.equals(edge.toVertex)) {
				neighbours.add(new Node(edge.fromVertex, edge.weight));
			} else  if(vertex.equals(edge.fromVertex)) {
				neighbours.add(new Node(edge.toVertex, edge.weight));
			}
		}
		return neighbours;
	}
	
	public void dijstras(String source) {
		Map<String, String> parent = new HashMap<String, String>();
		Map<String, Integer> distance = new HashMap<String, Integer>();
		
		Comparator comp = new Comparator<Node>() {
			public int compare(Node n1, Node n2) {
				return (n1.weight-n2.weight);
			}
		};
		PriorityQueue<Node> pq = new PriorityQueue<Node>(comp);
		Map<String, Node> heapMap = new HashMap<String, Node>();
		
		for(String vertex: vertices) {
			Node node;
			if(vertex.equals(source)) {
				node = new Node(vertex, 0);
			} else {
				node = new Node(vertex, Integer.MAX_VALUE);
			}	
			pq.add(node);
			heapMap.put(vertex, node);
			parent.put(vertex, null);
		}
		
		while(!heapMap.isEmpty()) {
			Node top = pq.poll();
			String vertex = top.key;
			Integer weight = top.weight;
			
			heapMap.remove(vertex);
			distance.put(vertex, weight);
			
			List<Node> neighbours = getNeighbours(vertex);
		
			for(Node neighbour: neighbours) {
				
				if(!distance.containsKey(neighbour.key) && heapMap.get(neighbour.key).weight > weight+neighbour.weight) {
					pq.remove(heapMap.get(neighbour.key));
					Node newNode = new Node(neighbour.key, weight+neighbour.weight);
					pq.add(newNode);
					heapMap.replace(neighbour.key, newNode);
					parent.replace(neighbour.key, vertex);
				}
			
			}
		}
		
		System.out.println(distance);
		System.out.println(parent);
		
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Graph g = new Graph();
		g.addEdge("a" ,"b" ,5);
		g.addEdge("b" ,"c" ,2);
		g.addEdge("c" ,"d" ,3);
		g.addEdge("d" ,"f" ,2);
		g.addEdge("a" ,"e" ,2);
		g.addEdge("a" ,"d" ,9);
		g.addEdge("e" ,"f" ,3);
		g.dijstras("a");
	}
}
