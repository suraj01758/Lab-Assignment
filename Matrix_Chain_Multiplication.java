import java.util.Scanner;

public class MatrixChainMultiplication {

    static int matrixChainMultiplication(int[] p, int n) {
        int[][] dp = new int[100][100];

        // Cost is 0 when multiplying one matrix
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        // L = chain length
        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];

                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }

        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;

        // Restrict matrices < 4
        do {
            System.out.print("Enter number of matrices (<4): ");
            n = sc.nextInt();
        } while (n <= 0 || n >= 4);

        int[] p = new int[n + 1];

        System.out.println("Enter dimensions array (size " + (n + 1) + "):");
        for (int i = 0; i <= n; i++) {
            p[i] = sc.nextInt();
        }

        int result = matrixChainMultiplication(p, n + 1);

        System.out.println("Minimum multiplications = " + result);

        sc.close();
    }
}
