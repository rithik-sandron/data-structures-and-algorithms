package ds.common;

@SuppressWarnings("unchecked unused")
public abstract class AbstractStructure<T> implements Structure<T>, Iterable<T> {
    static final int DEFAULT_INITIAL_CAPACITY = 10;

    private boolean isMutable;
    transient T[] array;
    int capacity;
    int size;

    static final class ImmutableStructures<T> implements Structure<T> {
        transient final private T[] immutableStructure;
        ImmutableStructures(T[] immutableStructure) {
            this.immutableStructure = immutableStructure;
        }
    }

    AbstractStructure() {
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

    public T get(int index) {
        return this.array[index];
    }

    void checkMutability() {
        if(null == this.array) throw new NullPointerException("Structure is null");
        if(!this.isMutable) throw new UnsupportedOperationException("Cannot modify immutable structure");
    }

    public ImmutableStructures<T> toImmutableStructure() {
        this.isMutable = false;
        return new ImmutableStructures<>(array);
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            toString.append(this.array[i]);
            toString.append(", ");
        }
        return toString.substring(0, toString.length() - 2) + "]";
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<>() {
            int current = 0;

            @Override
            public boolean hasNext() {
                return array[current] != null;
            }

            @Override
            public T next() {
                return array[current++];
            }
        };
    }

}
