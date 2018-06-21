import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.PriorityQueue;
import java.nio.file.*;
import java.util.Comparator;
import java.io.FileNotFoundException;
import java.io.IOException;

class Node {
	int elem;
	Integer index;
	
	Node(Integer elem, int index) {
		this.elem = elem;
		this.index = index;
	}
}
class ExternalSorting {
	
	public static void externalSorting(String fileName, int N) throws IOException, FileNotFoundException  {
		int M = 10;
		int[] buffer = new int[M];
		
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		
		int slices = (int) Math.ceil((double)N/M);
		String tempPrefix ="temp-";
		
		String str;
		
		for(int fileIndex = 0; fileIndex < slices; fileIndex++) {
			
			for(int i = 0; i < M; i++) {
				str = br.readLine();
				if(str != null) {
					buffer[i] = Integer.parseInt(str);
				} else {
					buffer[i] = Integer.MAX_VALUE;
				}
			}
			
			Arrays.sort(buffer);
			
			FileWriter fw = new FileWriter(tempPrefix+Integer.toString(fileIndex)+ ".txt");
			PrintWriter pw = new PrintWriter(fw);
			
			for(int i = 0; i < M; i++) {
				if(buffer[i] != Integer.MAX_VALUE) {
					pw.println(buffer[i]);
				}
			}
			fw.close();
			pw.close();
		}
		
		br.close();
		fr.close();
		
		//read the temp files and write it to the output file
		BufferedReader[] brArr = new BufferedReader[slices];
		for(int fileIndex =0; fileIndex < slices; fileIndex++) {
			brArr[fileIndex] = new BufferedReader(new FileReader(tempPrefix+Integer.toString(fileIndex)+ ".txt"));
		}
		
		Comparator<Node> comp = new Comparator<Node>() {
			public int compare(Node n1, Node n2) {
				return n1.elem-n2.elem;
			}
		};
		PriorityQueue<Node> minHeap = new PriorityQueue<Node>(comp);
		
		for(int fileIndex =0; fileIndex < slices; fileIndex++) {
			minHeap.add(new Node(Integer.parseInt(brArr[fileIndex].readLine()), fileIndex));
		} 
		
		PrintWriter pr = new PrintWriter(new FileWriter("output.txt"));
		while(!minHeap.isEmpty()) {
			Node node = minHeap.poll();
			pr.println(node.elem);
			String elem = brArr[node.index].readLine();
			if(elem != null) {
				minHeap.add(new Node(Integer.parseInt(elem), node.index));
			}
		}
		
		pr.close();
		for(int fileIndex =0; fileIndex < slices; fileIndex++) {
			brArr[fileIndex].close();
		}
		
		//delete all temp files
		for(int fileIndex =0; fileIndex < slices; fileIndex++) {
			Files.deleteIfExists(Paths.get(tempPrefix+Integer.toString(fileIndex)+ ".txt"));
		}
		            
	}
	public static String generateRandomFile(int N) throws IOException, FileNotFoundException  {
			String fileName = "input.txt";
			FileWriter fw = new FileWriter(fileName);
			PrintWriter pw = new PrintWriter(fw);
			
			Random rand = new Random();
	
			for(int i = 0; i < N; i++) {
				pw.println(rand.nextInt(101));
			}
			pw.close();
			fw.close();
			
			return fileName;
	}
	
	public static void main(String[] args) throws IOException, FileNotFoundException  {
		String fileName = generateRandomFile(100);
		externalSorting(fileName, 100);
	}
}