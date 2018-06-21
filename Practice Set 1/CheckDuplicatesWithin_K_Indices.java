/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{	public static boolean checkDuplicatesWithinDistanceK(List<Integer> arr, int k) {
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i = 0; i < arr.size(); i++) {
			if(set.contains(arr.get(i))) {
				return true;
			}
			set.add(arr.get(i));
			if(i >= k) {
			    set.remove(arr.get(i-k));	
			}
		}
		return false;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Integer[] arr = {1, 2, 3, 1, 4, 5};
		System.out.println(checkDuplicatesWithinDistanceK(Arrays.asList(arr),3));
	}
}