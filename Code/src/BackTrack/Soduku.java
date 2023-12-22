package BackTrack;

public class Soduku {
    private final int maxRow = 8;
    private final int maxCol = 8;

    public boolean backTrack(int board[][], int row, int col)
    {
        if (row == maxRow && col == maxCol)
            return true;
        else if (col == maxCol + 1) {
            row++;
            col = 0;
        }
        if (board[row][col] > 0)
            return backTrack(board, row, col + 1);

        for (int number = 1; number <= 9 ; number++) {
            if (checkValidPosition(board, row, col, number)) {
                board[row][col] = number;
                if(backTrack(board, row, col + 1)){
                    return true;
                }
            }
            board[row][col] = 0;
        }
        return false;
    }

    private boolean checkValidPosition(int[][] board, int row, int col, int number) {
        // Check valid number horizontally
        for (int curCol = 0; curCol <= maxRow; curCol++)
            if (board[row][curCol] == number) return false;

        // Check valid number Vertically
        for (int curRow = 0; curRow <= maxRow; curRow++)
            if (board[curRow][col] == number) return false;

        // Check valid number in current 3x3 square
        int startRowPosition = row - row % 3;
        int startColPosition = col - col % 3;

        for (int curRow = startRowPosition; curRow <= 2; curRow++) {
            for (int curCol = startColPosition; curCol <= 2; curCol++) {
                if (board[curRow][curCol] == number)
                    return false;
            }
        }
        return true;
    }

    void showResult(int[][] board) {
        for (int row = 0; row <= maxRow; row++) {
            for (int col = 0; col <= maxCol; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

}
