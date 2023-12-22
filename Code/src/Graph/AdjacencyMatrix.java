package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AdjacencyMatrix {

    public static class Node<T> {
        T data;
        Node(T data) {
            this.data = data;
        }
    }

    public static class Graph<T> {
        ArrayList<Node<T>> nodes;
        int[][] matrix;

        Graph(int size) {
            nodes = new ArrayList<>();
            matrix = new int[size][size];
        }
        void addNode(T data) {
            Node<T> newNode = new Node<>(data);
            nodes.add(newNode);
        }
        void addEdge(int source, int destination) {
            matrix[source][destination] = 1;
        }
        boolean checkEdge(int source, int destination) {
            return matrix[source][destination] == 1;
        }
        void display() {
            System.out.print("  ");
            for(Node<T> node : nodes) {
                System.out.print(node.data + " ");
            }
            System.out.println();

            for (int i = 0; i < matrix.length; i++) {
                System.out.print(nodes.get(i).data + " ");
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }

        void DepthFirstSearch(int source) {
            boolean[] visited = new boolean[matrix.length];
            DFSHelper(source, visited);
        }
        private void DFSHelper(int source, boolean[] visited) {
            if (visited[source]) return;
            else {
                visited[source] = true;
                System.out.println(nodes.get(source).data + " is visited");
            }
            for (int i = 0; i < matrix[source].length; i++) {
                if (matrix[source][i] == 1) DFSHelper(i, visited);
            }
        }

        void BreathFirstSearch(int source) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[matrix.length];

            queue.offer(source);
            visited[source] = true;

            while (queue.size() != 0) {

                source = queue.poll();
                System.out.println(nodes.get(source).data + " is visited");

                for (int i = 0; i < matrix[source].length; i++) {
                    if (matrix[source][i] == 1 && !visited[i]) {
                        queue.offer(i);
                        visited[i] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph<Character> graph = new Graph<>(5);
        graph.addNode('A');
        graph.addNode('B');
        graph.addNode('C');
        graph.addNode('D');
        graph.addNode('E');

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 0);
        graph.addEdge(4, 2);

        graph.display();

        graph.BreathFirstSearch(0);
    }
}
