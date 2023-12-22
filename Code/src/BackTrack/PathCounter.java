package BackTrack;

public class PathCounter {

    int countWays = 0;

    void explorePaths(int row, int col) {
        // Base case: reached the destination
        if (row == 2 && col == 2) {
            countWays++;
            return;
        }

        // Recursive cases: explore right and down paths if within bounds
        if (col < 2) {
            explorePaths(row, col + 1); // Move right
        }

        if (row < 2) {
            explorePaths(row + 1, col); // Move down
        }
    }

    public static void main(String[] args) {
        PathCounter pathCounter = new PathCounter();
        pathCounter.explorePaths(0, 0);
        System.out.println("Number of ways: " + pathCounter.countWays);
    }
}

