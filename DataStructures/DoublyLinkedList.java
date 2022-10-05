public class DoublyLinkedList {
    ListNode head;
    private class ListNode{

        int value;
        ListNode prev;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

        public ListNode(int value, ListNode prev, ListNode next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
    //Insert a node from begining of the list
    public void insertFromStart(int value){

        ListNode node= new ListNode(value);
        node.next=head;
        node.prev=null;
        if (head!=null){
            head.prev=node;
        }
        head=node;

    }
    //Find a node
    public ListNode find(int value){
        ListNode temp=head;
        while (temp!=null){
            if(temp.value==value){
                return temp;
            }
            temp=temp.next;

        }
        return null;
    }
    //Insert node after another node
    public void insert(int after,int value){
        ListNode temp=find(after);
        if (temp==null){
            System.out.println("Doesn't exist");
            return ;
        }
        ListNode node= new ListNode(value);
        node.next=temp.next;
        temp.next=node;
        node.prev=temp;
        if (node.next!=null){
            node.next.prev=node;
        }

    }
    //Insert last
    public void insertAtEnd(int value){
        ListNode node=new ListNode(value);
        ListNode last=head;
    node.next=null;
    if (head==null){
        node.prev=null;
        head=node;
        return ;
    }
    while(last.next!=null){
        last=last.next;
    }
    last.next=node;
    node.prev=last;
}

public void display(){
    ListNode node = head;
    ListNode last = null;
    while (node != null) {
        System.out.print(node.value + " -> ");
        last = node;
        node = node.next;
    }
    System.out.println("END");

    System.out.println("Print in reverse");
    while (last != null) {
        System.out.print(last.value + " -> ");
        last = last.prev;
    }
    System.out.println("START");
}

public static void main(String[] args) {
    DoublyLinkedList list=new DoublyLinkedList();
    list.insertFromStart(3);
    list.insertFromStart(4);
    list.insertFromStart(5);
    list.insertFromStart(6);
    list.insertFromStart(7);
    list.insert(5,8);
    list.display();
}
}
