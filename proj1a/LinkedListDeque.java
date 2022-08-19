public class LinkedListDeque<T> {
    private int size;
    private IntNode sentinel;

    public void addFirst(T item){
        sentinel.next = new IntNode(item,sentinel,sentinel.next);
        size += 1;
    }

    public void addLast(T item){
        sentinel.prev = new IntNode(item,sentinel.prev,sentinel);
        size += 1;
    }

    public LinkedListDeque() {
        sentinel = new IntNode(63,null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public boolean isEmpty() {
        if(this.size == 0){
            return true;
        }else{
            return false;
        }
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if(isEmpty()) return;
        IntNode p = sentinel.next;
        while(p != sentinel) {
            System.out.print(p.item);
            System.out.println(" ");
            p = p.next;
        }
    }

    public T removeFirst() {
        if(isEmpty()) return null;
        T res = (T) sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        size -= 1;
        return res;
    }

    public T removeLast() {
        if(isEmpty()) return null;
        T res = (T) sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        size -= 1;
        return res;
    }

    public T get(int index) {
        if(index >= size()) return null;
        int n = 0;
        IntNode p = sentinel.next;
        while(n!=index){
            p = p.next;
        }
        return (T)p.item;
    }

    private T getRecursive(int index) {
        if(index >= size()) return null;
        IntNode p = sentinel.next;

        return getRecursive(index, p);
    }
    public T getRecursive(int index, IntNode p) {
        if(index == 0) {
            return (T)p.item;
        } else {
            return getRecursive(index - 1, p.next);
        }
    }
}
