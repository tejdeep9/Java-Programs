/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;


class Ideone
{	
	public static int[] mergeSortedArrays(int[] l1, int[] l2) {
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
		int[] arr1 = {1, 3, 5, 7, 9, 10};
		int[] arr2 = {2, 4, 6, 8};
            
        System.out.println(Arrays.toString(mergeSortedArrays(arr1, arr2)));
	}
}