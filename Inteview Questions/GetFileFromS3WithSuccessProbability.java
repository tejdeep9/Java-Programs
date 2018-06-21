

/*

Amazon S3 is storage for the Internet. It’s a Simple Storage Service that offers software developers a highly-scalable, reliable, and low-latency data storage infrastructure at very low costs. What’s your understanding of S3 has 99.99% availability and 99.999999999% durability?

we download a s3 file like this:
$ s3cmd get s3://datausers/my_username/test.txt

One common error we see in our production data pipeline is S3 SlowDown Error (Error code 503, server side error). It means “Reduce your request rate”. Write a sim function s3_get() which simulates downloading a file from s3 and returns its content as a string. It has 70% chance to return successfully and 30% chance to hit this S3 SlowDown Error.

*/


//0.7, 0.3 => 0 to 0.7 value i will return the content, 0.7 to 1 i will return failure.

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */


class ServerSideException extends Exception {
  
  public ServerSideException() {};
  
  public ServerSideException(String message) {
    super(message); 
  }
  
}  

class Solution {
  
  public static String s3_get() throws ServerSideException{
    double rand = Math.random();
    String content = "file contents";   

    if(rand >= 0.7 && rand < 1.0) 
    {
      throw new ServerSideException("Error code 503, server side error");
    }  
    
    return content;
  }
  
  public static void simulate() {
    int call = 10000;
    int total = call;
    int error = 0;
    while( call != 0) {
      try {
          String result = s3_get();
      } catch (ServerSideException ex){
        error++;
      }
      call--;
    }
    System.out.println("error frequency: " +(double) error/total);
  }
  
  public static void main(String[] args) {
      simulate();
  }
}