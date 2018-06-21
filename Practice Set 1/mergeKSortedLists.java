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
	
	public static ListNode mergeKSortedList(List<ListNode> lists){
		if(lists == null || lists.size() == 0)
			return null;
		
		if(lists.size() == 1)
			return lists.get(0);
			
		return partition(lists, 0, lists.size()-1);
	}
	
	public static ListNode partition(List<ListNode> lists, int start, int end) {
		if(start == end)
			return lists.get(start);
		
		int mid = (start + end)/2;
		ListNode l1 = partition(lists, start, mid);
		ListNode l2 = partition(lists, mid+1, end);
		return merge(l1, l2);
	}
	
	public static ListNode merge(ListNode l1, ListNode l2) {
		ListNode current1 = l1;
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
		// your code goes here
	}
}