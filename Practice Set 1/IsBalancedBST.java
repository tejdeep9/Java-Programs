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

class Height {
	int height;
}

class Ideone
{	
	public static int height(TreeNode root) {
		if(root == null)
			return -1;
		return Math.max(height(root.left), height(root.right))+1;
	}
	
	public static boolean isBalancedBSTOofN2(TreeNode root) {
		if(root == null)
			return true;
		
		int lh = height(root.left);
		int rh = height(root.right);
		
		if(Math.abs(lh-rh) <= 1 && isBalancedBSTOofN2(root.left) && isBalancedBSTOofN2(root.right)) 
			return true;
		
		return false;
	}
	
	public static boolean isBalancedBSTOofN(TreeNode root) {
		return isBalancedBSTOofN(root, new Height());
	}
	
	public static boolean isBalancedBSTOofN(TreeNode root, Height h) {
		if(root == null) {
			h.height = -1;
			return true;
		}
		
		Height lh = new Height();
		Height rh = new Height();
		
		boolean l = isBalancedBSTOofN(root.left, lh);
		boolean r = isBalancedBSTOofN(root.right, rh);
		
		int lheight = lh.height;
		int rheight = rh.height;
		
		h.height = Math.max(lheight, rheight)+1;
		
		if(Math.abs(lheight-rheight) > 1)
			return false;
		else 
			return l && r;
	}

	public static void main(String[] args) throws java.lang.Exception
	{
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.insert(6);
		bst.insert(5);
		//bst.insert(3);
		bst.insert(10);
		bst.insert(8);
		bst.insert(9);
		bst.insert(7);
		bst.insert(11);
		
		System.out.println(isBalancedBSTOofN(bst.root));
		System.out.println(isBalancedBSTOofN2(bst.root));
	}
}