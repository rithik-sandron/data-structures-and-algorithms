package ds;

@SuppressWarnings("unchecked")
public class BinarySearchTree {

    // member variables
    private static Node root;
    private int size;
    private int height;

    public BinarySearchTree() {
        this.size = 0;
        this.height = 1;
    }

    // node class
    private class Node {

        private int element;
        private Node left;
        private Node right;
        private int size;

        public Node(int element) {
            this.element = element;
            this.size = 0;
            this.left = null;
            this.right = null;
        }
    }

    public int getSize() {
        return this.size;
    }

    public int getHeight() {
        return height;
    }

    // Start adding from root
    public Node add(int element) {
        return root = add(root, element);
    }

    // Recursive add
    private Node add(Node parent, int element) {
        if (parent == null) parent = new Node(element);
        // To avoid linear tree structure by duplicates
        else if(element == parent.element) {
            if(parent.left != null) parent.right = add(parent.right, element);
            else parent.left = add(parent.left, element);
        }
        else if (element < parent.element) parent.left = add(parent.left, element);
        else parent.right = add(parent.right, element);
        this.size++;
        if(++parent.size == 2) this.height++;
        return parent;
    }

    private void remove(Node n, int element) {
        if(n.element == element) {
            if(n.left == null && n.right == null) n = null;
            else if(n.right == null && n.left != null);
            else if(n.left == null && n.right != null);
        }
        if(n.element < element) remove(n.left, element);
        if(n.element > element) remove(n.right, element);
    }

    private String toString(Node parent) {
        return parent.element + " " + ((parent.left != null) ? parent.element+"-" + toString(parent.left) : "") + ((parent.right != null) ? parent.element+"-"+toString(parent.right) : "");
    }

    @Override
    public String toString() {
        return "DataStructures.BinarySearchTree [root=" + toString(root) + "]";
    }

}