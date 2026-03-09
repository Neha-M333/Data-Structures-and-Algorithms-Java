
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
    }

        public static void main(String[] args) {
            int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
            Node root = BinaryTree.binaryTree(nodes);
            System.out.println("The root node is "+ root.data);

            System.out.print("Preorder: ");
            BinaryTree.preorder(root);

            System.out.println();

            System.out.print("Inorder: ");
            BinaryTree.inorder(root);

            System.out.println();

            System.out.print("Outorder: ");
            BinaryTree.outorder(root);

            System.out.println();

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

            System.out.println("Height of the binary tree: "+ BinaryTree.height(root));
            System.out.println("Total number of nodes in binary tree: "+ BinaryTree.count(root));
            System.out.println("Total sum of nodes in binary tree: "+ BinaryTree.sum(root));
        }
    }

