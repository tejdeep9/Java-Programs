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

public class Main {
    public static int minBSTPathSum(Node root) {
        if(root == null)
                return Integer.MAX_VALUE;
        if(root.left == null && root.right == null) 
                return root.data;
        
        int leftSum = minBSTPathSum(root.left);
        int rightSum = minBSTPathSum(root.right);
        
        return root.data + Math.min(leftSum, rightSum);
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
        
        System.out.println(minBSTPathSum(root));
        
    }
}