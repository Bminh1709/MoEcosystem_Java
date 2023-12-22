package Recursion;

public class Queen {

    public static void arrangeQueen(int[] arr, int row) {
        if (row == 4)
            printArr(arr);
        for (int curCol = 0; curCol < arr.length; curCol++) {
            boolean checkValidPosition = true;
            for (int i = 0; i < row; i++) {
                if (curCol == arr[i] || curCol == arr[i]+row-i || curCol == arr[i]-row+i)
                    checkValidPosition = false;
            }
            if (checkValidPosition) {
                arr[row] = curCol;
                arrangeQueen(arr, row + 1);
            }
        }
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int size = 4;
        int[] arr = new int[size];
        arrangeQueen(arr, 0);
    }

}
