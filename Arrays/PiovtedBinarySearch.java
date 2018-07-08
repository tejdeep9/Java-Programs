import java.util.*;
import java.lang.*;
import java.io.*;


class Ideone
{
	public static int findPivot(int[] arr, int start, int end) {
		if(start < end) {
			int mid = (start + end)/2;

			if(mid > start && arr[mid-1] > arr[mid])
				return mid;
			if(mid < end && arr[mid] > arr[mid+1])
				return mid;
			if(arr[start] >= arr[mid])
				return findPivot(arr, start, mid-1);
			else
				return findPivot(arr, mid+1, end);

		}

		return -1;
	}

	public static int binarySearch(int[] arr, int start, int end, int key) {
		while(start < end) {
			int mid = (start+end)/2;
			if(arr[mid] == key) {
				return mid;
			} else if(arr[mid] > key) {
				end = mid-1;
			} else {
				start = mid+1;
			}
		}

		if(arr[start] == key) {
			return start;
		} else {
			return -1;
		}
	}
	public static int pivotedBinarySearch(int[] arr, int key) {
		int index = findPivot(arr, 0, arr.length-1);

		if(index == -1)
			return binarySearch(arr,0,arr.length-1, key);

		if(arr[index] == key)
			return index;
		if(arr[0] >= key) 
			return binarySearch(arr, index+1, arr.length-1, key);
		else
			return binarySearch(arr, 0, index-1, key);
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		int key = 3;
		System.out.println(pivotedBinarySearch(arr, key));
	}
}