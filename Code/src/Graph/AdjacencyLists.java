package Graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class AdjacencyLists {

    public static class Node<T> {
        T data;
        Node(T data) {
            this.data = data;
        }
    }

    public static class Graph<T> {
        ArrayList<LinkedList<Node>> alist;
        Graph() {
            alist = new ArrayList<>();
        }
        void addNode(T data) {
            LinkedList<Node> curList = new LinkedList<>();
            curList.add(new Node<>(data));
            alist.add(curList);
        }
        void addEdge(int source, int destination) {
            LinkedList<Node> curList = alist.get(source);
            Node<T> node = alist.get(destination).get(0);
            curList.add(node);
        }
        boolean checkEdge(int source, int destination) {
            LinkedList<Node> curList = alist.get(source);
            Node<T> node = alist.get(destination).get(0);

            for(Node curNode : curList) {
                if (curNode == node)
                    return true;
            }
            return false;
        }
        void display() {
            for(LinkedList<Node> curList : alist) {
                for(Node node : curList) {
                    System.out.print(node.data + " -> ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 2);

        graph.display();
    }
}
