
import java.util.ArrayList;

public class BinaryTree2 {
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

    static class BinaryTree{
        // Kth level of a tree
        public static void kLevel(Node root, int k, int level){
            if(root == null){
                return;
            }

            if(level == k){
                System.out.print(root.data+ " ");
                return;
            }
            

            kLevel(root.left, k, level+1);
            kLevel(root.right, k, level+1);
        }

        // Approch 1: Finding the Lowest common ancester
        public static Node lca(Node root, int n1, int n2){
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            getPath(root, n1, path1);
            getPath(root, n2, path2);

            // last common ancester
            int i=0;
            for(; i<path1.size() && i<path2.size(); i++){
                if(path1.get(i) != path2.get(i)){
                    break;
                }
            }
            // last equal node i-1
            Node lca = path1.get(i-1);
            return lca;
        }

        public static boolean getPath(Node root, int n, ArrayList<Node> path){
            if(root == null){
                return false;
            }

            path.add(root);
            if(root.data == n){
                return true;
            }

            boolean foundLeft = getPath(root.left, n, path);
            boolean fountRight = getPath(root.right, n, path);

            if(foundLeft || fountRight){
                return true;
            }

            path.remove(path.size() - 1);
            return false;
        }

        // Approch 2: Optomized code to find the lowest common ancestor
        public static Node lca2(Node root, int n1, int n2){
            if(root == null|| root.data == n1|| root.data == n2){
                return root;
            }

            Node leftLca = lca2(root.left, n1, n2);
            Node rightLca = lca2(root.right, n1, n2);

            //if left returns a value but right returns null -> the return left and visa-versa
            if(rightLca == null){
                return leftLca;
            }

            if(leftLca == null){
                return rightLca;
            }

            // if leftFount && rightFount != null -> return root
            return root;
        }

        // Minimum distance between nodes
        public static int minDistance(Node root, int n1, int n2){
            // Finding the lowest common ancestor
            Node lca = lca2(root, n1, n2);

            // Finding the lca distance 1 and lca distence 2
            int dist1 = lcaDistance(lca, n1);
            int dist2 = lcaDistance(lca, n2);

            // Finding minimum distance
            return dist1 + dist2;
        }

        public static int lcaDistance(Node root, int n){
            if(root == null){
                return -1;
            }

            if(root.data == n){
                return 0;
            }
            
            int leftDistance = lcaDistance(root.left, n);
            int rightDistance = lcaDistance(root.right, n);

            if(leftDistance == -1 && rightDistance == -1){
                return -1;
            }

            if(rightDistance == -1){
                return leftDistance+1;
            }else{
                return rightDistance+1;
            }
        }

        // Finding the Kth ancestor of node
        public static int kthAncestor(Node root, int n, int k){
            if(root == null){
                return -1;
            }

            if(root.data == n){
                return 0;
            }

            int leftDistance = kthAncestor(root.left, n, k);
            int rightDistance = kthAncestor(root.right, n, k);

            if(leftDistance == -1 && rightDistance == -1){
                return -1;
            }

            int max = Math.max(leftDistance, rightDistance);
            if((max+1) == k){
                System.out.println("Kth ancestor od the tree: "+ root.data);
            }
            
            return max+1;
        }

        // Transform to sum tree
        public static int transform(Node root){
            if(root == null){
                return 0;
            }

            int leftChild = transform(root.left);
            int rightChild = transform(root.right);

            int data = root.data;

            int leftSum = root.left == null ? 0 : root.left.data;
            int rightSum = root.right == null ? 0 : root.right.data;

            root.data = leftChild + leftSum + rightChild + rightSum;

            return data;
        }

        // Printing the tree using preorder
        public static void print(Node root){
            if(root == null){
                return;
            }

            System.out.print(root.data+ " ");
            print(root.left);
            print(root.right);
        }
    }

    public static void main(String[] args) {
        // Kth level
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        BinaryTree.kLevel(root, 4, 5);
        System.out.println();

        // Approch 1: Lowest common ancestor
        System.out.println("Lowest common ancestor: "+ BinaryTree.lca(root, 4, 5).data);

        // Apprroch 2: Optimized code for lowest common ancestor
        System.out.println("Lowest common ancestor: "+ BinaryTree.lca2(root, 6, 7).data);

        // Min distance between nodes
        System.out.println("Min distance between nodes: "+ BinaryTree.minDistance(root, 4, 7));

        // Finding the Kth ancestor of node
        BinaryTree.kthAncestor(root, 5, 2);

        // Transform to sum tree
        BinaryTree.transform(root);
        BinaryTree.print(root);

        System.out.println();
    }
}