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
	
	public Node root;
	
	BinarySearchTree() {
		root = null;
	}
}
class Ideone
{	
	public static boolean isSymmetric(Node root) {
		return isMirror(root, root);
	}
	
	public static boolean isMirror(Node root1, Node root2) {
		
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		
		if((root1.data == root2.data) && isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left))
			return true;
		else
			return false;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.root = new Node(6);
		bst.root.left = new Node(5);
		bst.root.right = new Node(5);
		bst.root.left.left = new Node(6);
		bst.root.left.right = new Node(7);
		bst.root.right.left = new Node(7);
		bst.root.right.right = new Node(6);
		
		System.out.println(isSymmetric(bst.root));
	}
}