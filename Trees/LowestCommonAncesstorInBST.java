// "static void main" must be defined in a public class.
import java.io.*;
import java.lang.Math;

class Node {
    int data;
    Node left;
    Node right;
    
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
    
    public void insert(int data) {
        root = insert(root, data);
    }
    
    private Node insert(Node root, int data) {
        if(root == null) {
            root = new Node(data);
            return root;
        }
        
        if(root.data < data) {
            root.right = insert(root.right, data);
        } else {
            root.left = insert(root.left, data);
        }
        
        return root;
    }
}

public class Main {
    
    public static Node LowestCommonAncesstorofBST(Node root, Node n1, Node n2) {
        if(root == null) {
            return root;
        }
        
        if(root.data >= Math.min(n1.data, n2.data) && root.data <= Math.max(n1.data, n2.data)) {
            return root;
        } else if(root.data < Math.min(n1.data, n2.data)) {
            return LowestCommonAncesstorofBST(root.right, n1, n2);
        } else {
            return LowestCommonAncesstorofBST(root.left, n1, n2);
        }
    }
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
		Node a = new Node(6);
		Node b = new Node(5);
		Node c= new Node(10);
		Node d = new Node(3);
		Node e = new Node(4);
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
        
        Node result = LowestCommonAncesstorofBST(bst.root, h, f);
        System.out.println(result.data);
    }
}