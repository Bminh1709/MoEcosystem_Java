package AdvancedAlgorithms;

import java.util.ArrayList;

public class DijkstrasAlgorithm {
    public static void main(String[] args) {
        int matrix[][] = {
                {0, 2, 0, 3},
                {0, 0, 6, 0},
                {0, 0, 0, 0},
                {0, 0, 4, 0},
        };
        int numVertices = matrix.length;
        // Control visited nodes
        boolean[] visitedNodes = new boolean[numVertices];
        // Control the distance of each node
        int[] distances = new int[numVertices];
        // Set distance for all nodes
        for (int i = 0; i < distances.length; i++) {
            if (i != 0) distances[i] = 9999;
        }

        for (int i = 0; i < numVertices - 1; i++) {
            // Find closest node
            int closestNode = findClosestNode(distances, visitedNodes);

            for (int j = 0; j < numVertices; j++) {
                if (matrix[closestNode][j] != 0 && visitedNodes[j] == false) {

                    int newDistance = distances[closestNode] + matrix[closestNode][j];

                    if (newDistance < distances[j])
                        distances[j] = newDistance;
                }
            }
        }

        displayResult(distances);

    }

    private static void displayResult(int[] distances) {
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F'};
        for (int i = 1; i < distances.length; i++) {
            System.out.print(i + ") A -> " + letters[i] + " : " + distances[i]);
            System.out.println();
        }
    }

    private static int findClosestNode(int[] distances, boolean[] visitedNodes) {
        int min = -1; // default
        for (int i = 0; i < visitedNodes.length; i++) {
            if (visitedNodes[i] == false)
                if (min == -1 || distances[i] < distances[min])
                    min = i;
        }
        visitedNodes[min] = true;
        return min;
    }
}
