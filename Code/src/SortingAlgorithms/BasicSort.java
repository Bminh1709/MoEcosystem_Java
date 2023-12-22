package SortingAlgorithms;

public class BasicSort {

    public static void main(String[] args) {
        int[] arr = {3 , 4 , 5};
        insertionSort(arr);
    }

    public static int[] selectionSort(int[] arr) {
        // Step 1: Find the minimum value
        // Step 2: Swap current with the that one
        // Step 3: Increase current pointer until the last element
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
        return arr;
    }

    public static int[] insertionSort(int[] arr) {
        /* for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                int min = i;
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[min] < arr[j]) {
                        int tmp = arr[min];
                        arr[min] = arr[j];
                        arr[j] = tmp;
                        min = j;
                    } else break;
                }
            }
        } */

        // Step 1: Save current value
        // Step 2: Swap if previous value > current value
        // Step 3: Set current Index with current value
        for (int i = 1; i < arr.length; i++) {
            int curValue = arr[i];
            int prevIndex = i - 1;

            while (prevIndex >= 0 && arr[prevIndex] > curValue) {
                arr[prevIndex + 1] = arr[prevIndex];
                prevIndex--;
            }
            arr[prevIndex + 1] = curValue;
        }

        return arr;
    }
    
    public static int[] bubbleSort(int[] arr) {
        // the biggest value will be in the end after a loop
        // Then reduce the length to not loop to that end value
        int arrLength = arr.length;

        // arrLength == 1 means there is only 1 element left
        // All bigger elements have been on the right
        while (arrLength > 1) {
            for (int i = 0; i < arrLength - 1; i++) {
                if (arr[i] > arr[i+1]) {
                    int biggerValue = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = biggerValue;
                }
            }
            arrLength--;
        }

        return arr;
    }

}
