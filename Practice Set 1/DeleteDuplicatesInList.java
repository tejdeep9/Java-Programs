/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
	int data;
	Node next;
	
	Node(int data) {
		this.data = data;
		next = null;
	}
}

class Ideone
{	
	public static Node deleteDuplicateNoBuffer(Node l) {
		Node current = l;
		
		if(current == null)
			return null;
		
		while(current != null) {
			Node runner = current.next;
			Node prev = current;
			
			while(runner != null) {
				if(runner.data == current.data){
					prev.next= runner.next;
					runner = runner.next;
					continue;
				}
				prev = runner;
				runner = runner.next;
			}
			
			current = current.next;
		}
		return l;
		
	}
	
	public static Node deleteDuplicateWithBuffer(Node l) {
		Node current = l;
		
		if(current == null)
			return null;
		Node prev = null;
		HashSet<Integer> set = new HashSet<Integer>();
		
		while(current != null) {
			if(set.contains(current.data)) {
				prev.next = current.next;
				current = current.next;
						
			} else {
				set.add(current.data);
				prev = current;
				current = current.next;
			}
		}
		return l;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(2);
		Node e = new Node(1);
		Node f = new Node(6);
		Node g = new Node(6);

		
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;

		
		Node result = deleteDuplicateWithBuffer(a);
		while(result != null) {
			System.out.println(result.data);
			result = result.next;
		}

	}
}