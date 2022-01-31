package ds.nodeBased;

@SuppressWarnings("unused")
public class LinkedList<E> {

    public static class Node<E> {
        E element;
        Node<E> right;

        public Node(E element) {
            this.element = element;
            this.right = null;
        }
    }

    Node<E> root;
    private int size;

    public LinkedList() {
        this.root = null;
        this.size = 0;
    }

    public LinkedList(E element) {
        if(null == element) throw new NullPointerException("Element cannot be null");
        this.root = new Node<>(element);
        this.size = 1;
    }

    public E add(E element) {
        checkNullableRoot();
        Node<E> current = getCurrentNode();
        current.right = new Node<>(element);
        this.size++;
        return element;
    }

    public E remove() {
        checkNullableRoot();
        if(this.size == 1) {
            // help gc to deallocate memory space
            this.root = null;
            this.size = 0;
        } else {
            Node<E> current = getLastButOneNode();
            // help gc to deallocate memory space
            current.right = null;
            this.size--;
        }
        return null;
    }

    public E get(int index) {
        if(index < 0) throw new IllegalArgumentException("Index cannot be negative");
        checkNullableRoot();
        return getNodeAtIndex(index).element;
    }

    private Node<E> getCurrentNode() {
        Node<E> current = this.root;
        while(null != current.right) current = current.right;
        return current;
    }

    private Node<E> getNodeAtIndex(int index) {
        Node<E> current = this.root;
        while(null != current.right && index-- > 0) current = current.right;
        return current;
    }

    private Node<E> getLastButOneNode() {
        Node<E> currentNode = this.root;
        if(1 != this.size) {
            int currentSize = this.size;
            while (currentSize-- != 0) currentNode = currentNode.right;
            return currentNode;
        } else {
            throw new IllegalStateException("cannot fetch lat but one element as his is only one element in the linked list");
        }
    }

    private void checkNullableRoot() {
        if(null == this.root) throw new NullPointerException("Root is null");
    }

}
