package ds.nodeBased;

@SuppressWarnings("unused")

// insertion happens at last index
// deletions happens at start index
public class DoublyLinkedList<E> {

    public static class Node<E> {
        E element;
        Node<E> rightNode;

        public Node(E element) {
            this.element = element;
            this.rightNode = null;
        }

        public Node() {
            this.element = null;
            this.rightNode = null;
        }
    }

    Node<E> first;
    Node<E> last;
    private int size;

    public DoublyLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public DoublyLinkedList(E e) {
        elementCheck(e);
        this.first = new Node<>(e);
        this.last = this.first;
        this.size = 1;
    }

    private Node<E> getFirstNode() {
        Node<E> current = this.first;
        while(null != current.rightNode) current = current.rightNode;
        return current;
    }

    public void add(E e) {
        elementCheck(e);
        Node<E> current = getFirstNode();
        if(current == this.first) current.element = e;
        else current.rightNode = new Node<>(e);
        this.last = current;
        this.size++;
    }

    public void remove() {
        if(this.size == 1) {
            // help gc to deallocate memory space
            this.first = null;
            this.last = null;
            this.size = 0;
        } else {
            Node<E> lastButOneNode = getLast();
            // help gc to deallocate memory space
            lastButOneNode.rightNode = null;
            this.size--;
        }
    }

    public E get(int index) {
        if(index < 0) throw new IllegalArgumentException("Index cannot be negative");
        return getNodeAtIndex(index).element;
    }


    private Node<E> getNodeAtIndex(int index) {
        Node<E> current = this.first;
        while(null != current.rightNode && index-- > 0) current = current.rightNode;
        return current;
    }

    private Node<E> getLast() {
        //        Node<E> currentNode = this.rootNode;
        //        if(1 != this.size) {
        //            int currentSize = this.size;
        //            while (currentSize-- != 0) currentNode = currentNode.rightNode;
        //        }
        //        return currentNode;`

        return this.last;

    }

    private void elementCheck(E e) {
        if(null == e) throw new NullPointerException("Element is null");
    }

}
