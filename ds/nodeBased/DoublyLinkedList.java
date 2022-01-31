package ds.nodeBased;

public class DoublyLinkedList<E> {

    public static class Node<E> {
        E element;
        LinkedList.Node<E> left;
        LinkedList.Node<E> right;

        public Node(E element) {
        this.element = element;
        this.left = null;
        this.right = null;
        }
    }

    Node<E> root;
    private int size;

    public DoublyLinkedList() {
        this.root = null;
        this.size = 0;
    }

    public DoublyLinkedList(E element) {
        if(null == element) throw new NullPointerException("Element cannot be null");
        this.root = new Node<>(element);
        this.size = 1;
    }

}
