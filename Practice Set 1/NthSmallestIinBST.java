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
	
	public void inorder() {
		inorder(root);
	}
	
	private void inorder(Node root) {
		if(root == null)
			return;
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
	}

}

class Ideone
{
	public static int nthSmallestInBST(Node root, int n) {
		if(root == null || n <= 0){
				return 0;
		}
		
		Node current = root;
		Stack<Node> stack = new Stack<Node>();
		
		while(current != null || !stack.isEmpty()) {
			if(current != null){
				stack.push(current);
				current = current.left;
			} else {
				current = stack.pop();
				n--;
				if(n == 0)
					return current.data;
				current = current.right;
			}
		}
				
		return 0;		
		
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(6);
		bst.insert(5);
		bst.insert(3);
		bst.insert(10);
		bst.insert(8);
		bst.insert(9);
		bst.insert(7);
		bst.insert(11);
		
		bst.inorder();
		
		System.out.println(nthSmallestInBST(bst.root, 4));
	}
}