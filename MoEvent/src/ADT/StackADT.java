package ADT;

public interface StackADT<E> extends Iterable<E> {
    void push(E element);
    E pop();
    E peek();
    int size();
    boolean isEmpty();
}
