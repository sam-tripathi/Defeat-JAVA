// COUNT OF NODES
// Time Complexity = O(n)
import java.util.*;
class Node{
    int data;
    Node left, right;

    Node(int data){
        this.data = data;
    }
}

public class countOfNodes{
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
    public static int count(Node root){
        if(root==null){
            return 0;
        }
        int leftNodes = count(root.left);
        int rigthNodes = count(root.right);
        return leftNodes + rigthNodes + 1;
    }
    
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = create();

        System.out.print("Total Number of Nodes: " + count(root));
        
    }
}    