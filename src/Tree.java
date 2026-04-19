import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tree<T extends Comparable<T>> implements TreeInterface<T> {



    public static class Node<T>{
        public T value;
        public Node<T> left;
        public Node<T> right;
        public Node(T value) {
            this.value= value;
        }
        public Node(T value, Node<T> left, Node<T> right) {
            this.value= value;
            this.left = left;
            this.right = right;
        }
    }
    private int countNode = 0;
    private Node<T> root;
    public Tree() {
        root = null;
    }
    public Tree(Node<T> root) {
        this.root = root;
    }

    public void insert(T element) {
        root = insRec(root, element);
    }
    private Node insRec(Node<T> root, T element) {
        if (root == null) {
            root = new Node<>(element);
            countNode += 1;
            return root;
        }
        else if (element.compareTo(root.value) == -1) {
            root.left = insRec(root.left, element);
        }
        else if (element.compareTo(root.value) == 1) {
            root.right = insRec(root.right, element);
        }
        return root;
    }

    public void delete(T element) {
        root = delRec(root, element);
    }
    private Node delRec(Node<T> root, T element) {
        if (root == null) { return root; }

        else if (element.compareTo(root.value) == -1) {
            root.left = delRec(root.left, element);
        }
        else if (element.compareTo(root.value) == 1) {
            root.right = delRec(root.right, element);
        }
        else {
            if (root.left == null) {
                countNode -= 1;
                return root.right;
            }
            else if (root.right == null) {
                countNode -= 1;
                return root.left;
            }

            root.value = minValue(root.right);
            root.right = delRec(root.right, root.value);
        }
        return root;
    }
    private T minValue(Node<T> root) {
        T min = root.value;
        while (root.left != null) {
            min = root.left.value;
            root = root.left;
        }
        return min;
    }

    public int sizeTree() {
        return countNode;
    }


    @Override
    public boolean contains(T element) {
        return contRec(root, element);
    }
    private boolean contRec(Node<T> root, T element) {

        if (root == null) return false;
        else if (element.compareTo(root.value) == 0) return true;
        else if (element.compareTo(root.value) == -1) {
            return contRec(root.left, element);
        }
        else if (element.compareTo(root.value) == 1) {
            return contRec(root.right, element);
        }
        else return false;
    }

    @Override
    public Tree<T> search(T element) {
        return searRec(root, element);
    }
    private Tree<T> searRec(Node<T> root, T element) {
        if (this.contains(element)) {
            if (element.compareTo(root.value) == 0) {
                return new Tree<>(root);
            }
            else if (element.compareTo(root.value) == -1) {
                return searRec(root.left, element);
            }
            else if (element.compareTo(root.value) == 1) {
                return searRec(root.right, element);
            }
        }
        return null;
    }

    public List<T> inOrder() {
        List<T> list = new ArrayList<>();

        Tree<T> treeleft = new Tree<>(root.left);
        Tree<T> treeright = new Tree<>(root.right);
        if (root.left != null) list.addAll(treeleft.inOrder());
        list.add(this.getValue());
        if (root.right != null) list.addAll(treeright.inOrder());
        return list;
    }

    @Override
    public Node<T> getRoot() {
        return root;
    }
    @Override
    public Node<T> getLeft() {
        return root.left;
    }
    @Override
    public Node<T> getRight() {
        return root.right;
    }
    @Override
    public T getValue() {
        return root.value;
    }

    public void printTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int gaps = 32;
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;

            String sp = " ";
            System.out.print(sp.repeat(gaps));
            while (globalStack.isEmpty() == false) {
                Node<T> temp = (Node) globalStack.pop();;
                if (temp != null) {
                    System.out.print(temp.value);
                    localStack.push(temp.left);
                    localStack.push(temp.right);
                    if (temp.left != null ||
                            temp.right != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("  ");
                    localStack.push(null);
                    localStack.push(null);
                }
                System.out.print(sp.repeat(gaps * 2 - 2));
            }
            System.out.println();
            gaps /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }
        System.out.println(separator);
    }

}
