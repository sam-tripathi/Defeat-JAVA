import java.util.ArrayList;


public class BSTTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;

        }

    }

    public static Node insertBST(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = insertBST(root.left, val);
        } else {
            root.right = insertBST(root.right, val);
        }
        return root;
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // search->O(height)
    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data > key) {
            return search(root.left, key);
        } else if (root.data == key) {
            return true;
        } else {
            return search(root.right, key);
        }
    }

    // Minimum value
    public static Node minVal(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // maximum Value
    public static Node maxal(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    // Delete Node
    public static Node deleteNode(Node root, int key) {
        if (root.data > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.data < key) {
            root.right = deleteNode(root.right, key);
        } else {
            // no child
            if (root.left == null && root.right == null) {
                return null;
            }
            // only right child
            if (root.left == null) {
                return root.right;
            }
            //only left child
            else if (root.right == null) {
                return root.left;
            }
            // 2 child
                Node min = minVal(root.right);
                root.data = min.data;
                root.right = deleteNode(root.right, min.data);
        }
        return root;
    }
    // Print in Range
    public static void printInRange(Node root,int start,int end){
        if(root==null){
            return;
        }
        if(root.data >=start && root.data <=end){
            printInRange(root.left, start, end);
            System.out.print(root.data+" ");
            printInRange(root.right, start, end);
        }else if(start>=root.data){
            printInRange(root.right, start, end);
        }
        else{
            printInRange(root.left, start, end);
        }
    }

    public static void pritntPath(ArrayList<Integer>path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+" ");
        }
        System.out.println("");
    }

    //root to leaf path

    public static void rootToLeaf(Node root,ArrayList<Integer> path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right==null){
            pritntPath(path);
        }else{
            rootToLeaf(root.left, path);
            rootToLeaf(root.right, path);
        }
        path.remove(path.size()-1);
    }
    public static void main(String[] args) {
        int[] values = { 7,5,12,4,6,11,14,13 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insertBST(root, values[i]);
            //inOrder(root);
            //System.out.print("");
        }
        inOrder(root);
        System.out.println(" ");
        //deleteNode(root, 5);
        //inOrder(root);

        /*
         * if(search(root, 5)){
         * System.out.println("Found");
         * }
         * else{
         * System.out.println("Not Found");
         * }
         */
        //printInRange(root, 5, 11);

        rootToLeaf(root, new ArrayList<>());

    }
}