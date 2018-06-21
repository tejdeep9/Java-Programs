/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static int LongestCommonSubstring(String str1, String str2) {
		if(str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0)
			return 0;
			
		int m = str1.length();
		int n = str2.length();
		
		int[][] dp = new int[m+1][n+1];
		
		for(int i = 0; i < m; i++) 
			dp[i][0] = 0;
		for(int j = 0; j < n; j++)
			dp[0][j] = 0;
		int maxLen = 0;
		int maxI = 0;
		int maxJ =0;
		for( int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1]+1;
					if(dp[i][j] > maxLen) {
						maxLen = dp[i][j];
						maxI = i;
						maxJ =j;
					}
				}	
			}
		}
		
		StringBuilder sbr = new StringBuilder();
		
		while(dp[maxI][maxJ] != 0) {
			sbr.insert(0,str1.charAt(maxI-1));
			maxI--;
			maxJ--;
		}
		System.out.println(sbr.toString());
		return maxLen;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		String str1 = "abcdaf";
		String str2 = "zbcdf";
		System.out.println(LongestCommonSubstring(str1, str2));
	}
}