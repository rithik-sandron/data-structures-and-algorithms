package ds.common;


public final class Algorithms {

    // calculates the time complexity of the algorithms
    public void calculateOmegaN() {
        //TODO: common steps to calculate O
    }

    //  O(n) complexity
    public <E> void reverse(AbstractStructure<E> s) {
        if (s== null || s.size == 0)
            throw new IllegalArgumentException("cannot be empty");
        E[] reversed = (E[]) new Object[s.capacity];
        int index = s.size - 1;
        int newIndex = 0;
        while (index >= 0) {
            if (null != s.get(index))
                reversed[newIndex++] = s.get(index);
            index--;
        }
        s.array = reversed;
    }

    /*
    O(log n) complexity
    logarithmic complexity. EX: log2 (1024) = 10
    it takes 10 attempts to fins a number between 0 and 1024
    */
    public <E extends Comparable<E>> int binarySearch(Array<E> data, E e) {
        int start = 0;
        int end = data.size() - 1;
        int mid = (end -start) / 2;
        byte match;

        while(start <= end) {
            if ((match = (byte) e.compareTo(data.peekAt(mid))) == 0) return mid;
            else if (match == -1) end = mid - 1;
            else if (match == 1) start = mid + 1;
        }
        return -1;
    }
}