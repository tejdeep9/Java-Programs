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
	public static Node getIntersectionNode(Node l1, Node l2) {
		if( l1 == null || l2 == null)
			return null;
		
		int size1 = 0;
		int size2 = 0;
		
		Node current1 = l1;
		Node current2 = l2;
		while(current1.next != null) {
			size1++;
			current1 = current1.next;
		}
		
		while(current2.next != null) {
			size2++;
			current2 = current2.next;
		}
		
		current1 = l1;
		current2 = l2;
		
		while(size1 > size2) {
			current1 = current1.next;
			size1--;
		}
		
		while(size2 > size1) {
			current2 = current2.next;
			size2--;
		}
		
		while (current1 != current2) {
			current1 = current1.next;
			current2 = current2.next;
		}
		
		return current1;
		
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		Node f = new Node(6);
		Node g = new Node(7);
		Node h = new Node(8);
		Node i = new Node(9);
		Node j = new Node(10);
		
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		i.next = j;
		j.next = e;
		e.next = g;
		g.next = f;
		
		Node result = getIntersectionNode(a,i);
		if(result != null) System.out.println(result.data);
	}
}