public class Factorial {

    static int stepCount = 0;

    // Iterative Factorial
    static void factIterative(int n) {
        stepCount = 0;

        int factorial = 1;

        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
            stepCount++;   // counting multiplication step
        }

        System.out.println("Iterative Factorial: " + factorial);
        System.out.println("Step Count: " + stepCount);
    }

    // Recursive Factorial
    static int factRecursive(int n) {
        stepCount++;   // counting each recursive call

        if (n <= 1)
            return 1;

        return n * factRecursive(n - 1);
    }

    public static void main(String[] args) {

        int n = 5;

        // Iterative Method
        factIterative(n);

        // Recursive Method
        stepCount = 0;
        int result = factRecursive(n);
        System.out.println("Recursive Factorial: " + result);
        System.out.println("Step Count: " + stepCount);
    }
}
