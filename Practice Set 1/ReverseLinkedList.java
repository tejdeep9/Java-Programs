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
	public static Node reverseLinkedListIter(Node l) {
		if(l == null)
			return null;
		Node current = l, prev = null, next = null;
		
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		return prev;
	}
	
	public static Node reverseLinkedListRecur(Node l){
		return reverseLinkedListRecur(l, null); 
	}
	
	public static Node reverseLinkedListRecur(Node l, Node head) {
		if(l.next == null) {
			head = l;
			return head;
		}
			
		head = reverseLinkedListRecur(l.next, head);
		Node temp = l.next;
		temp.next = l;
		l.next = null;
		return head;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		
		Node result = reverseLinkedListRecur(a);
		
		while(result != null) {
			System.out.println(result.data);
			result = result.next;
		}
	}
}