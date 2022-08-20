public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int first;
    private int last;
    private static final int RFACTOR = 2;
    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
        first = 0;
        last = 0;
    }

    private void resize(int capacity) {
        T[] a = (T []) new Object[capacity];
        for (int i = 0; i < size(); i++) {
            a[i] = items[(first + i) % items.length];
        }
        first = 0;
        last = first + size();
        items = a;
    }

    @Override
    public void addFirst(T item) {

        first -= 1;
        if (first == -1) {
            first = items.length - 1;
        }
        items[first] = item;
        size += 1;
        if (size() == items.length) {
            resize(items.length * RFACTOR);
        }
    }

    @Override
    public void addLast(T item) {
        items[last] = item;
        last += 1;
        size += 1;
        if (size == items.length) {
            resize(items.length * RFACTOR);
        }
        last %= items.length;

    }

    @Override
    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i < size(); i++) {
            System.out.print(items[(first + i) % items.length]);
            System.out.print(" ");
            System.out.println("");
        }
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T res = (T) items[first];
        first += 1;
        first %= items.length;
        size--;
        if ((double) size / (double) items.length < 0.4) {
            resize(items.length / RFACTOR);
        }
        return res;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        last--;
        if (last == -1) {
            last = items.length - 1;
        }
        T res = (T) items[last];
        size--;
        if ((double) size / (double) items.length < 0.4) {
            resize(items.length / RFACTOR);
        }
        return res;
    }

    @Override
    public T get(int index) {
        if (index >= size()) {
            return null;
        }

        return (T) items[(index + first) % items.length];
    }


}
