/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static boolean coprimes(int num1, int num2) {
			
			while(num2 != 0) {
				int temp = num2;
				num2 = num1%num2;
				num1 = temp;
			}
			
			return num1 == 1;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println(coprimes(21,29));
	}
}