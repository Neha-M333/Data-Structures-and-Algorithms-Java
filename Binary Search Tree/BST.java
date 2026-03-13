
    import java.util.ArrayList;

    public class BST {
        static class Node{
            int data;
            Node left;
            Node right;

            Node(int data){
                this.data = data;
            }
        }

        // Building a binary sarch tree
        public static Node insert(Node root, int val){
            if(root == null){
                return new Node(val);  // This will be the root
            }

            if(root.data > val){
                root.left = insert(root.left, val);    // Indert in left subtree
            }else{
                root.right = insert(root.right, val);  // Insert in right subtree
            }
            return root;
        }

        // We use inorder to print sorted values
        public static void inOrder(Node root){
            if(root == null){
                return;
            }

            inOrder(root.left);
            System.out.print(root.data+ " ");
            inOrder(root.right);
        }

        // Search a value in binary search tree
        public static boolean search(Node root, int key){
            if(root == null){
                return false;
            }

            if(root.data == key){
                return true;
            }

            if(key < root.data){
                return search(root.left, key);
            }else{
                return search(root.right, key);
            }
        }

        // deletng a node in BST
        public static Node delete(Node root, int val){
            // Navigates the node (Search the value to delete)
            if(root.data < val){
                root.right = delete(root.right, val);
            }else if(root.data > val){
                root.left = delete(root.left, val);
            }
            
            // When the node is found
            else{
                // Case 1: Leaf node
                if(root.left == null && root.right == null){
                    return null;
                }

                // Case 2: One child
                if(root.left == null){
                    return root.right;
                }else if(root.right == null){
                    return root.left;
                }

                // Case 3: Two children
                Node is = findInorSuccessor(root.right);
                root.data = is.data;
                root.right = delete(root.right, is.data);
            }
            return root;
        }

        public static Node findInorSuccessor(Node root){
            while(root.left != null){
                root = root.left;
            }
            return root;
        }

        // Printing the nodes which lies between the range.
        public static void printInRange(Node root, int k1, int k2){
            if(root == null){
                return;
            }

            // Case 1:
            if(root.data >= k1 && root.data <= k2){
                printInRange(root.left, k1, k2);
                System.out.print(root.data+ " ");
                printInRange(root.right, k1, k2);
            }

            // Case 2:
            else if(root.data < k1){
                printInRange(root.right, k1, k2);
            }else{
                // Case 3:
                printInRange(root.left, k1, k2);
            }
        }

        // Print paths from root to leaf
        public static void printPath(ArrayList<Integer> path){
            for(int i=0; i<path.size(); i++){
                System.out.print(path.get(i)+ "->");
            }
            System.out.println("NULL");
        }

        public static void printRoot2Leaf(Node root, ArrayList<Integer> path){
            if(root == null){
                return;
            }

            if(root.left == null && root.right == null){
                printPath(path);
            }

            path.add(root.data);
            printRoot2Leaf(root.left, path);
            printRoot2Leaf(root.right, path);
            path.remove(path.size() - 1);
        }

        // Validate BST
        public static boolean validBst(Node root, Node min, Node max){
            if(root == null){
                return true;
            }

            if(min != null && root.data <= min.data){
                return false;
            }

            if(max != null && root.data >= max.data){
                return false;
            }

            return validBst(root.left, min, root) && validBst(root.right, root, max);
        }

        // Mirror a BST
        public static Node mirror(Node root){
            if (root == null){
                return null;
            }

            Node leftMirrorSubTree = mirror(root.left);
            Node rightMirrorSubTree = mirror(root.right);

            root.left = rightMirrorSubTree;
            root.right = leftMirrorSubTree;

            return root;
        }

        // To print the mirror BST I will use preorder
        public static void preorder(Node root){
            if(root == null){
                return;
            }

            System.out.print(root.data+ " ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void main(String[] args) {
            // int val[] = {5, 1, 3, 4, 2, 7};
            // Node root = null;

            // for(int i=0; i<val.length; i++){
            //     root = insert(root, val[i]);
            // }

            // // Buil a BST
            // inOrder(root);

            // System.out.println();

            // // Search a value in BST
            // if(search(root, 6)){
            //     System.out.println("FOUND!");
            // }else{
            //     System.out.println("NOT FOUND!");
            // }
            //---------------------------------------

            // // Delete a node in BST
            // int val[] = {8,5,3,1,6,10,11,14};
            // Node root = null;

            // for(int i=0; i<val.length; i++){
            //     root = insert(root, val[i]);
            // }

            // inOrder(root);
            // System.out.println();

            // root = delete(root, 14);
            // System.out.println();

            // inOrder(root);
            //-------------------------------------

            // // Print nodes between the range
            // printInRange(root, 5, 12);
            // System.out.println();

            // // Print paths from root to leaf
            // printRoot2Leaf(root, new ArrayList<>());
            //-----------------------------------------

            // // Validate BST
            // int val[] = {8,5,3,1,6,10,11,14};
            // Node root = null;

            // for(int i=0; i<val.length; i++){
            //     root = insert(root, val[i]);
            // }
            
            // inOrder(root);
            // System.out.println();

            // if(validBst(root, null, null)){
            //     System.out.println("VALID");
            // }else{
            //     System.out.println("NOT VALID");
            // }
            //-------------------------------------

            // Mirror a BST
            Node root = new Node(8);
            root.left = new Node(5);
            root.right = new Node(10);
            root.left.left = new Node(3);
            root.left.right = new Node(6);
            root.right.right = new Node(11);

            inOrder(root);
            System.out.println();

            root = mirror(root);
            preorder(root);
            System.out.println();
        }
    }
