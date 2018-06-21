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
	public static List<Integer> bstToArray(Node root) {
		
		Stack<Node> stack = new Stack<Node>();
		Node current = root;
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		while (current != null || !stack.empty()) {
			
			if(current == null) {
				result.add(stack.peek().data);
				current = stack.pop();
				current = current.right;
			} else {
				stack.push(current);
				current = current.left;
			}
		}
		
		return result;	
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
		
		List<Integer> result = bstToArray(bst.root);
		
		for (Integer elem: result) {
			System.out.println(elem);
		}

	}
}