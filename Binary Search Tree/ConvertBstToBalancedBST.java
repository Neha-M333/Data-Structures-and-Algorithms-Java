
import java.util.ArrayList;

public class ConvertBstToBalancedBST {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Buildind a balanced BST
    public static Node balancedBST(Node root){
        // Getting sorted array using inorder sorted array
        ArrayList<Integer> inorder = new ArrayList<>();
        inorder(root, inorder);

        // Building a sorted balanced ninary search tree
        root = sortedBts(0, inorder.size()-1, inorder);

        return root;
    }

    // Getting sorted array using inorder sorted array
    public static void inorder(Node root, ArrayList<Integer> inorder){
        if(root == null){
            return;
        }

        inorder(root.left, inorder);
        inorder.add(root.data);
        inorder(root.right, inorder);
    }

    // Building a sorted balanced ninary search tree
    public static Node sortedBts(int start, int end, ArrayList<Integer> inorder){
        if(start > end){
            return null;
        }

        int mid = (start + end) / 2;
        Node root = new Node(inorder.get(mid));

        root.left = sortedBts(start, mid-1, inorder);
        root.right = sortedBts(mid+1, end, inorder);

        return root;
    }

    // Printing the balance BST using preorder
    public static void preorder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data+ " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(8);

        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        root = balancedBST(root);
        preorder(root);
        System.out.println();
    }
}
