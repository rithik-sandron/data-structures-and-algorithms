@SuppressWarnings("unchecked")
public interface AbstractTypes<T> {
    default T[] reverse(T[] dataType, int capacity) {
        if (dataType == null || dataType.length == 0)
            throw new IllegalArgumentException("cannot be empty");
        T[] reversed = (T[]) new Object[capacity];
        int index = dataType.length - 1;
        int newIndex = 0;
        while (index >= 0) {
            if (null != dataType[index])
                reversed[newIndex++] = dataType[index];
            index--;
        }
        return reversed;
    }
}
