public class InRange {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static Node delet(Node root, int val) {
        if (root == null) {
            return null; // Handle case when root is null
        }
        if (root.data < val) {
            root.right = delet(root.right, val);
        } else if (root.data > val) {
            root.left = delet(root.left, val);
        } else { // case 1 -> leaf node
            if (root.left == null && root.right == null) {
                return null;
            }
            // case 2 -> single child
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // case 3 -> both children
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delet(root.right, IS.data);
        }
        return root;
    }

    public static Node inorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }
    public static void  printinrange (Node root , int r1 , int r2 ){
        if(root == null ){
            return ;
        }
         if(root.data >=r1 && root.data <=r2  ){
            printinrange(root.left , r1, r2);
             System.out.print( root.data +" ");
             printinrange(root.right  , r1, r2);
         }else if (root.data <r1 ){
             printinrange(root.left , r1, r2);
         }else {
            printinrange(root.right , r1, r2);
         }
    }
    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;
        for (int value : values) {
            root = insert(root, value);
        }
        
        System.out.print("Inorder before deletion: ");
        inorder(root);
        System.out.println();
        
        root = delet(root, 1);

        System.out.print("Inorder after deletion: ");
        inorder(root);
        System.out.println();
        printinrange(root,5, 12);
    } 
}
