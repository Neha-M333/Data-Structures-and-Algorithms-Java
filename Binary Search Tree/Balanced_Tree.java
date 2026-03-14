public class Balanced_Tree {
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

    // Sorted array to balance binary search tree
    public static Node balancedTree(int[] arr, int start, int end){
        if(start > end){
            return null;
        }

        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);

        root.left = balancedTree(arr, start, mid-1);
        root.right = balancedTree(arr, mid+1, end);

        return root;
    }

    // Printing the balanced BST by using preorder
    public static void preorder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data+ " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args){

        // Using sorted array build a balanced BST
        int arr[] = {3, 5, 6, 8, 10, 11, 12};
        Node root = balancedTree(arr, 0, arr.length-1);
        preorder(root);
        System.out.println();
        //----------------------------------------------
    }
}
