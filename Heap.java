import java.util.Arrays;

@SuppressWarnings("unchecked")
public class Heap<T extends Comparable<T>> {
    private transient static final int INITIAL_CAPACITY = 10;
    private static long heapInvariant;
    private transient T[] heap;
    // private transient Integer[] heapIndex;
    
    private int size;

    public static long getHeapInvariant() {
        return heapInvariant;
    }

    public int getSize() {
        return size;
    }

    public Heap() {
        this(INITIAL_CAPACITY);
    }

    public Heap(boolean invariant) {
        heapInvariant = invariant ? 1 : -1;
        this.heap = (T[]) new Integer[INITIAL_CAPACITY];
        this.size = 0;
    }

    public Heap(int initialCapaity) {
        heapInvariant = 1;
        this.heap = (T[]) new Integer[initialCapaity];
        this.size = 0;
    }

    public Heap(byte invariant, int initialCapacity) {
        if (invariant != 1 || invariant != -1)
            throw new IllegalArgumentException("Value of invariant can only be -1 or 1");
        heapInvariant = invariant;
        this.heap = (T[]) new Integer[initialCapacity];
        this.size = 0;
    }

    public boolean isMinHeap() {
        return heapInvariant == -1;
    }

    public boolean isMaxHeap() {
        return heapInvariant == 1;
    }

    public void add(T element) {
        if (null == element)
            throw new IllegalArgumentException("Element cannot be null");

        heap[size] = element;
        if (size != 0) {
            int bubbleIndex = size;
            int parent = getParentIndex(bubbleIndex);
            while (heap[parent].compareTo(heap[bubbleIndex]) == heapInvariant) {
                bubble(parent, bubbleIndex);
                bubbleIndex = parent;
                parent = getParentIndex(bubbleIndex);
            }
        }
        size++;
    }

    public void remove() {
        int parent = 0;
        heap[parent] = heap[size - 1];
        heap[size - 1] = null;
        int bubbleIndex = parent;

        int child = getChildIndex(parent);
        while (heap[bubbleIndex].compareTo(heap[child]) == heapInvariant) {
            bubble(bubbleIndex, child);
            bubbleIndex = child;
            child = getChildIndex(bubbleIndex);
        }
        size--;
    }

    private int getParentIndex(int child) {
        return child == 0 ? 0 : (child % 2 != 0) ? (child - 1) / 2 : (child - 2) / 2;
    }

    private int getChildIndex(int parent) {
        int left = (2 * parent) + 1;
        int right = (2 * parent) + 2;
        int total = size - 1;
        return left < total && right < total ? heap[left].compareTo(heap[right]) == heapInvariant ? right : left
                : left < total ? left : parent;
    }

    private void bubble(int parent, int child) {
        T parentTemp = heap[parent];
        heap[parent] = heap[child];
        heap[child] = parentTemp;
    }

    @Override
    public String toString() {
        return "MinHeap [heap=" + Arrays.deepToString(heap) + "]";
    }

}
