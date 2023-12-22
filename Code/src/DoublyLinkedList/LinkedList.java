package DoublyLinkedList;

import javax.management.InvalidAttributeValueException;

public interface LinkedList<T> {
    int size();
    boolean isEmpty();
    void add(T element);
    void addFirst(T element);
    T peekFirst();
    T peekLast();
    T removeFirst();
    T removeLast();
    T remove(T element);
    T removeAt(int index);
    boolean contains(T element);
}
