import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {
    private Object[] elements;
    private int sizeList = 0;
    private static final int DEFAULT_CAPACITY = 5;
    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(T element) {
        increaseCapacity();
        elements[sizeList] = element;
        sizeList += 1;
    }

    public T get(int index) {
        if (index < 0 || index >= sizeList) return null;
        return (T) elements[index];
    }
    public void remove(int index) {
        if (index < 0 || index >= sizeList) return;
        System.arraycopy(elements, index + 1, elements, index, sizeList-index-1);
        sizeList -= 1;
        elements[sizeList] = null;
    }
    public int size() {
        return sizeList;
    }
    public void sort(Comparator<? super T> comparator) {
        for (int i = 1; i < sizeList; i++) {
            T key = (T) elements[i];
            int j = i - 1;

            while (j >= 0 && comparator.compare(key, (T) elements[j]) < 0) {
                elements[j + 1] = elements[j];
                j--;
            }
            elements[j + 1] = key;
        }
    }
    private void increaseCapacity() {
        if (sizeList == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new AL_Iterator();
    }
    private class AL_Iterator<T> implements Iterator<T> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            if (elements.length == 0) return false;
            if (current < sizeList) return true;
            return false;
        }
        @Override
        public T next() {
            if (hasNext()) {
                return (T) elements[current++];
            }
            return null;
        }
    }

    @Override
    public String toString() {
        String res = "";
        res += "[";

        for (int i = 0; i < sizeList; i++) {
            res += elements[i];
            if (i < sizeList-1) {
                res += ", ";
            }
        }
        res += "]";
        return res;
    }
}
