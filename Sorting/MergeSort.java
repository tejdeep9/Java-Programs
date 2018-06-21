/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{	
	public static void merge(int[] arr, int start, int mid, int end) {
		int n1 = mid-start+1;
		int n2 = end-mid;
		
		int[] a1 = new int[n1];
		int[] a2 = new int[n2];
		
		for(int i = 0; i < n1; i++)
			a1[i] = arr[i+start];
		
		for(int i = 0; i < n2; i++) 
			a2[i] = arr[i+mid+1];
			
		int i = 0;
		int j = 0;

		int k = start;
		
		while( i < n1 && j < n2) {
			
			if(a1[i] <= a2[j]) {
				arr[k++] = a1[i++];
			} else {
				arr[k++] = a2[j++];
			}
		}
		
		while(i < n1) {
			arr[k++] = a1[i++];
		}
		
		while(j < n2) {
			arr[k++] = a2[j++];
		}
	}
	public static void mergeSort(int[] arr, int start, int end) {
		if(start < end) {
			int mid = (start + end)/2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, start, mid, end);
		}
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		int arr[] = {12, 11, 13, 5, 6, 7};
		mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));

	}
}