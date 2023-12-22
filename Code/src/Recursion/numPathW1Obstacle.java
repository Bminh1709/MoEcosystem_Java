package Recursion;

public class numPathW1Obstacle {
    public static int findPath(int[][] map, int row, int col) {
        if (row == 2 || col == 2)
            return 1;

        if (map[row][col] == 1)
            return 0;

        int left = findPath(map, row + 1, col);
        int right = findPath(map, row, col + 1);
        return left + right;
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
            { 0, 0, 0},
            { 1, 0, 0},
            { 0, 0, 0},
        };
        System.out.println(findPath(map, 0, 0));
    }
}
