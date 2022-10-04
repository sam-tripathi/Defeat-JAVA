// This is a java program for creating Stack Data Structure and performing stack operations 
import java.util.*;
class StackDemo
{
    static void showpush(Stack<Integer> st,int a) // This method performs the push operation  
    {
        st.push(a);
        System.out.println("push("+a+") ");
        System.out.println("stack: "+st);
    }
    static void showpop(Stack<Integer> st) // This methods performs the pop opertaion 
    {
        System.out.print("pop -> ");
        Integer a =(Integer)st.pop(); // popping
        System.out.println(a);
    }
    static void showpeek(Stack<Integer> st) // This method is called as the peek and it shows the topmost element of the stack
    {
        Integer element=st.peek();
        System.out.println("The top element is "+element);
    }
    static void showsearch(Stack<Integer> st,int item) // This method is is used to show wheteher the element we want to search is present or not
    {
        Integer pos=(Integer)st.search(item);
        if(pos==-1)
         System.out.println("Element not found");
         else
         System.out.println("Element found at "+pos);
    }
}
public class stack
{
	public static void main(String[] args) {
	    Stack<Integer> st=new Stack<>(); // Creating a collection Stack
		StackDemo.showpush(st,2); // push operation
	    StackDemo.showpush(st,3);
	    StackDemo.showpush(st,4);
	    StackDemo.showpush(st,5);
	    StackDemo.showpop(st); //pop operation
	    StackDemo.showpop(st);
	    StackDemo.showpeek(st); //peek operation
	    StackDemo.showsearch(st,2); //search operation
	}
}
