/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{	
	public static String removeArbitraryWhiteSpaces(String str){
		
		String temp = str;
		StringTokenizer tokens = new StringTokenizer(temp, " ");
		StringBuilder sbr = new StringBuilder();
		
		while(tokens.hasMoreTokens()){
			sbr.append(tokens.nextToken());
			sbr.append(" ");
		}
		return sbr.toString().trim();
	}
	
	public static String removeArbitraryWhiteSpacesBasic(String str){
		
		int spaceCount = 0;
		boolean wordStarted = false;
		StringBuilder sbr = new StringBuilder();
		
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) ==  ' '){
				spaceCount++;
			}else{
				if(spaceCount >= 1 && wordStarted){
					sbr.append(" ");
				}
				sbr.append(str.charAt(i));
				wordStarted = true;
				spaceCount = 0;
			}
		}
		
		return sbr.toString();
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		String str = "    The        sky     is    blue    ";
		System.out.println(removeArbitraryWhiteSpacesBasic(str));
	}
}