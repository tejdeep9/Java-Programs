/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void printUnion(List<Integer> l1, List<Integer> l2){
		int m = l1.size();
		int n = l2.size();
		
		if(m > n){
			printUnion(l2, l1);
			return;
		}
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.addAll(l1);
		
		Collections.sort(l1);
		for(Integer elem: l2){
			if(Collections.binarySearch(l1, elem) < 0){
				result.add(elem);
			}
		}
		
		System.out.println(result);
	}
	
	public static void printIntersection(List<Integer> l1, List<Integer> l2){
		int m = l1.size();
		int n = l2.size();
		
		if(m > n){
			printIntersection(l2, l1);
			return;
		}
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		Collections.sort(l1);
		for(Integer elem: l2){
			if(Collections.binarySearch(l1, elem) >= 0){
				result.add(elem);
			}
		}
		
		System.out.println(result);
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Integer[] l1 = new Integer[]{1, 5, 3, 7, 9, 6};
		Integer[] l2 = new Integer[]{3, 20, 15, 7};
		
		printUnion(Arrays.asList(l1), Arrays.asList(l2));
		printIntersection(Arrays.asList(l1), Arrays.asList(l2));
	}
}