package Recursion;

public class FindPathSquare {
    public static int calNumOfPaths(int row, int col) {
        if (row == 1 || col == 1) return 1; // Base case

        // Common pattern
        // (row, col) = (row-1, col) + (row, col-1)
        int smallerLeftSquare = calNumOfPaths(row - 1, col);
        int smallerTopSquare = calNumOfPaths(row, col - 1);

        return smallerLeftSquare + smallerTopSquare;
    }

    public static void main(String[] args) {
        System.out.println("Number of paths is: " + calNumOfPaths(3,3));
    }
}
