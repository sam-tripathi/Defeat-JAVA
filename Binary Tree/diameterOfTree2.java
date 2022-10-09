// Diameter OF TREE(Approach 2)
//Time Complexity = O(n)
import java.util.*;
class Node{
    int data;
    Node left, right;

    Node(int data){
        this.data = data;
    }
}

public class diameterOfTree2{
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
    static class TreeInfo{
        int ht;
        int diam;

        TreeInfo(int ht, int diam){
            this.ht = ht;
            this.diam = diam;
        }
    }
    public static TreeInfo diameter(Node root){
        if(root==null){
            return new TreeInfo(0,0);
        }
        TreeInfo lefttree = diameter(root.left);
        TreeInfo righttree = diameter(root.right);
        int myHeight = Math.max(lefttree.ht,righttree.ht)+1;

        int dim1 = lefttree.diam;
        int dim2 = righttree.diam;
        int dim3 = lefttree.ht+righttree.ht+1;

        int mydiameter = Math.max(Math.max(dim1,dim2),dim3);
        TreeInfo myInfo = new TreeInfo(myHeight,mydiameter);
        return myInfo;
    }
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = create();

        System.out.println("Diameter of Tree: " + diameter(root).diam);
        
    }
}    