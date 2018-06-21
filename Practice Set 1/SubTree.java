/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}
class Ideone
{
	public static boolean areEqual(Node root1, Node root2) {
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
				return false;
			
		if(root1.data == root2.data && areEqual(root1.left, root2.left) && areEqual(root1.right, root2.right))
			return true;
		
		return false;
	}
	
	public static boolean isSubTree(Node root1, Node root2) {
		if(root1 == null)
			return true;
		if(root2 == null)
			return false;
		
		if(areEqual(root1, root2))
			return true;
		
		if(isSubTree(root1.left, root2) || isSubTree(root1.right, root2))
			return true;
		
		return false;
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		Node root  = new Node(3);
		root.right = new Node(5);
		root.left = new Node(4);
		root.left.right = new Node(2);
		root.left.right = new Node(1);
		
		Node root1 = new Node(4);
		root1.right = new Node(2);
		root1.left = new Node(3);
		
		System.out.println(isSubTree(root, root1));
	}
}