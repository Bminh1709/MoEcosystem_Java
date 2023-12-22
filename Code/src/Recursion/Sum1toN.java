package Recursion;

public class Sum1toN {
    public static int calSum(int n) {
        if (n == 1) return 1;
        int result = n + calSum(n-1);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Sum is: " + calSum(5));
    }
}
