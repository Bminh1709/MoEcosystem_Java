package Recursion;

public class showBit {
    public static void showBitNe(int[] arr, int index) {
        if (index == arr.length) {
            printArr(arr);
            return;
        }
        for (int i = 0; i <= 1; i++) {
            arr[index] = i;
            showBitNe(arr, index + 1);
            // arr[index] = 0;
        }
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = new int[4];
        showBitNe(arr, 0);
    }
}
