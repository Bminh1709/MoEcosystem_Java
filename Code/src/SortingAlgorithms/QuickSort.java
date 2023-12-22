package SortingAlgorithms;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[] {9,3,2,7,5};

        quickSortHelper(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void quickSortHelper(int[] arr, int start, int end) {
        if (start >= end) // 1 element left
            return;
        else {
            // Get the last element is the pivot
            int pivot = arr[end];
            int pointer = start;

            for (int i = start; i < end; i++) {
                if (arr[i] <= pivot) {
                    int tmp = arr[i];
                    arr[i] = arr[pointer];
                    arr[pointer] = tmp;
                    pointer++;
                }
            }
            arr[end] = arr[pointer];
            arr[pointer] = pivot;

            quickSortHelper(arr, 0, pointer - 1);
            quickSortHelper(arr, pointer + 1, end);
        }

    }

}
