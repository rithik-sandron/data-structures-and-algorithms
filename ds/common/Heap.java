package ds.common;

import java.util.Arrays;

@SuppressWarnings("unchecked unused")
public class Heap<T extends Comparable<T>> extends AbstractStructures<T> implements Structures<T> {
    private byte heapInvariant;
    // private transient Integer[] heapIndex;

    public byte getHeapInvariant() {
        return heapInvariant;
    }

    public Heap() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public Heap(byte invariant) {
        checkHeapVariant(invariant);
        heapInvariant = invariant;
        this.array = (T[]) new Integer[DEFAULT_INITIAL_CAPACITY];
        this.capacity = DEFAULT_INITIAL_CAPACITY;
        this.size = 0;
    }

    public Heap(int initialCapacity) {
        heapInvariant = 1;
        this.array = (T[]) new Integer[initialCapacity];
        this.size = 0;
        this.capacity = initialCapacity;
    }

    public Heap(byte invariant, int initialCapacity) {
        checkHeapVariant(invariant);
        heapInvariant = invariant;
        this.array = (T[]) new Integer[initialCapacity];
        this.size = 0;
        this.capacity = initialCapacity;
    }

    public boolean isMinHeap() {
        return heapInvariant == -1;
    }

    public boolean isMaxHeap() {
        return heapInvariant == 1;
    }

    public void add(T element) {
        this.checkMutability();
        if (null == element)
            throw new IllegalArgumentException("Element cannot be null");

        this.array[size] = element;
        if (size != 0) {
            int bubbleIndex = size;
            int parent = getParentIndex(bubbleIndex);
            while (this.array[parent].compareTo(this.array[bubbleIndex]) == heapInvariant) {
                bubble(parent, bubbleIndex);
                bubbleIndex = parent;
                parent = getParentIndex(bubbleIndex);
            }
        }
        size++;
    }

    public void remove() {
        this.checkMutability();
        int parent = 0;
        this.array[parent] = this.array[size - 1];
        this.array[size - 1] = null;
        int bubbleIndex = parent;

        int child = getChildIndex(parent);
        while (this.array[bubbleIndex].compareTo(this.array[child]) == heapInvariant) {
            bubble(bubbleIndex, child);
            bubbleIndex = child;
            child = getChildIndex(bubbleIndex);
        }
        size--;
    }

    public ImmutableStructures<T> toImmutableStructure() {
        this.checkMutability();
        return this.toImmutableStructure(this.array);
    }

    private int getParentIndex(int child) {
        return child == 0 ? 0 : (child % 2 != 0) ? (child - 1) / 2 : (child - 2) / 2;
    }

    private int getChildIndex(int parent) {
        int left = (2 * parent) + 1;
        int right = (2 * parent) + 2;
        int total = size - 1;
        return left < total && right < total ? this.array[left].compareTo(this.array[right]) == heapInvariant ? right : left
                : left < total ? left : parent;
    }

    private void bubble(int parent, int child) {
        this.checkMutability();
        T parentTemp = this.array[parent];
        this.array[parent] = this.array[child];
        this.array[child] = parentTemp;
    }

    private void checkHeapVariant(byte invariant) {
        if (invariant != 1 || invariant != -1)
            throw new IllegalArgumentException("Value of invariant can only be -1 or 1");
    }

    @Override
    public String toString() {
        return "MinHeap [heap=" + Arrays.deepToString(this.array) + "]";
    }

}
