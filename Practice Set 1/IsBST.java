/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}


class BinarySearchTree {
	
	public TreeNode root;
	
	BinarySearchTree() {
		root = null;
	}
	
	public void insert(int item) {
		root = insert(root, item);
	}
	
	private TreeNode insert(TreeNode root, int item) {
		if (root == null) {
			root = new TreeNode(item);
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

class Ideone
{	
	public static boolean isValidBST(TreeNode root) {
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean isValidBST(TreeNode root, int min, int max) {
		if(root == null)
			return true;
			
		if(root.data < max && root.data >= min && isValidBST(root.left, min, root.data) && isValidBST(root.right, root.data, max))
			return true;
		else
			return false;
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
		
		System.out.println(isValidBST(bst.root));
	}
}