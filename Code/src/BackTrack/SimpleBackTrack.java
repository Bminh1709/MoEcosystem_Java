package BackTrack;

public class SimpleBackTrack {
    private static int n = 3;
    private static Integer[] factorial = new Integer[n + 1];

    static void Factorial(int i) {
        for (int j = 0; j <= 1; j++) {
            factorial[i] = j;
            if (i == n) {
                showFactorial();
            } else {
                Factorial(i + 1);
            }
        }
    }

    private static void showFactorial() {
        for (int i = 1; i <= n; i++) {
            System.out.print(factorial[i]);
        }
        System.out.println(); // Add a newline after each binary string
    }

    public static void main(String[] args) {
        Factorial(3);
    }
}
