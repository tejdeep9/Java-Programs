/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void printUnion(List<Integer> l1, List<Integer> l2){
		
		int i = 0;
		int j = 0;
		int m = l1.size();
		int n = l2.size();
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		while( i < m && j < n) {
			
			if(l1.get(i) < l2.get(j)){
				result.add(l1.get(i++));
			} else if ( l1.get(i) > l2.get(j)){
				result.add(l2.get(j++));
			} else {
				result.add(l1.get(i++));
				j++;
			}
		}
		
		while (i < m){
			result.add(l1.get(i++));	
		}
		
		while(j < n){
			result.add(l2.get(j++));
		}
		
		System.out.println(result);
	}
	
	public static void printIntersection(List<Integer> l1, List<Integer> l2){
		
		int i = 0;
		int j = 0;
		int m = l1.size();
		int n = l2.size();
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		while( i < m && j < n) {
			
			if(l1.get(i) < l2.get(j)){
				i++;
			} else if ( l1.get(i) > l2.get(j)){
				j++;
			} else {
				result.add(l1.get(i++));
				j++;
			}
		}
			
		System.out.println(result);
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Integer[] l1 = new Integer[]{1, 3, 5, 6, 7, 9};
		Integer[] l2 = new Integer[]{3, 7, 15, 20};
		
		printUnion(Arrays.asList(l1), Arrays.asList(l2));
		printIntersection(Arrays.asList(l1), Arrays.asList(l2));
	}
}