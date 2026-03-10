
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeB {
    
    // Creates nodes for binary tree
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;

        // Returns root
        public static Node binaryTree(int nodes[]){
            idx++;

            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = binaryTree(nodes);
            newNode.right = binaryTree(nodes);

            return newNode;
        }

        // Traversal -> preorder
        public static void preorder(Node root){
            if(root == null){
                return;
            }

            System.out.print(root.data+ " ");
            preorder(root.left);
            preorder(root.right);
        }

        // Traversal -> inorder
        public static void inorder(Node root){
            if(root == null){
                return;
            }

            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        // Traversal -> outorder
        public static void outorder(Node root){
            if(root == null){
                return;
            }

            outorder(root.left);
            outorder(root.right);
            System.out.print(root.data+ " ");
        }

        // Reaversal -> Level order
        public static void levelOrder(Node root){
            if(root == null){
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();

                if(currNode == null){
                    System.out.println();

                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+ " ");

                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }

        // Calculate the height of tree
        public static int height(Node root){
            if(root == null){
                return 0;
            }

            int lh = height(root.left);
            int rh = height(root.right);

            return Math.max(lh, rh) + 1;
        }

        // Counts the number of nodes in tree
        public static int count(Node root){
            if(root == null){
                return 0;
            }

            return count(root.left) + count(root.right) + 1;
        }

        // Sum of the nodes in tree
        public static int sum(Node root){
            if(root == null){
                return 0;
            }

            return sum(root.left) + sum(root.right) + root.data;
        }

        // Approch 1: Finding the diameter of the tree
        public static int diameter(Node root){
            if(root == null){
                return 0;
            }

            int leftDiam = diameter(root.left);
            int leftHeight = height(root.left);
            int rightDiam = diameter(root.right);
            int rightHeight = height(root.right);

            int selfDiam = leftHeight + rightHeight + 1;
            return Math.max(Math.max(leftDiam, rightDiam), selfDiam);
            
        }

        // Appeoch 2: Optimized way to find the diameter of the tree
        static class Info{
            int diam;
            int height;

            public Info(int diam, int height){
                this.diam = diam;
                this.height = height;
            }
        }

        public static Info optimizedDiameter(Node root){
            if(root == null){
                return new Info(0, 0);
            }

            Info leftInfo = optimizedDiameter(root.left);
            Info rightInfo = optimizedDiameter(root.right);
            
            int height = Math.max(leftInfo.height, rightInfo.height) + 1;
            int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.height + rightInfo.height + 1);

            return new Info(diam, height);
        }

        // Checking whether a subtree is identical to another tree
        public static boolean isSubtree(Node root, Node subRoot){
            if(root == null){
                return false;
            }

            if(isIdentical(root, subRoot)){
                return true;
            }

            // boolean leftAns = isSubtree(root.left, subRoot);
            // boolean rightAns = isSubtree(root.right, subRoot);

            // return leftAns || rightAns;
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        public static boolean isIdentical(Node node, Node subNode){
            if(node == null && subNode == null){
                return true;
            }
            
            // Case 1:
            if(node == null || subNode == null || node.data != subNode.data){
                return false;
            }

            // Case 2:
            if(!isIdentical(node.left, subNode.left)){
                return false;
            }

            // Case 3:
            if(!isIdentical(node.right, subNode.right)){
                return false;
            }
            return true;
        }

        // Print nodes that are seen from top View of the tree
        static class Info1{
            Node node;
            int hd;            

            public Info1(Node node, int hd){
                this.hd = hd;
                this.node = node;
            }
        }

        public static void topView(Node root){
            // Level order treversal
            Queue<Info1> q = new LinkedList<>();
            HashMap<Integer, Node> map = new HashMap<>();
            int min = 0, max = 0;

            q.add(new Info1(root, 0));
            q.add(null);

            while(!q.isEmpty()){

                Info1 curr = q.remove();

                if(curr == null){
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    // First time this horizontal distance appears
                    if(!map.containsKey(curr.hd)){
                        map.put(curr.hd, curr.node);
                    }

                    if (curr.node.left != null) {
                        q.add(new Info1(curr.node.left, curr.hd - 1));
                        min = Math.min(min, curr.hd - 1);
                    }
    
                    if (curr.node.right != null) {
                        q.add(new Info1(curr.node.right, curr.hd + 1));
                        max = Math.max(max, curr.hd + 1);
                    }
                }
            }

            // printing top view
            for(int i=min; i<=max; i++){
                System.out.print(map.get(i).data+ " ");
            }
            System.out.println();
        }
    }

        public static void main(String[] args) {
            int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
            Node root = BinaryTree.binaryTree(nodes);
            // Build binary tree
            System.out.println("The root node is "+ root.data);

            // preorder
            System.out.print("Preorder: ");
            BinaryTree.preorder(root);

            System.out.println();

            // Inorder
            System.out.print("Inorder: ");
            BinaryTree.inorder(root);

            System.out.println();

            // Outorder
            System.out.print("Outorder: ");
            BinaryTree.outorder(root);

            System.out.println();

            // Lever order
            System.out.println("Level Order: ");
            BinaryTree.levelOrder(root);

            System.out.println();

            // Height of the binary tree
            root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.left = new Node(6);
            root.right.right = new Node(7);

            // BinaryTree tree = new BinaryTree();
            // System.out.println("Height of the binary tree: "+ tree.height(root));
            System.out.println("Height of the binary tree: "+ BinaryTree.height(root));

            // Total number of nodes
            System.out.println("Total number of nodes in binary tree: "+ BinaryTree.count(root));
            
            // Total sum of nodes
            System.out.println("Total sum of nodes in binary tree: "+ BinaryTree.sum(root));
            
            // Diameter od tree
            System.out.println("Diameter of the tree is "+ BinaryTree.diameter(root));

            // Optimized code to find the diameter of the tree
            // BinaryTree.Info info = BinaryTree.optimizedDiameter(root);
            // System.out.println("Finding diameter of the tree using optimized code: " + info.diam);
            System.out.println("Finding diameter of the tree using optimized code: "+ BinaryTree.optimizedDiameter(root).diam);

            // Checking the subtree of another tree.
            Node subRoot = new Node(2);
            subRoot.left = new Node(4);
            subRoot.right = new Node(5);
            System.out.println("Determind is the subtree of another tree: "+ BinaryTree.isSubtree(root, subRoot));

            // Top View
            BinaryTree.topView(root);
        }
    }

