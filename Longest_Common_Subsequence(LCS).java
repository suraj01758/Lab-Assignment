import java.util.Scanner;

public class LCS {

    static int lcs(String X, String Y, int m, int n) {
        int[][] dp = new int[100][100];

        // Initialize
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
            }
        }

        // Build DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String X, Y;

        // Restrict input length < 4
        do {
            System.out.print("Enter first string (length < 4): ");
            X = sc.next();
        } while (X.length() >= 4);

        do {
            System.out.print("Enter second string (length < 4): ");
            Y = sc.next();
        } while (Y.length() >= 4);

        int m = X.length();
        int n = Y.length();

        System.out.println("Length of LCS = " + lcs(X, Y, m, n));

        sc.close();
    }
}
