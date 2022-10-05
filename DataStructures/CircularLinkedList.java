public class CircularLinkedList {


    private ListNode head;
    private ListNode tail;
    private class ListNode{
        int value;
        ListNode next;

    public ListNode
            (int value) {
            this.value = value;
        
    }
}
public void insert(int value){
    ListNode node=new ListNode(value);
    if(head==null){
        head=node;
        tail=node;
        return ;
    }
    tail.next=node;
    node.next=head;
    tail=node;

}
public void display() {
    ListNode node = head;
    if (head != null) {
        do {
            System.out.print(node.value + " -> ");
            if (node.next != null) {
                node = node.next;
            }
        } while (node != head);
    }
    System.out.println("HEAD");
}
public CircularLinkedList() {
    this.head = null;
    this.tail = null;
}


public static void main(String[] args) {
    CircularLinkedList list= new CircularLinkedList();
    list.insert(65);
    list.insert(42);
    list.insert(5);
    list.insert(7);
    list.insert(327);
    list.insert(31);
    list.display();
}
}
