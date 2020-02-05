package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().minPathSum(new int[][] { { 1, 2, 3, 4 } }));
    }

    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j != 0) {
                    // first row
                    grid[i][j] += grid[i][j - 1];
                } else if (i != 0 && j == 0) {
                    // second row
                    grid[i][j] += grid[i - 1][j];
                } else if (i != 0 && j != 0) {
                    // remaining
                    grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }

}