package binaryTree1;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BinaryTreeTakeinputoutputlevelwise {

	public static BinaryTreeNode<Integer> takeinputlevelwise()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the root data");
	    
		int rootdata = s.nextInt();
		if(rootdata == -1)
    	{
			return null;
    	}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootdata);
		Queue<BinaryTreeNode<Integer>>q = new LinkedList<>();
		q.add(root);
    	
		while(!q.isEmpty())
		{
			 BinaryTreeNode<Integer> front = q.poll();
			 System.out.println("Enter left child of root"+" "+front.data);
			 int leftdata = s.nextInt();
			 if(leftdata != -1)
			 {
				BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(leftdata);
				q.add(node1);
				front.left = node1;
			 }
			 // for right child
			 System.out.println("Enter right child of root"+" "+front.data);
			 int rightdata = s.nextInt();
			 if(rightdata != -1)
			 {
				BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(rightdata);
				q.add(node2);
				front.right =node2;
			 }
		}
		return root;
     }
	// printing nodes levelwise
	public static void printLevelWise(BinaryTreeNode<Integer> root) 
    {
		//Your code goes here
         if(root == null)
            return ;
         Queue<BinaryTreeNode<Integer>> Q = new LinkedList<BinaryTreeNode<Integer>>();
         Q.add(root);
         Q.add(null);
         while(!Q.isEmpty() && Q.peek() != null)
         {
             BinaryTreeNode<Integer> front = Q.poll();
             if(front != null)
             {
                  System.out.print(front.data+":");
                  if(front.left != null)
                  {
                      Q.add(front.left);
                      System.out.print("L:"+front.left.data+",");   
                  }
                  if(front.left == null)
                  {
                      System.out.print("L:-1"+",");
                  }
                  if(front.right != null)
                  {
                      Q.add(front.right);
                      System.out.print("R:"+front.right.data);
                  }
                  if(front.right == null)
                  { 
                      System.out.print("R:-1");
                  }
                  System.out.println();
            }
           if(Q.peek() == null)
           {
                Q.poll();
                Q.add(null);
          }     
        }
	}
	public static void main(String[] args) 
	{
		BinaryTreeNode<Integer> root =takeinputlevelwise();
		printLevelWise(root);
	}

}
