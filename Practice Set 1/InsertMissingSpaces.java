/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{	
	public static List<String> insertMissingSpaces(String str, Set<String> dict) {
		
		List<String> result = new ArrayList<String>();
		if(str == null || dict.isEmpty())
			return result;
		StringBuilder sbr = new StringBuilder();
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) != ' ') {
				sbr.append(str.charAt(i));
				
				if(dict.contains(sbr.toString())) {
					result.add(sbr.toString());
					sbr.delete(0, sbr.length());
				}
			}
		}
		if(sbr.length() != 0)
			result.add(sbr.toString());
		return result;
	}
	public static void main (String[] args) throws java.lang.Exception
	{	
		HashSet<String> set = new HashSet<String>();
		set.add("the");
		set.add("sky");
		set.add("is");
		set.add("blue");
		List<String> result = insertMissingSpaces("theskyisblue", set);
		
		for( int i  = 0; i < result.size(); i++) {
			
			if(i == result.size()-1) {
				System.out.print(result.get(i));
			} else {
				System.out.print(result.get(i)+" ");
			}
		}
	}
}