/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;


/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{	
	public static int minimumArraySumOfN2(int[] arr) {
		if(arr == null || arr.length == 0)
			return 0;
		if(arr.length == 1)
			return arr[0];
		int sum = arr[0];	
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] == arr[i-1]) {
				for(int j = i; j < arr.length; j++) {
					if(arr[j] <= arr[j-1]){
						arr[j] = arr[j-1] +1;
					}
				}
			}
			sum = sum + arr[i];
		}
		
		System.out.println(Arrays.toString(arr));
		return sum;
	}
	
	public static int minimumArraySumOfN(int[] arr) {
		
		if(arr == null || arr.length == 0)
			return 0;
		if(arr.length == 1)
			return arr[0];
              
			
		Arrays.sort(arr);
		
		int sum  = arr[0];
		int prev = arr[0]; 
		
		for(int i = 1; i < arr.length; i++)
		{	
			if(arr[i] <= arr[i-1]) {
				arr[i] = arr[i-1] + 1;
			} 
				
			sum = sum + arr[i];
		}
		
		System.out.println(Arrays.toString(arr));
		return sum;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		//int[] arr = { 5, 2, 6, 2, 3 } ;
		int[] arr = { 1, 3, 3, 3, 3, 3, 3, 3, 4, 4, 5, 6 };
		System.out.println(minimumArraySumOfN2(arr));
		System.out.println(minimumArraySumOfN(arr));
	}
}