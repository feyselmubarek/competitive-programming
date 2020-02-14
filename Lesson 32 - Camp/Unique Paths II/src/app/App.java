package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length + 1][];

        for (int row = 0; row < dp.length; row++) {
            dp[row] = new int[obstacleGrid[0].length + 1];

            if (row == 0) {
                continue;
            }

            for (int column = 1; column < dp[row].length; column++) {
                int val = 0;

                if (obstacleGrid[row - 1][column - 1] == 0) {
                    if (row == 1 && column == 1) {
                        val = 1;
                    } else {
                        val = dp[row][column - 1] + dp[row - 1][column];
                    }
                }

                dp[row][column] = val;
            }
        }

        int n = dp.length;

        return dp[n - 1][dp[n - 1].length - 1];
    }
}