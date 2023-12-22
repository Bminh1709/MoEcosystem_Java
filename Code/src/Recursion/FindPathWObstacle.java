package Recursion;

public class FindPathWObstacle {
    public static void findPath(int[][] map, int row, int col) {
        if ( row == map.length && col == map.length - 1 ) {
            printMap(map);
            return;
        }

        if (row == map.length) return;
        if (col == map.length) return;

        if (map[row][col] == 1) // Obtacle
            return;
        else {
            map[row][col] = 2;
            findPath(map, row + 1, col); // down
            findPath(map, row, col + 1); // right

            // Reset value
            map[row][col] = 0;
        }
    }

    private static void printMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=========================");
    }

    public static void main(String[] args) {
        int[][] map = {
                { 0, 0, 0, 0},
                { 0, 1, 0, 0},
                { 0, 0, 0, 1},
                { 0, 0, 0, 0},
        };
        findPath(map, 0, 0);
    }
}
