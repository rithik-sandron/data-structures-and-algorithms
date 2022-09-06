package ds.nodeBased;

@SuppressWarnings("unused")

// insertion happens at last index
// deletions happens at start index
public class LinkedList<E> {

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

    public LinkedList() {
        this.last = null;
        this.first = null;
        this.size = 0;
    }

    public LinkedList(E e) {
        elementCheck(e);
        this.last = new Node<>(e);
        this.first = this.last;
        this.size = 1;
    }


    public void add(E e) {
        elementCheck(e);
        Node<E> current = this.last;
        if(null == this.last) {
            this.last = new Node<>(e);
            this.first = this.last;
        }
        else {
            Node<E> newNode = new Node<>(e);
            this.last.rightNode = newNode;
            this.last = newNode;
        }
        this.size++;
    }

    public void remove() {
        if(this.size == 1) {
            // help gc to deallocate memory space
            this.first = null;
            this.last = null;
            this.size = 0;
        } else {
            this.first = this.first.rightNode;
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
        return this.last;
    }

    private void elementCheck(E e) {
        if(null == e) throw new NullPointerException("Element is null");
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder("[");
        Node<E> next = this.first;
        for (int i = this.size; i > 0; i--) {
            toString.append(next.element);
            next = next.rightNode;
            toString.append(", ");
        }
        return toString.substring(0, toString.length() - 2) + "]";
    }

}
