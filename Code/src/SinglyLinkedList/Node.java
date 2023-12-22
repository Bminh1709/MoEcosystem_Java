package SinglyLinkedList;

public class Node<T> {
    T data;
    Node<T> next = null;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }
}
