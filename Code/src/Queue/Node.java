package Queue;

public class Node<E> {
    E data;
    Node<E> previous;

    public Node(E data) {
        this.data = data;
    }
}
