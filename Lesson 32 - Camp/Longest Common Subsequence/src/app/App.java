package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = new int[text2.length() + 1];

            if (i == 0) {
                continue;
            }

            for (int j = 1; j < dp[i].length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        int n = dp.length;

        return dp[n - 1][dp[n - 1].length - 1];
    }
}