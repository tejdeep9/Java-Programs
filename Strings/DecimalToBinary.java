/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{	
	public static String convertToBinaryBitManip(int num){
		StringBuilder sbr = new StringBuilder();
		
		while(num != 0){
			int shifted = num & 1;
			char c = shifted == 0? '0' : '1';
			sbr.insert(0,c);
			num = num >> 1;
		}
		return sbr.toString();
	}
	
	public static String convertToBinaryIter(int num){
		StringBuilder sbr = new StringBuilder();
		
		while(num != 0){
			char c = num%2 == 0? '0' : '1';
			sbr.insert(0,c);
			num = num/2;
		}
		
		return sbr.toString();
	}
	
	public static StringBuilder convertToBinaryRecur(int num){
		StringBuilder sbr = new StringBuilder();
		if(num == 0)
			return sbr;	
		char c = num%2 == 0? '0' : '1';
		sbr = convertToBinaryRecur(num/2);
		sbr.append(c);
		return sbr;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		int num = 13;
		System.out.println(convertToBinaryRecur(13).toString());
	}
}