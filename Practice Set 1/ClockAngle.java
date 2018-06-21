/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static double clockAngle(int h, int m) {
		if(h > 12 || h < 0 || m > 60 || m < 0)
			return Double.MAX_VALUE;
		
		if(h == 12)
			h = 0;
		if(m == 60)
			m = 0;
		double minuteAngle = 6 * m; 
		double hourAngle = 30  *h + 0.5 * m;
		
		double difference = Math.abs(hourAngle - minuteAngle);
		
		double angle = Math.min(360 - difference, difference);
		return angle;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		System.out.println(clockAngle(9, 60));
		System.out.println(clockAngle(3, 30));
		System.out.println(clockAngle(-9, 60));
	}
}