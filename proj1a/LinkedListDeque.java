public class LinkedListDeque<T> {
    private int size;
    private IntNode sentinel;

    public void addFirst(T item) {
        sentinel.setNext(new IntNode(item, sentinel, sentinel.getNext()));
        sentinel.getNext().getNext().setPrev(sentinel.getNext());
        size += 1;
    }

    public void addLast(T item) {
        sentinel.setPrev(new IntNode(item, sentinel.getPrev(), sentinel));
        sentinel.getPrev().getPrev().setNext(sentinel.getPrev());
        size += 1;
    }

    public LinkedListDeque() {
        sentinel = new IntNode(63, null, null);
        sentinel.setPrev(sentinel);
        sentinel.setNext(sentinel);
        size = 0;
    }

    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (isEmpty()) {
            return;
        }
        IntNode p = sentinel.getNext();
        while (p != sentinel) {
            System.out.print(p.getItem());
            System.out.print(" ");
            p = p.getNext();
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T res = (T) sentinel.getNext().getItem();
        sentinel.getNext().getNext().setPrev(sentinel);
        sentinel.setNext(sentinel.getNext().getNext());
        size -= 1;
        return res;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T res = (T) sentinel.getPrev().getItem();
        sentinel.getPrev().getPrev().setNext(sentinel);
        sentinel.setPrev(sentinel.getPrev().getPrev());
        size -= 1;
        return res;
    }

    public T get(int index) {
        if (index >= size()) {
            return null;
        }
        int n = 0;
        IntNode p = sentinel.getNext();
        while (n != index) {
            p = p.getNext();
            n += 1;
        }
        return (T) p.getItem();
    }

    public T getRecursive(int index) {
        if (index >= size()) {
            return null;
        }
        IntNode p = sentinel.getNext();

        return getRecursive(index, p);
    }
    private T getRecursive(int index, IntNode p) {
        if (index == 0) {
            return (T) p.getItem();
        } else {
            return getRecursive(index - 1, p.getNext());
        }
    }
}
