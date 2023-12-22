package Queue;

import java.util.Iterator;

public class Queue<E> implements AbstractQueue<E> {
    private int size;
    private Node<E> head;
    private Node<E> tail;

    public Queue() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    @Override
    public void offer(E element) {
        Node<E> newNode = new Node<E>(element);
        if (isEmpty())
            head = tail = newNode;
        else {
            tail.previous = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        Node<E> curNode = head;
        if (size == 1) {
            head = tail = null;
        }
        else {
            head = head.previous;
            curNode.previous = null;
        }
        size--;
        return curNode.data;
    }

    @Override
    public E peek() {
        if (isEmpty())
            throw new IllegalStateException("Queue is null");
        return head.data;
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
    public Iterator<E> iterator() {
        return null;
    }
}

