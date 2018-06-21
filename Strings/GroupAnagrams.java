/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{	

	public static void groupAnagrams(List<String> anagrams){
		
		HashMap<String, List<String>> anaGroups = new HashMap<String, List<String>>();
		
		for(String word: anagrams){
			
			char[] keyArr = new char[word.length()];
			for(int i = 0; i < word.length(); i++){
				keyArr[i] = Character.toLowerCase(word.charAt(i));
			}
			Arrays.sort(keyArr);
			
			String key = new String(keyArr);
		
			if(anaGroups.containsKey(key)){
				anaGroups.get(key).add(word);
			}
			else {
				anaGroups.put(key, new ArrayList<String>());
				anaGroups.get(key).add(word);
			}
		}
	
		Set< Map.Entry< String, List<String>>> st = anaGroups.entrySet();   
		for( Map.Entry<String, List<String>> x: st){
			System.out.println(x.getValue());
		}

		
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		String[] arr = new String[]{"NonsenSe", "SenseNon", "geeks", "Sgeek"};
		groupAnagrams(Arrays.asList(arr));
	}
}