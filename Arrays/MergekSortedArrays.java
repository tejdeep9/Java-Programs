// "static void main" must be defined in a public class.

import java.util.Arrays;
import java.util.Queue;
import java.util.List;

class ArrayNode {
	int[] arr;
	int index;
	
	ArrayNode(int[] arr) {
		this.arr = arr;
		this.index = 0;
	}
}

public class Main {
    	public static int[] mergeKSortedArrays(int[][] arr) {
		if(arr == null || arr.length == 0)
				return null;
		
		int k = arr.length;
		
		Comparator comp = new Comparator<ArrayNode>() {
			public int compare(ArrayNode a1, ArrayNode a2) {
				return a1.arr[a1.index]-a2.arr[a2.index];
			}
		};
		PriorityQueue<ArrayNode> minHeap = new PriorityQueue<ArrayNode>(comp);
			
		for(int i =0 ; i < k; i++) {
            if(arr[i] != null && arr[i].length != 0)
			    minHeap.add(new ArrayNode(arr[i]));
		}
            
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(!minHeap.isEmpty()) {
			ArrayNode node = minHeap.poll();
			result.add(node.arr[node.index]);
			node.index++;
			if(node.index < node.arr.length) {
				minHeap.add(node);
			}
		}
        
        int[] resArr = new int[result.size()];
        for(int i = 0; i < result.size(); i++)
            resArr[i] = result.get(i);
		return resArr;
	}

    public static void main(String[] args) {
        int arr[][] = {{},
                       {2, 4, 6, 8},
                       {0, 9, 10, 11, 30, 40},
                        null};
        
       System.out.println(Arrays.toString(mergeKSortedArrays(arr)));
    }
}