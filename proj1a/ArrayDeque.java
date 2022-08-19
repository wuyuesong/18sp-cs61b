import org.hamcrest.Factory;

public class ArrayDeque <T>{
    private T[] list;
    private int size;
    private int first;
    private int last;
    private static final int RFACTOR = 2;
    public ArrayDeque(){
        list = (T []) new Object[8];
        size = 0;
        first = 0;
        last = 0;
    }

    private void resize(int capacity){
        T[] a = (T [])new Object[capacity];
        System.arraycopy(list, 0, a,0, size);
        list = a;
    }

    public void addFirst(T item){
        if (size() == list.length){
            resize(list.length * RFACTOR);
        }
        first -= 1;
        if(first == -1){
            first = list.length - 1;
        }
        size += 1;
    }

    public void addLast(T item){
        if (size == list.length){
            resize(list.length * RFACTOR);
        }
        list[last] = item;
        last += 1;
        last %= list.length;
        size += 1;
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
            System.out.print(list[(first + i)% list.length]);
            System.out.println(" ");
        }
    }

    public T removeFirst() {
        if(isEmpty()) return null;
        T res = (T) list[first];
        first += 1;
        first %= list.length;
        size--;
        return res;
    }

    public T removeLast() {
        if(isEmpty()) return null;
        T res = (T) list[last];
        last--;
        if(last == -1) {
            last = list.length - 1;
        }
        size--;
        return res;
    }

    public T get(int index) {
        if(index >= size()) return null;
        return (T)list[(index + first)%list.length];
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
