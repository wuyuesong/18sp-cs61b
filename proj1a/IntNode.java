public class IntNode<T> {
    private IntNode prev;
    private T item;
    private IntNode next;

    public IntNode(T i, IntNode p, IntNode n) {
        item = i;
        prev = p;
        next = n;
    }

    public IntNode getNext() {
        return next;
    }

    public IntNode getPrev() {
        return prev;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public void setNext(IntNode next) {
        this.next = next;
    }

    public void setPrev(IntNode prev) {
        this.prev = prev;
    }
}
