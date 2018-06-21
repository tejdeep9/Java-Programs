/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
	int data;
	Node left, right;
	
	Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

class BinarySearchTree {
	Node root;
	
	BinarySearchTree() {
		root = null;
	}
	
	public void insert(int item) {
		root = insert(root, item);
	}
	
	private Node insert(Node root, int item) {
		if (root == null) {
			root = new Node(item);
			return root;
		}
		
		if (item > root.data) {
			root.right = insert(root.right, item);
		} else {
			root.left = insert(root.left, item);
		}
		return root;
	}
}

class Solution
{
	public static Node lowestCommonAncestorInBT(Node root, Node elem1, Node elem2) {
		if(root == null)
			return null;
			
		if(root == elem1 || root == elem2)
			return root;
			
		if(root.left == null && root.right == null)
			return null;
		
		Node left = lowestCommonAncestorInBT(root.left, elem1, elem2);
		Node right = lowestCommonAncestorInBT(root.right, elem1, elem2);
		
		if(left != null && right != null)
			return root;
			
		return left != null ? left : right;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		BinarySearchTree bst = new BinarySearchTree();
		
				
		Node a = new Node(6);
		Node b = new Node(5);
		Node c= new Node(10);
		Node d = new Node(6);
		Node e = new Node(7);
		Node f = new Node(9);
		Node g = new Node(12);
		Node h = new Node(11);
		
		bst.root = a;
		bst.root.left = b;
		bst.root.right = c;
		bst.root.left.left = d;
		bst.root.left.right = e;
		bst.root.right.left = f;
		bst.root.right.right = g;
		bst.root.right.right.left = h;
		
		Node result = lowestCommonAncestorInBT(bst.root, f, h);
		System.out.println(result.data);
		Node result1 = lowestCommonAncestorInBT(bst.root, b, d);
		System.out.println(result1.data);
	}
}