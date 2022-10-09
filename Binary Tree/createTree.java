import java.util.*;
// create a node
class Node{
    int data;
    Node left, right;

    Node(int data){
        this.data = data;
    }
}
// build tree
public class createTree{
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
    // traverse in pre-order
    public static void prOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        prOrder(root.left);
        prOrder(root.right);
    }
    // traverse in Inorder
    public static void inOrder(Node root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
        
    }
    // traverse in post-order
    public static void postOrder(Node root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
    // traverse in Level order
    public static void levelOrder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node cnode = q.remove();
            if(cnode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(cnode.data+" ");
                if(cnode.left!=null){
                    q.add(cnode.left);
                }
                if(cnode.right!=null){
                    q.add(cnode.right);
                }
            }
        }
    }
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = create();
        //System.out.println(root.data);
        //prOrder(root);
        //inOrder(root);
        //postOrder(root);
        levelOrder(root);
    }
}