/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void swap(int[] arr, int i, int j){
		int temp =arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static int partition(int[] arr, int start, int end) {
		int pivot = end;
		int index = start;
		
		for(int j = start; j < end; j++){
			if(arr[j] <= arr[pivot]) {
				swap(arr, index, j);
				index++;
			}
		}
		
		swap(arr, index, pivot);
		return index;
		
	}
	
	public static void quickSort(int[] arr, int start, int end) {
		if(start < end) {
			int pivot  = partition(arr, start, end);
			quickSort(arr, start, pivot-1);
			quickSort(arr, pivot+1, end);
		}
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] arr = {10, 80, 30, 90, 40, 50 ,70};
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}