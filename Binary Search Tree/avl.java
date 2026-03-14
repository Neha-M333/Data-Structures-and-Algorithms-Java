public class avl {
    static class Node{
        int data;
        int height;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.height = 1;
        }
    }

    public static Node root;

    // (1) Insert Node
    // (2) Update the height
    // (2) After inserting each node check the binary factor
    // (3) After finding the binary factor chech the "Cases: LL/LR/RR/RL"
    // (4) Then rotate the tree accoring to the Case
    
    // (1)
    public static Node insert(Node root, int key){
        // If null create a new node
        if(root == null){
            return new Node(key);
        }

        if(key < root.data){
            root.left = insert(root.left, key);
        }else if(key > root.data){
            root.right = insert(root.right, key);
        }else{
            return root; // duplicate keys not allowed
        }

        // (2) Update date height 
        root.height = 1+ Math.max(height(root.left), height(root.right));

        // (3) 
        int bf = getBalance(root);

        // (4)
        // (i) Case 1: Left Left rotation
        if(bf > 1 && key < root.left.data){
            return rightRotation(root);
        }

        // (ii) Case 2: Right Right rotation
        if(bf < -1 && key > root.right.data){
            return leftRotation(root);
        }

        // (iii) Case 3: Left Right rotation
        if(bf > 1 && key > root.left.data){
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }

        // (iv) Case 4: Right Left rotation
        if(bf < -1 && key < root.right.data){
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }

        return root; // Return if AVL is balanced
    }

    // Updating the height
    public static int height(Node root){
        if(root == null){
            return 0;
        }

        return root.height;
    }

    // Calculation binary factor of Left Subtree and Right Subtree
    public static int getBalance(Node root){
        if(root == null){
            return 0;
        }

        return height(root.left) - height(root.right);
    }

    // Left Rotation
    public static Node leftRotation(Node x){
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update the weights
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        // return new root
        return y;
    }

    // Right Rotation
    public static Node rightRotation(Node y){
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update the weights
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        // return new root
        return x;
    }

    // To print the Nodes I will use preorder traversal
    public static void preorder(Node root){
        if(root == null){
            return;
        }

        System.out.print(root.data+ " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args){
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        preorder(root);
        System.out.println();
    }
}
