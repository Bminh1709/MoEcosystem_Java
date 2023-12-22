package Recursion;

public class FindPathWObstacleFourWays {
    public static void findPath(int[][] map, int row, int col) {

        if ( row == map.length && col == map[0].length - 1 ) {
            printMap(map);
            return;
        }

        if (row == map.length || col == map[0].length)
            return; // Check left and down
        if ( row == -1 || col == -1)
            return; // Check right and up

        // 1: obstacle
        // 2: tracked
        if (map[row][col] == 1 || map[row][col] == 2)
            return;

        else {
            map[row][col] = 2;
            findPath(map, row + 1, col); // down
            findPath(map, row, col + 1); // right
            findPath(map, row, col - 1); // left
            findPath(map, row - 1, col); // up

            // Reset value
            map[row][col] = 0;
        }

    }

    private static void printMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("=========================");
    }

    public static void main(String[] args) {
        int[][] map = {
                { 0, 0, 0, 1, 0, 0, 0},
                { 1, 1, 0, 1, 0, 1, 0},
                { 0, 0, 0, 0, 0, 0, 0},
                { 0, 1, 1, 1, 1, 1, 0},
                { 0, 0, 0, 0, 0, 0, 0},
        };

        findPath(map, 0, 0);
    }
}
