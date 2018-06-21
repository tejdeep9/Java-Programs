/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;


class Ideone
{	
	
	public static int[] mergeKSortedArrays(int[][] arr){
		if(arr == null || arr.length == 0)
			return null;
		
		if(arr.length == 1)
			return arr[0];
			
		return partition(arr, 0, arr.length-1);
	}
	
	public static int[] partition(int[][] arr, int start, int end) {
		if(start == end)
			return arr[start];
		
		int mid = (start + end)/2;
		int[] l1 = partition(arr, start, mid);
		int[] l2 = partition(arr, mid+1, end);
		return merge(l1, l2);
	}
	
	public static int[] merge(int[] l1, int[] l2) {
		int[] result = new int[l1.length + l2.length];
		
		int n1 = l1.length;
		int n2 = l2.length;
		
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < n1 && j < n2) {
			if(l1[i] <= l2[j]){
				result[k++] = l1[i++];
			} else{
				result[k++] = l2[j++];
			}
		}
		
		while(i < n1){
			result[k++] = l1[i++];
		}
		
		while(j < n2){
			result[k++] = l2[j++];
		}
		
		return result;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		int[][] arr = { {1, 3, 5, 7},
	            	    {2, 4, 6, 8},
	                    {0, 9, 10, 11}} ;
            
        System.out.println(Arrays.toString(mergeKSortedArrays(arr)));
	}
}