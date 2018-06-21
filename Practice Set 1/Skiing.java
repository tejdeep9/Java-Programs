/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static boolean solveMaze(int[][] maze, int i, int j, int m, int n) {
		if(i >=0 && i < m  && j >= 0 && j < n) {
			if(maze[i][j] == 0) {
				maze[i][j] = 1;
				if(i == m-1 && j == n-1)	
					return true;
					
				return (solveMaze(maze, i+1, j, m, n) || solveMaze(maze, i, j+1, m, n));
			}
		}
		
		return false;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		int[][] maze={{0,0,0,0,0,1,0,1},
			  {0,0,0,1,0,1,0,0},
			  {1,0,1,0,0,0,1,0},
			  {1,0,0,0,0,1,0,0},
			  {0,1,1,1,0,0,0,1},
			  {0,0,0,0,0,1,0,1},
			  {0,0,0,1,0,1,0,0},
			  {0,1,1,0,1,0,0,0}};
		System.out.println(solveMaze(maze,0,0, maze.length, maze[0].length));
	}
}