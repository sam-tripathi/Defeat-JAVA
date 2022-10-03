import java.util.Scanner;
public class Tree{
    static Scanner sc=null;
    //main function where tree is run
    public static void main(String argc[]){
           sc=new Scanner(System.in);
           Node root1=createTree();
           System.out.println("root for tree is "+root1.data);
    }
    //creating the binary tree
    static Node createTree(){
        Node root=null;
        System.out.println("Enter data: ");
        int data=sc.nextInt();
        if(data==-1) return null;
        root =new Node(data);
        System.out.println("Enter left for "+data);
        root.left=createTree();
        System.out.println("Enter right for "+data);
        root.right=createTree();
        return root;
    }
    // travesal of the binary tree
    static void inOrder(Node root){
        if(root==null)return;
        inOrder(root.left);
        System.out.println(root.data+" ");
        inOrder(root.right);
    }
    static void preOrder(Node root){
        if(root==null)return;
        System.out.println(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    static void postOrder(Node root){
        if(root==null)return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data+" ");
    } 
    //height of the binary tree 
    static int height(Node root){
        if(root==null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }
    //size of the binary tree
    static int sizeOfTree(Node root){
       if(root==null)return 0;
       return (sizeOfTree(root.left)+sizeOfTree(root.right)+1);
    } 
    //max min in a binary tree
    static int maxNo(Node root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data, Math.max(maxNo(root.left),maxNo(root.right)));
    }
}
//Node for the binary tree 
class Node{
    Node left,right;
    int data;
    public Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}