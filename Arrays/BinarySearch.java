/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static int binarySearchIter(int[] arr, int start, int end, int target) {
		
		while(start < end) {
			int mid = (start + end)/2;
			if(arr[mid] == target)
				return mid;
			else if(arr[mid] > target)
				end = mid-1;
			else
				start = mid+1;
		}
		
		if(arr[start] == target)
			return start;
		else
			return -1;
	}
	
	public static int binarySearchRecur(int[] arr, int start, int end, int target) {
		if(start <= end) {
			int mid = (start+end)/2;
			
			if(arr[mid] == target) {
				return mid;
			} else if(arr[mid] > target) {
				return binarySearchRecur(arr, start, mid-1, target);
			} else {
				return binarySearchRecur(arr, mid+1, end, target);
			}
		} 
		return -1;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] arr = {10, 20, 30, 50, 70, 90, 110};
		
		System.out.println(binarySearchIter(arr, 0, arr.length-1, 70));
		System.out.println(binarySearchRecur(arr, 0, arr.length-1, 70));
		System.out.println(binarySearchIter(arr, 0, arr.length-1, 60));
		System.out.println(binarySearchRecur(arr, 0, arr.length-1, 60));
		System.out.println(binarySearchIter(arr, 0, arr.length-1, 30));
		System.out.println(binarySearchRecur(arr, 0, arr.length-1, 30));
	}
}