public class IntNode<T> {
    public IntNode prev;
    public T item;
    public IntNode next;

    public IntNode(T i, IntNode p, IntNode n) {
        item = i;
        prev = p;
        next = n;
    }
}
