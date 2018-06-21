/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static double medianValue(List<Integer> arr) {
		if(arr == null || arr.size() == 0)
			return 0;
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		for(Integer elem: arr) {
			maxHeap.add(elem);
			
			if(minHeap.size() == maxHeap.size()) {
				
				if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
					Integer num1 = maxHeap.poll();
					Integer num2 = minHeap.poll();
					
					maxHeap.add(num2);
					minHeap.add(num1);
				}
			} else {
					Integer num = maxHeap.poll();
					minHeap.add(num);
			}
				
		}
		
		if( minHeap.size() == maxHeap.size())
			return (double)(minHeap.peek()+maxHeap.peek())/2;
		else
			return minHeap.peek();

	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Integer[] arr = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
		System.out.println(medianValue(Arrays.asList(arr)));
	}
}