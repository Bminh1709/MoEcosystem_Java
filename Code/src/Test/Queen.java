package Test;

public class Queen {

    public static void main(String[] args) {
        int[] arr = new int[5];
        int row = 0;
        placeQueens(arr, row);
    }

    private static void placeQueens(int[] arr, int row) {
        // Base condition
        if (row == arr.length) {
            showArr(arr);
            return;
        }

        for (int curCol = 0; curCol < arr.length; curCol++) {
            boolean isValidPos = true;

            for (int i = 0; i < row; i++) {
                if (curCol == arr[i] || curCol == arr[i]+row-i || curCol == arr[i]-row+i)
                    isValidPos = false;
            }

            if (isValidPos) {
                arr[row] = curCol;
                placeQueens(arr, row + 1);
            }
        }
    }

    private static void showArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
