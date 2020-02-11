package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().maxIncreaseKeepingSkyline(
                new int[][] { { 3, 0, 8, 4 }, { 2, 4, 5, 7 }, { 9, 2, 6, 3 }, { 0, 3, 1, 0 } }));
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] row_max = new int[grid.length];
        int[] column_max = new int[grid[0].length];

        int[][] res = new int[grid.length][];

        for (int i = 0; i < grid.length; i++) {
            int max = Integer.MIN_VALUE;

            for (int j = 0; j < grid[i].length; j++) {
                max = Math.max(max, grid[i][j]);
            }

            row_max[i] = max;
        }

        for (int i = 0; i < grid[0].length; i++) {
            int max = Integer.MIN_VALUE;

            for (int j = 0; j < grid.length; j++) {
                max = Math.max(max, grid[j][i]);
            }

            column_max[i] = max;
        }

        int totalIncreament = 0;

        for (int i = 0; i < res.length; i++) {
            res[i] = new int[grid[i].length];

            for (int j = 0; j < res[i].length; j++) {
                int newHeight = Math.min(row_max[i], column_max[j]);

                totalIncreament += (newHeight - grid[i][j]);
                res[i][j] = newHeight;
            }
        }

        return totalIncreament;
    }
}