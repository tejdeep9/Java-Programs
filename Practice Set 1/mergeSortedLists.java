/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class ListNode {
	int data;
	ListNode next;
	
	ListNode(int data) {
		this.data = data;
		next = null;
	}
}

class Ideone
{	
	public static ListNode mergeSortedLists(ListNode l1, ListNode l2) {
		ListNode current1= l1;
		ListNode current2 = l2;
		
		ListNode dummyNode = new ListNode(0);
		ListNode headNode = dummyNode;
		while(current1 != null && current2 != null) {
			
			if(current1.data <= current2.data) {
				dummyNode.next = current1;
				current1 = current1.next;
			} else {
				dummyNode.next = current2;
				current2 = current2.next;
			} 
			dummyNode = dummyNode.next;
		}
		
		if(current1 != null)
			dummyNode.next = current1;
		if(current2 != null)
			dummyNode.next = current2;
		
		return headNode.next;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(3);
		l1.next.next = new ListNode(5);
		l1.next.next.next = new ListNode(7);
		
		ListNode l2 = new ListNode(2);
		l2.next = new ListNode(4);
		l2.next.next = new ListNode(6);
		l2.next.next.next = new ListNode(7);
		l2.next.next.next.next = new ListNode(8);
		
		ListNode result = mergeSortedLists(l1, l2);
		
		while(result != null) {
			System.out.println(result.data);
			result = result.next;
		}
 	}
}