package SinglyLinkedList;

import java.util.NoSuchElementException;

public class MyLinkedList<T> implements LinkedList<T> {
    private int size;
    private Node<T> head;
    private Node<T> tail;

    public MyLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    @Override
    public void clear() {
        if (isEmpty()) throw new IllegalStateException("Linked list is empty");
        Node<T> curNode = head;
        while (curNode != null) {
            Node<T> nextNode = curNode.next;
            curNode.data = null;
            curNode.next = null;
            curNode = nextNode;
        }
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element, null);
        if (isEmpty()) head = tail = newNode;
        else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void addFirst(T element) {
        if (isEmpty()) head = tail = new Node<>(element, null);
        Node<T> newNode = new Node<>(element, head);
        head = newNode;
        size++;
    }

    @Override
    public T peekFirst() {
        if (head == null) throw new IllegalStateException("Linked list is empty");
        return head.data;
    }

    @Override
    public T peekLast() {
        if (isEmpty()) throw new IllegalStateException("Linked list is empty");
        return tail.data;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) throw new IllegalStateException("Linked list is empty");
        T removedElement = head.data;
        head = head.next;
        size--;
        return removedElement;
    }



    @Override
    public T removeLast() {
        if (isEmpty()) throw new IllegalStateException("Linked list is empty");
        else {
            T removedElement;
            if (size == 1) {
                removedElement = head.data;
                head = tail = null;
            } else {
                Node<T> curNode = head;
                while (curNode.next != tail) {
                    curNode = curNode.next;
                }
                removedElement = tail.data;
                tail = curNode;
                tail.next = null;
            }
            size--;
            return removedElement;
        }
    }

    @Override
    public boolean remove(T data) {
        if (isEmpty()) throw new IllegalStateException("The List is empty");
        if (!contains(data)) return false;
        if (head.data.equals(data)) {
            Node<T> removedNode = head;
            if (size == 1) head = tail = head.next;
            else head = head.next;
            removedNode.next = null;
        } else {
            Node<T> prevNode = null;
            Node<T> curNode = head;
            while (curNode != null) {
                if (curNode.data.equals(data)) {
                    if (curNode.equals(tail)) {
                        prevNode.next = null;
                        tail = prevNode;
                    }
                    else {
                        prevNode.next = curNode.next;
                        curNode.next = null;
                    }
                    break;
                }
                prevNode = curNode;
                curNode = curNode.next;
            }
        }
        size--;
        return true;
    }

    @Override
    public boolean contains(T element) {
        if (isEmpty()) throw new IllegalStateException("The List is empty");
        else {
            Node<T> curNode = head;
            while (curNode != null) {
                if (curNode.data.equals(element)) {
                    return true;
                }
                curNode = curNode.next;
            }
            return false;
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder text = new StringBuilder("[");
        Node<T> curNode = head;
        while (curNode.next != null) {
            text.append(curNode.data).append(", ");
            curNode = curNode.next;
        }
        text.append(curNode.data).append("]");
        return text.toString();
    }
}
