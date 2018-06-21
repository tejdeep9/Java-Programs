import java.util.List;
import java.util.Arrays;
import java.lang.Math;
import java.io.*;


class Solution
{
	public static int dfs(int[][] map, int i, int j, int token) {
		int n = map.length;
		
		if( i < n && i >=0 && j < n && j >= 0 && map[i][j] == token) {
			map[i][j] = 0;
			return 1+dfs(map,i+1, j, token)+dfs(map,i-1, j, token)+dfs(map,i, j+1, token)+dfs(map,i, j-1, token);
		}
		
		return 0; 
	}
	
	public static int largestCountrySize(int[][] map) {
		if(map == null || map.length == 0)
				return 0;
		int n = map.length;
		List<Integer> itemList = Arrays.asList(1, 2, 3, 4);
	
		int maxSize = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(itemList.contains(map[i][j])) {
					maxSize = Math.max(maxSize, dfs(map, i, j, map[i][j]));
				}
				
			}
		}
		
		return maxSize;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		int[][] map ={{1, 1, 2, 2}, {3, 2, 4, 2}, {3, 3, 4, 2}, {1, 1, 4, 2}};
		System.out.println(largestCountrySize(map));
	}
}