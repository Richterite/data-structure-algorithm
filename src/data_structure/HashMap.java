package data_structure;

import java.util.ArrayList;
import java.util.Objects;

public class HashMap {
    private int size = 7;
    private Node[] datamap;


    class Node{
        private String key;
        private int value;
        private Node next;


        public Node(String key, int value){
            this.key = key;
            this.value = value;
        }
    }


    public HashMap(){
        // creating instance with "[]" indicates that it was list or array of data
        // if you want to create an instance with parameter inside, use for loop and add the instance one by one until array reach its limit
        datamap = new Node[size];
    }

    public void showHashTable(){
        for (int i = 0; i < datamap.length; i++){
            System.out.println(i + ":");
            Node current = datamap[i];
            while (current != null){
                System.out.println(" {" + current.key + " = "+ current.value +"}");
                current = current.next;
            }
        }
    }


    private int hash(String key){
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for (int asciiValue : keyChars) {
            // we use '37' here as a secret key, fell free to change it.
            // NOTE: remember to use consistent number for the secret key, dont change it frequently.
            // using remainder ops (%) by its datamap length is to make the return value is in between 0 - datamap.length (size)
            // in this case, the size is 7. So the return value (hash) is in between 0 - 6;
            hash = (hash + asciiValue * 37) % datamap.length;
        }

        return hash;
    }


    public void set(String key, int value){
        int tableIndex = this.hash(key);
        Node newNode = new Node(key, value);
        if (datamap[tableIndex] == null){
            datamap[tableIndex] = newNode;
        } else {
            Node current = datamap[tableIndex];
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }


    public int get(String key){
        int tableIndex = this.hash(key);
        Node current = datamap[tableIndex];
        while (current != null){
            if (Objects.equals(current.key, key)){
                return current.value;
            }
            current = current.next;
        }
        return 0;
    }


    public ArrayList getKeys(){
        ArrayList<String> keyList = new ArrayList<>();
        for (int i = 0; i < datamap.length; i++){
            Node current = datamap[i];
            while (current != null){
                keyList.add(current.key);
                current = current.next;
            }

        }
        return  keyList;
    }
}
