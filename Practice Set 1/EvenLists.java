/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{	
	public static void evenLists(List<Integer> list) {
		
		int n = list.size();
		
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		
		int sum1 = 0;
		int sum2 = 0;
		
		Collections.sort(list, Collections.reverseOrder());
		
		for(int i = 0; i < list.size(); i++) {
			
			if( sum1 < sum2 && l1.size() < n/2) {
				l1.add(list.get(i));
				sum1+=list.get(i);
			} else {
				l2.add(list.get(i));
				sum2+=list.get(i);
			}
		}
		
		for(Integer x: l1) {
			System.out.println(x);
		}
		
		for(Integer y: l2) {
			System.out.println(y);
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Integer[] arr = { 50, 10, 200, 150, 900, 250, 40, 50, 950, 5, 90, 80, 60, 600 };
		evenLists(Arrays.asList(arr));
	}
}