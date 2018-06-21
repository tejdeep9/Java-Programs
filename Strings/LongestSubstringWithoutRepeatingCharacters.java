/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static String longestSubstrWithoutRepeatingChars(String str){
		if(str == null)
			return null;
			
		StringBuilder sbr = new StringBuilder();
		String res = "";
		for(int i = 0; i < str.length(); i++){
			int pos = sbr.indexOf(Character.toString(str.charAt(i)));
			if(pos == -1){
				sbr.append(str.charAt(i));
			} else{
				if(res.length() < sbr.length())
					res = sbr.toString();
				sbr.delete(0, pos+1);
				sbr.append(str.charAt(i));
			}	
		}
		
		if(res.length() < sbr.length())
			res = sbr.toString();
		
		return res;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println(longestSubstrWithoutRepeatingChars("abcdad"));
	}
}