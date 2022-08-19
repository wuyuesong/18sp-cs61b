import org.hamcrest.Factory;

public class ArrayDeque <T>{
    public T[] items;
    private int size;
    private int first;
    private int last;
    private static final int RFACTOR = 2;
    public ArrayDeque(){
        items = (T []) new Object[8];
        size = 0;
        first = 0;
        last = 0;
    }

    private void resize(int capacity){
        T[] a = (T [])new Object[capacity];
        System.arraycopy(items, 0, a,0, items.length);
        items = a;
    }

    public void addFirst(T item){
        if (size() == items.length){
            resize(items.length * RFACTOR);
        }
        first -= 1;
        if(first == -1){
            first = items.length - 1;
        }
        size += 1;
    }

    public void addLast(T item){
        items[last] = item;
        last += 1;
        size += 1;
        if (size == items.length){
            resize(items.length * RFACTOR);
        }
        last %= items.length;

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
        for(int i = 0;i < size();i++){
            System.out.print(items[(first + i)% items.length]);
            System.out.print(" ");
            System.out.println("");
        }
    }

    public T removeFirst() {
        if(isEmpty()) return null;
        T res = (T) items[first];
        first += 1;
        first %= items.length;
        size--;
        return res;
    }

    public T removeLast() {
        if(isEmpty()) return null;
        T res = (T) items[last];
        last--;
        if(last == -1) {
            last = items.length - 1;
        }
        size--;
        return res;
    }

    public T get(int index) {
//        System.out.println("d " + index + " " + size());
        if(index >= size()) return null;
//        System.out.println("d1 " + first + " " + index + " ");
//        System.out.println("d2 " + (T)items[(first + index)%items.length]);
//        System.out.println("d3 " + items[0]);
        return (T)items[(index + first)%items.length];
    }

//    public T getRecursive(int index) {
//        if(index >= size()) return null;
//        IntNode p = sentinel.next;
//
//        return getRecursive(index, p);
//    }
//    public T getRecursive(int index, IntNode p) {
//        if(index == 0) {
//            return (T)p.item;
//        } else {
//            return getRecursive(index - 1, p.next);
//        }
//    }
}
