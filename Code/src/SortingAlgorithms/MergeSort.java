package SortingAlgorithms;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[] {7,5,3,2,1,4, 10};

        mergeSortHelper(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void mergeSortHelper(int[] arr) {
        if (arr.length <= 1) return;
        
        int mid = arr.length / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[arr.length - mid];

        int i = 0;
        int j = 0;

        for (; i < arr.length; i++) {
            if (i < mid) {
                leftArr[i] = arr[i];
            } else {
                rightArr[j] = arr[i];
                j++;
            }
        }
        mergeSortHelper(leftArr);
        mergeSortHelper(rightArr);

        // Until there is 1 element left
        // Start merging the left and the right arrays into one
        mergeArr(arr, leftArr, rightArr);
        
    }

    private static void mergeArr(int[] arr, int[] leftArr, int[] rightArr) {
        int leftLength = leftArr.length;
        int rightLength = arr.length - leftLength;

        int i = 0;
        int l = 0;
        int r = 0;

        // If either array has no elements left
        while (l < leftLength && r < rightLength) {
            if (leftArr[l] < rightArr[r]) {
                arr[i] = leftArr[l];
                i++;
                l++;
            } else {
                arr[i] = rightArr[r];
                i++;
                r++;
            }
        }

        // If left array stil contains elements
        while (l < leftLength) {
            arr[i] = leftArr[l];
            i++;
            l++;
        }

        // If right array stil contains elements
        while (r < rightLength) {
            arr[i] = rightArr[r];
            i++;
            r++;
        }

    }


}
