import java.util.*;
class StackDemo
{
    static void showpush(Stack<Integer> st,int a)
    {
        st.push(a);
        System.out.println("push("+a+") ");
        System.out.println("stack: "+st);
    }
    static void showpop(Stack<Integer> st)
    {
        System.out.print("pop -> ");
        Integer a =(Integer)st.pop();
        System.out.println(a);
    }
    static void showpeek(Stack<Integer> st)
    {
        Integer element=st.peek();
        System.out.println("The top element is "+element);
    }
    static void showsearch(Stack<Integer> st,int item)
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
	    Stack<Integer> st=new Stack<>();
		StackDemo.showpush(st,2);
	    StackDemo.showpush(st,3);
	    StackDemo.showpush(st,4);
	    StackDemo.showpush(st,5);
	    StackDemo.showpop(st);
	    StackDemo.showpop(st);
	    StackDemo.showpeek(st);
	    StackDemo.showsearch(st,2);
	}
}
