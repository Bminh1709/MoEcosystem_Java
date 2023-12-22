package AdvancedAlgorithms;

public class BellmanFordAlgorithm {
    public static void main(String[] args) {
        // Define the weighted adjacency matrix representing the graph
        int matrix[][] = {
                {0, 2, 0},
                {0, 0, 3},
                {-6, 0, 0},
        };

        int numVertices = matrix.length;
        int[] distances = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            if (i != 0) distances[i] = 9999;
        }

        // Relax edges repeatedly to find the shortest paths
        for (int i = 0; i < numVertices - 1; i++) {
            for (int u = 0; u < numVertices; u++) {
                for (int v = 0; v < numVertices; v++) {
                    // Check if there is an edge between u and v, and if distance[u] is not infinity
                    if (matrix[u][v] != 0 && distances[u] != 9999) {
                        // Calculate the new distance to vertex v through u
                        int newDistance = distances[u] + matrix[u][v];

                        // Update the distance if the new distance is shorter
                        if (newDistance < distances[v]) {
                            distances[v] = newDistance;
                        }
                    }
                }
            }
        }

        // Check for negative-weight cycles
        for (int u = 0; u < numVertices; u++) {
            for (int v = 0; v < numVertices; v++) {
                // Check if there is an edge between u and v, and if distance[u] is not infinity
                if (matrix[u][v] != 0 && distances[u] != 9999) {
                    // Calculate the new distance to vertex v through u
                    int newDistance = distances[u] + matrix[u][v];
                    // If a shorter path is found, the graph contains a negative weight cycle
                    if (newDistance < distances[v]) {
                        System.out.println("Graph contains negative weight cycle");
                        return;
                    }
                }
            }
        }

        // Display the result
        displayResult(distances);
    }

    // Display the final distances from the source vertex (A) to all other vertices
    private static void displayResult(int[] distances) {
        char[] letters = {'A', 'B', 'C', 'D', 'E', 'F'};
        for (int i = 0; i < distances.length; i++) {
            System.out.print(letters[i] + ") A -> " + letters[i] + " : " + distances[i]);
            System.out.println();
        }
    }
}
