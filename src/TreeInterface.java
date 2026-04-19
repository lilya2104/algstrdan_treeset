public interface TreeInterface<T extends Comparable<T>>  {

    void insert(T element);
    void delete(T element);
    boolean contains(T element);
    TreeInterface<T> search(T element);
    Tree.Node<T> getRoot();
    Tree.Node<T> getLeft();
    Tree.Node<T> getRight();
    T getValue();

}
