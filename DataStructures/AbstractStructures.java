package DataStructures;

@SuppressWarnings("unchecked")
public abstract class AbstractStructures<T> implements Structures<T> {
    static final int DEFAULT_INITIAL_CAPACITY = 10;

    private boolean isMutable;
    transient T[] array;
    int capacity;
    int size;

    static final class ImmutableStructures<T> implements Structures<T> {

        transient final private T[] immutableStructure;

        ImmutableStructures(T[] immutableStructure) {
            this.immutableStructure = immutableStructure;
        }
    }

    AbstractStructures() {
        this.isMutable = true;
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    void checkMutability() {
        if(null == this.array) throw new NullPointerException("Structure is null");
        if(!this.isMutable) throw new UnsupportedOperationException("Cannot modify immutable structure");
    }

    ImmutableStructures<T> toImmutableStructure(T[] data) {
        this.isMutable = false;
        return new ImmutableStructures<>(data);
    }

    void reverseStructure() {
        if (this.array == null || this.size == 0)
            throw new IllegalArgumentException("cannot be empty");
        T[] reversed = (T[]) new Object[this.capacity];
        int index = this.size - 1;
        int newIndex = 0;
        while (index >= 0) {
            if (null != this.array[index])
                reversed[newIndex++] = this.array[index];
            index--;
        }
        this.array = reversed;
    }
}
