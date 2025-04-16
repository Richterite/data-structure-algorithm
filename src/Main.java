import data_structure.BinarySearchTree;
import data_structure.DoublyLinkedList;
import data_structure.LinkedList;

public class Main {
    public static void main(String[] args) {

//        // Linked List
//        LinkedList linkedList = new LinkedList(4);
//        linkedList.append(2);
//        linkedList.append(1);
//        linkedList.append(3);
//        linkedList.prepend(99);
//        System.out.println(linkedList.pop().value);
//
//        linkedList.getHead();
//        linkedList.getTail();
//        linkedList.getLength();
//        linkedList.printList();

//        // Doubly Linked List
//        DoublyLinkedList list = new DoublyLinkedList(1);
//
//        list.getHead();
//        list.printList();


        // binary search tree
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(47);
        tree.insert(21);
        tree.insert(76);
        tree.insert(18);
        tree.insert(27);
        tree.insert(52);
        tree.insert(82);

        System.out.println("DFS PRE ORDER");
        System.out.println( tree.DFSPreOrder() );
        System.out.println("DFS POST ORDER ");
        System.out.println( tree.DFSPostOrder() );
        System.out.println("DFS InOrder");
        System.out.println( tree.DFSInOrder());





    }
}