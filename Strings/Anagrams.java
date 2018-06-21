/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;



/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static boolean anagrams(String s1, String s2){
		
		if(s1.length() != s2.length())
			return false;
		
		Character[] arr1 = new Character[s1.length()];
		Character[] arr2 = new Character[s2.length()];
		
		for(int i = 0; i < s1.length(); i++)
		{
			arr1[i] = s1.charAt(i);
			arr2[i] = s2.charAt(i);
		}
		
		Comparator comp = new Comparator<Character>() {
			public int compare(Character c1, Character c2){
				return Character.compare(Character.toLowerCase(c1),Character.toLowerCase(c2));
			}
		};

		
		Arrays.sort(arr1, comp);
		Arrays.sort(arr2, comp);
		
		for(int i=0; i < arr1.length; i++){
			if(Character.compare(Character.toLowerCase(arr1[i]),Character.toLowerCase(arr2[i])) != 0)
				return false;
		}
		
		return true;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		String s1 = "NonSense";
		String s2 = "SEnseNOn";
		
		if(anagrams(s1,s2))
			System.out.println("Anagrams");
		else
			System.out.println("Not Anagrams");
	}
}