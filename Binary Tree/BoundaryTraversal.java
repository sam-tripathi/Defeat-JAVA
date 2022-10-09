import java.util.*;
class Node{
    int data;
    Node left, right;

    Node(int data){
        this.data = data;
    }
}

public class BoundaryTraversal {
    static Scanner sc = null;
    static Node create(){

        Node root  = null;
        System.out.println("Enter data:");
        int data = sc.nextInt();
        if(data == -1){
            return null;
        }
        else{
            root = new Node(data);
            System.out.println("Enter left for" + data);
            root.left = create();
            System.out.println("Enter right for" + data);
            root.right = create();
        }
        return root;
    }
   // public static ArrayList<Integer> traverseBoundary(Node root){
        
   // }
    public static boolean isLeaf(Node node){
        return (node.left == null) && (node.right == null);
    }
    public static void addLeftBoundary(Node node, ArrayList<Integer> ans){
        Node curr = node.left;
        while(curr != null){
            if(isLeaf(curr) == false) ans.add(curr.data);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }
    public static void addRightBoundary(Node node, ArrayList<Integer> ans)
    {
        Stack<Node> st = new Stack();
        Node curr = node.right;
        while(curr != null){
            if(isLeaf(curr) == false) st.push(curr);
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        while(!st.isEmpty()){
            ans.add(st.pop().data);
        }
    }
    public static void addLeav(Node node, ArrayList<Integer> ans){
        if(isLeaf(node) == true){
            ans.add(node.data);
            return;
        }
        if(node.left != null) addLeav(node.left, ans);
        if(node.right != null) addLeav(node.right, ans);
    }
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = create();
        ArrayList<Integer> ans = new ArrayList();
        if(isLeaf(root) == false) ans.add(root.data);
        addLeftBoundary(root, ans);
        addLeav(root, ans);
        addRightBoundary(root, ans);
    }
}