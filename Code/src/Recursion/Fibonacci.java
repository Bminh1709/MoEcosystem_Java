package Recursion;

public class Fibonacci {

    // 0 1 1 2 3 5 8 13
    public static int[] arr = new int[100];

    public static void main(String[] args) {
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        System.out.println(finonacci(7));
    }

//    public static int finonacci(int n) {
//        if (arr[n] != 0) return arr[n];
//        else {
//            return arr[n] = finonacci(n-1) + finonacci(n-2);
//        }
//    }

    public static int finonacci(int n) {
        if (n == 1 || n == 2) return 1;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }
}
