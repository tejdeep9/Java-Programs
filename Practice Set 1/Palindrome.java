/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static boolean checkPalindrome(char[] str, int start, int end) {
		if(str == null)
			return false;
		
		for(int i = start;  i < start+(end-start+1)/2; i++){
			if(str[i] != str[end-(i-start)])
				return false;
		}
		
		return true;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		String str = "ananana";
		System.out.println(checkPalindrome(str.toCharArray(), 0, 4));
	}
}