import java.io.*;
import java.util.*;
class LinkedList
{
     Node head;
    class Node{
        int data;
        Node next;
        Node(int d)
        {
            data=d;
            next=null;
        }
    }

    public  LinkedList insertFirst(LinkedList list,int data)//Inserting a new node at first 
    {
        Node new_node=new Node(data);
        new_node.next=null;
        if(list.head==null)
        {
            list.head=new_node;
        }
        else{
            new_node.next=head;
            head=new_node;
        }
        return list;
        
    }
    public LinkedList insertLast(LinkedList list,int data)//Inserting a new node at the last 
    {
        Node new_node=new Node(data);
        if(list.head==null)
        {
            list.head=new_node;
        }
        else
        {
            Node curr=list.head;
            while(curr.next!=null)
            {
                curr=curr.next;
            }
            curr.next=new_node;
            new_node.next=null;
        }
        return list;
    }
    public LinkedList insertMiddle(LinkedList list,int data,int pos)//inserting a new node at the last
    {
        Node new_node=new Node(data);
        int count=1;
            Node curr=list.head;
            while(count<pos-1)
            {
                curr=curr.next;
                count++;
            }
            new_node.next=curr.next;
            curr.next=new_node;
        return list;
    }
    public LinkedList deleteFirst(LinkedList list)//Delete at front
    {
        if(list.head==null)
        {
            System.out.println("Overflow");
        }
        Node temp=list.head;
        list.head=list.head.next;
        temp=null;
        return list;
    }
    public LinkedList deleteLast(LinkedList list)//Delete at Last
    {
        Node curr=list.head;
        while(curr.next.next!=null)
        {
            curr=curr.next;
        }
        
        curr.next=null;
        
        return list;
    }
    public LinkedList deleteMiddle(LinkedList list,int pos)//Delete at Middle
    {
        Node curr=list.head;
        int count=1;
        while(count<pos-1)
        {
            curr=curr.next;
            count++;
        }
        Node temp=curr.next;
        curr.next=curr.next.next;
        temp=null;
        return list;
    }
    
    public void printList(LinkedList list)
    {
        Node curr=list.head;
        while(curr.next!=null)
        {
            System.out.print(curr.data+"->");
            curr=curr.next;
        }
        System.out.println(curr.data);
    }
}
public class Linkedcomplete
{
	public static void main(String[] args) throws IOException{
	      LinkedList list=new LinkedList();
	      list = list.insertFirst(list, 1); 
	      list = list.insertFirst(list, 2); 
          list = list.insertFirst(list, 3);
          list = list.insertLast(list, 4); 
          list=list.insertMiddle(list,5,3);
          list=list.deleteFirst(list);
          list=list.deleteLast(list);
          list=list.deleteMiddle(list,2);

        list.printList(list); 
	}
}
