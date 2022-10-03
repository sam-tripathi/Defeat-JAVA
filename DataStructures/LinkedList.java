import java.io.*;
import java.util.*;
class LinkedList // creating a class Linked List 
{
     Node head; // Creating an object referance which is the head Node
    class Node{ // This is an inner class Node 
        int data;
        Node next;
        Node(int d) //  This is the construtor for initialising the Node 
        {
            data=d;
            next=null; 
        }
    }

    public  LinkedList insertFirst(LinkedList list,int data) //Inserting a new node at first 
    {
        Node new_node=new Node(data); //creating a node that is to be inserted at the first 
        new_node.next=null;
        if(list.head==null)
        {
            list.head=new_node; // if the list is empty , make the given node as the head node
        }
        else{
            new_node.next=head; //else add the given node as head and point the next pointer to the original present head
            head=new_node; // assign the present node as the head node
        }
        return list;
        
    }
    public LinkedList insertLast(LinkedList list,int data)//Inserting a new node at the last 
    {
        Node new_node=new Node(data);//creating a node that is to be inserted at the last
        if(list.head==null)
        {
            list.head=new_node; // if the list is empty , make the given node as the head node
        }
        else
        {
            Node curr=list.head; //referancing a temporary referance for traversing till last node
            while(curr.next!=null)
            {
                curr=curr.next; 
            }
            curr.next=new_node; // inserting the node
            new_node.next=null; // making the current node next as null , to mark the end of the List
        }
        return list;
    }
    public LinkedList insertMiddle(LinkedList list,int data,int pos)//inserting a new node at any given position other than last and first 
    {
        Node new_node=new Node(data);//creating a node that is to be inserted at the given position
        int count=1;
            Node curr=list.head;//referancing a temporary referance for traversing till teh previous node if the given position
            while(count<pos-1)
            {
                curr=curr.next;
                count++;
            }
            new_node.next=curr.next; //making the next of new node as the current next 
            curr.next=new_node; // the current next is made the new node
        return list;
    }
    public LinkedList deleteFirst(LinkedList list)//Delete at front
    {
        if(list.head==null) // if the list is empty , deletion leads to underflow
        {
            System.out.println("underflow");
        }
        Node temp=list.head; //copy the current head in a referance 
        list.head=list.head.next; //make the next node as the head node
        temp=null; // delete the copied head
        return list;
    }
    public LinkedList deleteLast(LinkedList list)//Delete at Last
    {
        Node curr=list.head;
        while(curr.next.next!=null) // travsering till the last but one node
        {
            curr=curr.next;
        }
        
        curr.next=null; // make the last node as null ..which is equivalent to deleting it
        
        return list;
    }
    public LinkedList deleteMiddle(LinkedList list,int pos)//Delete at Middle
    {
        Node curr=list.head;
        int count=1;
        while(count<pos-1) // traversing till the last but one node of the given poistion
        {
            curr=curr.next;
            count++;
        }
        Node temp=curr.next; // copy the required node
        curr.next=curr.next.next; // makes its next as the loop's current's next
        temp=null; //delete the node
        return list;
    }
    
    public void printList(LinkedList list) // This method is used to print the linked list
    {
        Node curr=list.head; //referance for traversing
        while(curr.next!=null) // traversing till last but one node
        {
            System.out.print(curr.data+"->");
            curr=curr.next; 
        }
        System.out.println(curr.data); // the last node
    }
}
public class Linkedcomplete
{
	public static void main(String[] args) throws IOException{
	      LinkedList list=new LinkedList(); // Creating the linked list object
	      list = list.insertFirst(list, 1);  // performing the required operations
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
