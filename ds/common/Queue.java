package ds.common;

// Enqueue -> adding/offering to the back
// Dequeue -> removing/polling from front
@SuppressWarnings("unchecked unused")
public class Queue<T> extends AbstractStructure<T> implements Structure<T> {

    public Queue() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public Queue(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("DataStructures.Array initial size cannot be " + capacity);
        this.size = 0;
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
    }

    public T peek() {
        if (size == 0)
            throw new IllegalAccessError("DataStructures.Queue is empty");
        return this.get(0);
    }

    public void enqueue(T element) {
        this.checkMutability();
        if (null == element)
            throw new IllegalArgumentException("Element cannot be null");

        if (capacity <= size) {
            capacity += (capacity == 1) ? 1 : capacity / 2;
            Object[] newArray = new Object[capacity];
            for (int i = 0; i < size; i++)
                newArray[i] = this.array[i];
            this.array = (T[]) newArray;
        }

        this.array[size++] = element;
    }

    public T dequeue() {
        this.checkMutability();
        if (this.isEmpty())
            throw new IllegalAccessError("DataStructures.Queue is empty");
        T dequeued = this.array[0];
        for (int i = 0; i < size - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.array[size-- - 1] = null;
        return dequeued;
    }

}
