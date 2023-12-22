package Recursion;

public class PrintArr {
    public static void print(int index, int[] arr) {
        if (index == arr.length)
            return;

        print(index + 1, arr);
        System.out.println(arr[index]);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,5};
        print(0, arr);
    }
}
