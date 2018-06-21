/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{	
	public static String longestPalindromicSubstring(String str){
		if(str == null)
			return null;
		
		boolean[][] mat = new boolean[str.length()][str.length()];
		
		//all string of single characters are palindrome
		for(int i = 0; i < str.length(); i++){
			mat[i][i] = true;
		}
		
		int maxLen = 1;
		int firstIndex = 0;
		int lastIndex = 0;
		
		//check the palindromes for the strings of length 2
		for(int i = 0; i < str.length()-1; i++){
			
			if(str.charAt(i) == str.charAt(i+1)){
				mat[i][i+1] = true;
				maxLen = 2;
				firstIndex = i;
				lastIndex = i+1;
			}
		}
		
		//check for the palindromes of the length more than 2
		for(int len = 3; len <= str.length(); len++)
		{
			for( int i = 0; i < str.length()-len; i++){
				int j = len+i-1;
				
				if((str.charAt(i) == str.charAt(j)) && mat[i+1][j-1]){
					mat[i][j] = true;
					maxLen = 3;
					firstIndex = i;
					lastIndex = j;
				}
				
			}
		}
		
		return str.substring(firstIndex,lastIndex+1);
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		String str  = "baanaas";
		String res = longestPalindromicSubstring(str);
		System.out.println(res);
	}
}