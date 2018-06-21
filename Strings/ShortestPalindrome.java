/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{	public static boolean isPalindrome(StringBuilder str){
		for(int i = 0; i < str.length()/2; i++){
			if(str.charAt(i) != str.charAt(str.length()-i-1))	
				return false;
		}
		return true;
	}
	
	public static String makeShortestPalinFromStart(String str){
		if(str  == null)
			return null;
		StringBuilder sbr = new StringBuilder(str);
		
		for(int i = 0; i < str.length(); i++){
			if(isPalindrome(sbr))
				return sbr.toString();
			sbr.insert(0, str.charAt(i));	
		}
		return sbr.toString();
	}
	
	public static String makeShortestPalinFromEnd(String str){
		if(str  == null)
			return null;
		StringBuilder sbr = new StringBuilder(str);
		
		for(int i = str.length()-1; i >= 0; i--){
			if(isPalindrome(sbr))
				return sbr.toString();
			sbr.append(str.charAt(i));	
		}
		return sbr.toString();
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		String str = "aaacecaa";
		System.out.println(makeShortestPalinFromStart(str));
		System.out.println(makeShortestPalinFromEnd(str));
		
	}
}