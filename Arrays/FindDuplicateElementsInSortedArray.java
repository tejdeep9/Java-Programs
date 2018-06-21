/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static int getCount(int[] arr, int mid, int start, int end, int target) {
		int left = mid-1;
		int right = mid+1;
		int count = 0;
		while( left >= start && arr[left] == target) {
		 	count++;
			left--;
		}
		
		while( right <= end && arr[right] == target) {
		 	count++;
			right++;
		}
		
		return count;
	}
	
	public static int binarySearch(int[] arr, int target) {
	 	int start = 0;
		int end = arr.length-1;
		
		int count = 0;
		while( start < end) {
			int mid =(start+end)/2;
			
			if(arr[mid] == target) {
				count++;
				count+=getCount(arr, mid, start, end, target);
				return count;
			} else if (arr[mid] < target) {
				start = mid+1;
			} else {
				end = mid-1; 
			}
			
		}
		
		if(arr[start] == target) {
			count++;
		}
		
		return count;
	 }

	public static void main (String[] args) throws java.lang.Exception
	{
		int[] arr = {1, 2, 2, 2, 2, 2, 3, 5, 5, 5 };
		System.out.println(binarySearch(arr, 6));
		System.out.println(binarySearch(arr, 3));
		System.out.println(binarySearch(arr, 2));
		System.out.println(binarySearch(arr, 5));
	}
}