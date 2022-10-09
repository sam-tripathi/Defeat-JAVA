// HEIGHT OF TREE
//Time Complexity = O(n)
import java.util.*;
class Node{
    int data;
    Node left, right;

    Node(int data){
        this.data = data;
    }
}

public class heightOfTree{
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
    public static int countHeight(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight = countHeight(root.left);
        int rightHeight = countHeight(root.right);
        int ans = Math.max(leftHeight,rightHeight) + 1;
        return ans;

    }
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node root = create();

        System.out.println("Height of Tree: " + countHeight(root));
        
    }
}    