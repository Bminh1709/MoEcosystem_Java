package SinglyLinkedList;

public interface LinkedList<T> {
    void clear();
    int size();
    boolean isEmpty();
    void add(T element);
    void addFirst(T element);
    T peekFirst();
    T peekLast();
    T removeFirst();
    T removeLast();
    boolean remove(T data);
    boolean contains(T element);
}
