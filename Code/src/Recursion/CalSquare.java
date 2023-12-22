package Recursion;

public class CalSquare {

    // exponent : số mũ
    // a^n = a^n-1 * a
    public static int calSquare(int num, int exponent) {
        if (exponent == 1)
            return num;
        int result = calSquare(num, exponent - 1) * num;
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Result is: " + calSquare(2, 3));
    }
}
