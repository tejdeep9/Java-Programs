/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static int maxSumSubArray(int[] arr) {
		if(arr == null || arr.length == 0)
			return 0;
		
		if(arr.length == 1) 
			return arr[0];
		
		
		int[] sumArray = new int[arr.length];
		
		sumArray[0] = arr[0];
		int maxSum = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			
			if(sumArray[i-1] < 0) {
				sumArray[i] = arr[i];
			} else {
				sumArray[i] = sumArray[i-1]+arr[i];
			}
			maxSum = Math.max(maxSum, sumArray[i]);
		}
		
		return maxSum;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] arr = {3, -2, 5, -1};
		System.out.println(maxSumSubArray(arr));
	}
}

/*
   array    prevSum < 0 ? currentElem : (currentElem + prevSum)
3              3       	3
3 -2           3-2     	1
3 -2 -3		   1-3 	   	-2
3 -2 -3 5      5       	5
3 -2 -3 5 -1   5-1     	4	  
*/
 