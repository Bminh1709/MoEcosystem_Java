package DataStructures;

import ADT.QueueADT;

import java.util.Iterator;

public class Queue<E> implements QueueADT<E> {

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
        Node<E> newNode = new Node<>(element);
        if (isEmpty())
            head = tail = newNode;
        else {
            tail.prev = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public E poll() {
        if (isEmpty()) throw new IllegalArgumentException("Queue is empty");

        Node<E> curNode = head;
        if (size == 1) {
            head = tail = null;
        }
        else {
            head = head.prev;
            curNode.prev = null;
        }
        size--;
        return curNode.data;
    }

    @Override
    public E peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is null");
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
        return new Iterator<>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No more elements in the queue");
                }
                E data = current.data;
                current = current.prev;
                return data;
            }
        };
    }
}
