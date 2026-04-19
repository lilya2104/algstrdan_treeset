import java.util.Iterator;

public class TreeSet<T extends Comparable<T>> implements Iterable<T> {
    private Tree<T> tree;
    private MyArrayList<T> array;
    private int size = 0;
    public TreeSet() {
        tree = new Tree<T>();
    }

    public boolean add(T elem) {
        if (!this.contains(elem)) {
            tree.insert(elem);
            size += 1;
            this.toArray();
            return true;
        }
        return false;
    }
    public boolean remove(T elem) {
        if (this.contains(elem)) {
            tree.delete(elem);
            size -= 1;
            this.toArray();
            return true;
        }
        return false;
    }
    public int size() {
        return size;
    }
    public T get(int index) {
        this.toArray();
        return array.get(index);
    }

    private MyArrayList<T> toArray() {
        if (size == 0) return null;

        array = new MyArrayList<>();
        for (T elem : tree.inOrder()) {
            array.add(elem);
        }
        return array;
    }
    public T first() {
        this.toArray();
        if (array == null) return null;
        return array.get(0);
    }
    public T last() {
        this.toArray();
        if (array == null) return null;
        return array.get(array.size()-1);
    }
    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }
    public boolean contains(T elem) {
        this.toArray();
        if (array == null) return false;
        for (T ar : array) {
            if (ar.compareTo(elem) == 0) return true;
        }
        return false;
    }

    public void clear() {
        size = 0;
        for (int i = 0; i < array.size(); i++) {
            array.remove(i);
        }
    }

    @Override
    public Iterator<T> iterator() {
        this.toArray();
        return new TS_Iterator();
    }
    private class TS_Iterator<T> implements Iterator<T> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            if (current < size) return true;
            return false;
        }
        @Override
        public T next() {
            if (hasNext()) {
                return (T) array.get(current++);
            }
            return null;
        }
    }


    @Override
    public String toString() {
        this.toArray();
        String res = "";
        if (size != 0) {
            for (T ar : array) {
                res += ar + " ";
            }
        }
        return res;
    }
}
