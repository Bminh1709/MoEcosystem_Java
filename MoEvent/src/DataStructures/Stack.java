package DataStructures;

import ADT.StackADT;

import java.util.EmptyStackException;
import java.util.Iterator;

public class Stack<E> implements StackADT<E> {
    private int size;
    private Node<E> head;
    public Stack() {
        size = 0;
        head = null;
    }
    @Override
    public void push(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.prev = head; // Update the next reference of the new node
        head = newNode; // Update the head to the new node
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        else {
            Node<E> curNode = head;
            head = head.prev;
            curNode.prev = null;
            size--;
            return curNode.data;
        }
    }

    @Override
    public E peek() {
        if (isEmpty()) throw new EmptyStackException();
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
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> curNode = head;
        while (curNode != null) {
            sb.append(curNode.data);
            if (curNode.prev != null) {
                sb.append(", ");
            }
            curNode = curNode.prev;
        }
        sb.append("]");
        return sb.toString();
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
                    throw new UnsupportedOperationException("No more elements");
                }
                E data = current.data;
                current = current.prev;
                return data;
            }
        };
    }


}
