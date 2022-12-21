package ds.common;

@SuppressWarnings("unchecked unused")
public class Array<T> extends AbstractStructure<T> implements Structure<T> {

    public Array() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public Array(T[] initial) {
        this.array = initial;
        this.size = initial.length;
        this.capacity = this.size + this.size / 2;
    }

    public Array(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("DataStructures.Array inital size cannot be " + capacity);
        this.size = 0;
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
    }

    public T peek() {
        if (size == 0)
            throw new IllegalAccessError("Stack is empty");
        return array[size - 1];
    }

    public T peekAt(int index) {
        return this.get(index);
    }

    public void push(T element) {
        this.checkMutability();
        if (null == element)
            throw new IllegalArgumentException("Element cannot be null");

        if (capacity <= size) {
            capacity += (capacity == 1) ? 1 : (capacity / 2);
            Object[] newArray = new Object[capacity];
            for (int i = 0; i < size; i++)
                newArray[i] = this.array[i];
            this.array = (T[]) newArray;
        }

        this.array[size++] = element;
    }

    public T pop() {
        this.checkMutability();
        if (this.isEmpty())
            throw new IllegalAccessError("Stack is empty");
        T popped = this.array[size - 1];
        this.array[size-- - 1] = null;
        return popped;
    }

}