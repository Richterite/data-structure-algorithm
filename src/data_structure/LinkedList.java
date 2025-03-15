package data_structure;

public class LinkedList {
    // Big O:
    // add : O(1)
    // remove-tail: O(n)
    // remove-head: O(1)
    // remove-between : O(n)
    // insert : O(n)
    // find : O(n)
    private Node head;
    private Node tail;
    private int length;

    public class Node {
        public int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

    public LinkedList(int value){
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
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

    public void insert(int value){
        Node node = new Node(value);
        Node temp = tail;
        for (int i = 0; i < this.length; i++){
            if (temp.next == null){
                temp.next = node;
                tail = node;
                this.length++;

            };
        }
    }

    public void append(int value){
        Node node = new Node(value);
        if (this.length == 0){
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = node;
        }
        this.length++;
    }

    public void prepend(int value){
        Node node = new Node(value);
        if (this.length == 0){
            this.head = node;
            this.tail = node;
        } else {
            node.next = head;
            this.head = node;
        }
        this.length++;
    }


    public Node pop(){
        if (this.length == 0){
            System.out.println("Theres no value in it");
            return null;
        } else {
            Node temp = head;
            Node prev = temp;
            while (temp.next != null){
                prev = temp;
                temp = temp.next;
            }

            this.tail = prev;
            this.tail.next = null;
            this.length--;
            if (this.length == 0) {
                this.head = null;
                this.tail = null;
            }

            return temp;
        }
    }

    public Node popFirst(){
        if (this.length == 0) {
            System.out.println("There is nothing in it");
            return null;
        }
        Node temp = this.head;
        this.head = this.head.next;
        temp.next = null;
        this.length--;
        if (this.length == 0){
            this.head = null;
            this.tail = null;
        };
        return temp;
    }


    public Node getValueByIndex(int index){
        if (index < 0 || index >= this.length){
            return null;
        }

        Node temp = this.head;

        for (int i=0; i < index; i++){
            temp = temp.next;
        }

        return temp;
    }


    public boolean set(int index, int value){
        Node temp = this.getValueByIndex(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value){
        if (index < 0 || index > this.length){
            return false;
        }

        if (index == 0){
            this.prepend(value);
            return true;
        } else if (index == this.length){
            this.append(value);
            return true;
        }
        Node node = new Node(value);
        Node temp = this.getValueByIndex(index - 1);
        node.next = temp.next;
        temp.next = node;
        this.length++;
        return true;
    }

    public Node remove(int index){
        if (index < 0 || index >= this.length){
            return null;
        }

        if (index == 0){
            return this.popFirst();
        }

        if (index == this.length - 1) {
            return this.pop();
        }

        Node prev = getValueByIndex(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        this.length--;
        return temp;

    }

    public void reverse(){
        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;

        // create variable to navigate through the list.
        // prev null because there is nothing in it.
        Node prevNode = null;
        Node nextNode = temp.next;
        for (int i = 0; i < this.length; i++){
            nextNode = temp.next;
            temp.next = prevNode;
            prevNode = temp;
            temp = nextNode;
        }
    }







}
