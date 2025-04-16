package data_structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    public Node root;

    class Node {
        private Node left;
        private Node right;
        public int value;

        public Node(int value){
            this.value = value;
        }
    }


    public boolean insert(int value){
        Node node = new Node(value);
        if (root == null){
            this.root = node;
            return true;
        }
        Node current = this.root;
        while (true){
            if (node.value == current.value ) return false;
            if (node.value > current.value){
                if (current.right == null){
                    current.right = node;
                    return true;
                }
                current = current.right;
            } else {
                if (current.left == null){
                    current.left = node;
                    return true;
                }
                current = current.left;
            }
        }
    }


    public boolean contains(int value){
        Node current = this.root;
        while (current != null){
            if (value > current.value){
                current = current.right;
            } else if (value < current.value){
                current = current.left;
            } else {
                return true;
            }
        }

        return false;
    }


    // Recursive implementation
    private boolean rContains(Node currentNode, int value){
        if (currentNode == null) return false;
        if (currentNode.value == value) return true;
        if (currentNode.value > value){
            return this.rContains(currentNode.left, value);
        } else {
            return this.rContains(currentNode.right, value);
        }
    }

    public boolean rContains(int value){
        return this.rContains(this.root, value);
    }


    private Node rInsert(Node currentNode, int value){
        if (currentNode == null) return new Node(value);
        if (currentNode.value > value){
            currentNode.left = this.rInsert(currentNode.left, value);
        } else if (currentNode.value < value){
            currentNode.right = this.rInsert(currentNode.right, value);
        }

        return currentNode;
    }

    public void rInsert(int value){
        if (this.root == null) this.root = new Node(value);
        this.rInsert(this.root, value);
    }


    private Node rDelete(Node currentNode, int value){
        if (currentNode == null) return null;
        if (currentNode.value > value){
            currentNode.left = this.rDelete(currentNode.left, value);
        } else if ( currentNode.value < value) {
            currentNode.right = this.rDelete(currentNode.right, value);
        } else {
            if (currentNode.left == null && currentNode.right == null){
                return null;
            } else if (currentNode.left == null){
                currentNode = currentNode.right;
            } else if (currentNode.right == null) {
                currentNode = currentNode.left;
            } else {
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = this.rDelete(currentNode.right, subTreeMin);

            }
        }

        return  currentNode;
    }

    public void rDelete(int value){
        this.rDelete(this.root, value);
    }

    // helper
    private int minValue(Node currentNode){
        while (currentNode.left != null){
            currentNode = currentNode.left;
        }

        return currentNode.value;
    }


    // tree traverse
    public ArrayList<Integer> BFS(){
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        queue.add(currentNode);

        while (!queue.isEmpty()){
            currentNode = queue.remove();
            results.add(currentNode.value);

            if(currentNode.right != null){
                queue.add(currentNode.right);
            }

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

        }
        return results;
    }

    // the diff between post and pre are just in the placement of appending node result to result array
    // in preorder we append first then traverse
    // while in post order we traverse first then append
    // inOrder the append method are place in between two traverse (between two if)
    public ArrayList<Integer> DFSPreOrder(){
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse{
            public Traverse(Node currentNode){
                results.add(currentNode.value);
                if (currentNode.left != null){
                    new Traverse(currentNode.left);
                }

                if (currentNode.right != null){
                    new Traverse(currentNode.right);
                }
            }
        }

        new Traverse(root);
        return results;
    }

    public ArrayList<Integer> DFSPostOrder(){
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            public Traverse(Node currentNode){
                if (currentNode.left != null){
                    new Traverse(currentNode.left);
                }

                if (currentNode.right != null){
                    new Traverse(currentNode.right);
                }
                results.add(currentNode.value);
            }
        }

        new Traverse(root);
        return results;
    }

    public ArrayList<Integer> DFSInOrder(){
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            public Traverse(Node currentNode){
                if (currentNode.left != null){
                    new Traverse(currentNode.left);
                }
                results.add(currentNode.value);
                if (currentNode.right != null){
                    new Traverse(currentNode.right);
                }

            }
        }

        new Traverse(root);
        return results;
    }



}
