import java.lang.Math;
import java.util.Stack;
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


public class Main {
    public static void preorderTraversal(Node root) {
        if(root == null)
            return;
        
        Stack<Node> stack = new Stack<Node>();
        stack.add(root);
        
        while(!stack.empty()) {
            Node current = stack.pop();
            System.out.print(current.data+", ");
            if(current.right != null)
                stack.add(current.right);
            if(current.left != null)
                stack.add(current.left);
        }
        
    }  
    
    public static void inorderTraversal(Node root) {
        if(root == null)
                return;
        Stack<Node> stack = new Stack<Node>();
        
        Node current = root;
        while(!stack.empty() || current != null) {
            if(current != null) {
                stack.add(current);
                current = current.left;
            } else {
                current = stack.pop();
                System.out.print(current.data+", ");
                current = current.right;
            }
        }
    }
    
    public static void postorderTraversal(Node root) {
        if(root == null)
            return;
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        
        s1.add(root);
        
        while(!s1.empty()) {
            Node current = s1.pop();
            if(current.left != null)
                s1.add(current.left);
            if(current.right != null)
                s1.add(current.right);
            s2.add(current);
        }
        
        while(!s2.empty()) {
            Node current = s2.pop();
            System.out.print(current.data+", ");
        }
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.left.left = new Node(0);
        root.left.right = new Node(3);
        root.left.left.right = new Node(1);
        
        root.right = new Node(6);
        root.right.right = new Node(9);
        root.right.right.left = new Node(7);
        root.right.right.left.right = new Node(8);
        
        inorderTraversal(root);
        System.out.println();
        preorderTraversal(root);
        System.out.println();
        postorderTraversal(root);
        
    }
}