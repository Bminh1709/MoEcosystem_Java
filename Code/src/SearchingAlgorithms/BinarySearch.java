package SearchingAlgorithms;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 10, 21, 22, 25, 45};

        // int index = binarySearchHelper(arr, 10);
        int index =  binarySearchRecursion(arr, 5, 0, arr.length - 1);

        System.out.println(index);
    }

    private static int binarySearchHelper(int[] arr, int value) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = ( start + end ) / 2;

            if (arr[mid] == value) return mid;
            else if (value < arr[mid]) end = mid - 1;
            else if (value > arr[mid]) start = mid + 1;
        }
        return -1;
    }

    private static int binarySearchRecursion(int[] arr, int value, int start, int end) {
        if (start > end) return -1;
        else {
            int mid = ( start + end ) / 2;
            if (arr[mid] == value) return mid;
            if (value < arr[mid]) return binarySearchRecursion(arr, value, start, mid - 1);
            else return binarySearchRecursion(arr, value, mid + 1, end);
        }
    }
}
