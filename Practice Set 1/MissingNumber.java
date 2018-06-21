/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static int missingNumber(int[] arr) {
		if(arr == null)
			return 0;
		int n = arr.length;
		int totalSum = ((n+1)*(n+2))/2;
		int actualSum = 0;
		
		for(int i = 0; i < n; i++){
			actualSum += arr[i];
		}
		
		return (totalSum - actualSum);
	}
	
	public static int missingNumber2(int[] arr){
		if(arr == null)
			return 0;
		int n = arr.length;
		
		int x1 = 1;
		for(int i=2; i <= n+1; i++)
			x1^=i;
		
		int x2 = arr[0];
		for(int i = 1; i < n; i++)
			x2^=arr[i];
		return x1^x2;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 9};
		System.out.println(missingNumber2(arr));
	}
}