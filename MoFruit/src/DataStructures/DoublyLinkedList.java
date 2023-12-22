package DataStructures;

import ADT.LinkedListADT;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements LinkedListADT<T> {


    private Node<T> head;
    private Node<T> tail;
    private int size;
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
        Node<T> newNode = new Node<>(element);
        if (isEmpty())
            head = tail = newNode;
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty())
            head = tail = newNode;
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public T peekFirst() {
        return head.data;
    }

    @Override
    public T peekLast() {
        return tail.data;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) throw new IllegalStateException("List is empty");
        Node<T> removedNode = head;
        if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        removedNode.next = null;
        size--;
        return removedNode.data;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) throw new IllegalStateException("List is empty");
        Node<T> removedNode = tail;
        if (size == 1) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        removedNode.prev = null;
        size--;
        return removedNode.data;
    }

    @Override
    public T remove(T element) {
        if (isEmpty()) throw new IllegalStateException("List is empty");
        else {
            Node<T> forwardNode = head;
            Node<T> backwardNode = tail;
            Node<T> removedNode = FindRemovedElement(element, forwardNode, backwardNode);

            if (removedNode == null)
                throw new NoSuchElementException("Element is not existed!");

            Node<T> prevNode = removedNode.prev;
            Node<T> nextNode = removedNode.next;

            if (prevNode == null) head = nextNode;
            else prevNode.next = nextNode;

            if (nextNode == null) tail = prevNode;
            else nextNode.prev = prevNode;

            // Remove all links of removedNode
            removedNode.next = null;
            removedNode.prev = null;

            size--;
            return removedNode.data;
        }
    }

    private Node<T> FindRemovedElement(T element, Node<T> forwardNode, Node<T> backwardNode) {
        while (forwardNode != null || backwardNode != null) {
            if (forwardNode != null && forwardNode.data.equals(element)) {
                return forwardNode;
            }

            if (backwardNode != null && backwardNode.data.equals(element)) {
                return backwardNode;
            }

            forwardNode = forwardNode != null ? forwardNode.next : null;
            backwardNode = backwardNode != null ? backwardNode.prev : null;
        }
        return null;
    }

    @Override
    public T removeAt(int index) {
        if (isEmpty()) throw new IllegalStateException("List is empty");
        else if (index < 0 || index > size - 1) throw new NullPointerException("Element is not existed");
        return RemoveAtHelper(index);
    }

    private T RemoveAtHelper(int index) {
        int midIndex = size / 2;
        int curIndex;
        Node<T> curNode;

        // Run from head
        if (index <= midIndex)
        {
            curIndex = 0;
            curNode = head;
            while (curIndex < index) {
                curNode = curNode.next;
                curIndex++;
            }
        }
        // Run from tail
        else {
            curIndex = size - 1;
            curNode = tail;
            while (curIndex > index) {
                curNode = curNode.prev;
                curIndex--;
            }
        }
        // Get the previous and next Nodes of the removed Node
        Node<T> prevNode = curNode.prev;
        Node<T> nextNode = curNode.next;

        if (prevNode != null) prevNode.next = nextNode;
        else head = nextNode; // If removedNode is head

        if (nextNode != null) nextNode.prev = prevNode;
        else tail = prevNode; // If removedNode is tail

        // Remove the link of removed Node to other nodes
        curNode.next = null;
        curNode.prev = null;

        size--;
        return curNode.data;
    }

    @Override
    public boolean contains(T element) {
        if (isEmpty()) throw new IllegalStateException("List is empty");

        Node<T> forwardNode = head;
        Node<T> backwardNode = tail;

        while (forwardNode != null || backwardNode != null) {

            if (forwardNode != null && forwardNode.data.equals(element))
                return true;

            if (backwardNode != null && backwardNode.data.equals(element))
                return true;

            forwardNode = forwardNode != null ? forwardNode.next : null;
            backwardNode = backwardNode != null ? backwardNode.prev : null;
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> curNode = head;
        while (curNode != null) {
            sb.append(curNode.data);
            if (curNode.next != null) {
                sb.append(", ");
            }
            curNode = curNode.next;
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
