package data_structure;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        public int value;
        Node next;
        Node prev;

        public Node(int value){
            this.value = value;
        }
    }

    public DoublyLinkedList(int value){
        Node node = new Node(value);
        this.head = node;
        this.tail = node;
        this.length = 1;
    }

    public void printList(){
        Node temp = this.head;
        while (temp != null){
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    public void getHead(){
        System.out.println("Head Value: " + this.head.value);
    }
    public void getTail(){
        System.out.println("Tail Value : " + this.tail.value);
    }
    public void getLength(){
        System.out.println("List Length : " + this.length);
    }

    public void append(int value){
        Node node = new Node(value);
        if (this.length == 0){
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }

        this.length++;

    }
}
