// SUM OF NODES
//Time Complexity = O(n)
import java.util.*;
class Node{
    int data;
    Node left, right;

    Node(int data){
        this.data = data;
    }
}

public class sumOfNodes{
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
    public static int countSum(Node root){
        if(root==null){
            return 0;
        }
        int leftSum = countSum(root.left);
        int rightSum = countSum(root.right);
        return leftSum + rightSum + root.data;
    }
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = create();

        System.out.print("Total Number of Nodes: " + countSum(root));
        
    }
}    