import java.util.*;
import java.io.*;
public class BinaryTree {
    public static class Node{
        int data;
        Node left;
        Node right;
        
        Node(int data,Node left,Node right)
        {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static class Pair{
        Node node;
        int state;
        Pair(Node node,int state)
        {
            this.node = node;
            this.state = state;
        }
    }
    public static void display(Node root)
    {
        if(root == null)
        {
            return;
        }
        String str = "";
        str += root.left == null ? "." : root.left.data + " ";
        str += " <- " + root.data + " -> ";
        str += root.right == null ? "." : root.right.data + " ";
        System.out.println(str);
        
        display(root.left);
        display(root.right);
        
    }
    public static void main(String[] args) {
        Integer[] arr = {
            50, 25, 12,null,null,37,30,null,null,null,75,62,null,70,null,null,87,null
        };
        Node root = new Node(arr[0],null,null);
        Stack<Pair> st = new Stack<>();
        
        Pair rtp = new Pair(root,1);
        st.push(rtp);
        int ind = 1;
        
        while(st.size() > 0 && ind < arr.length)
        {
                Pair p = st.peek();
                if(p.state == 1)
                {   
                    if(arr[ind] != null)
                    {  
                        Node nn = new Node(arr[ind],null,null);
                        p.node.left = nn;
                        Pair lp = new Pair(nn,1);
                        st.push(lp);
                        // System.out.println("Index is "+ ind+" val "+arr[ind]);
                        
                    } else if(arr[ind] == null){
                        p.node.left = null;
                    }
                    ind++;
                    p.state++;
                }
                else if(p.state == 2)
                {  
                    if(arr[ind] != null)
                    {
                        Node nn = new Node(arr[ind],null,null);
                        p.node.right = nn;
                        Pair rp = new Pair(nn,1);
                        st.push(rp);
                        // System.out.println("Index is "+ ind+" val "+arr[ind]);
                        
                        
                    }
                    else if(arr[ind] == null){
                        p.node.right = null;
                
                    }
                    ind++;
                    p.state++;
               }
               else {
                   st.pop();
               }
            // System.out.println("Size  "+st.size());
        }
        display(root);
    }
}
