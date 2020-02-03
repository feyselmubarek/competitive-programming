package app;

import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(
                new App().closedIsland(new int[][] { { 0, 0, 1, 0, 0 }, { 0, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 } }));
    }

    public int closedIsland(int[][] grid) {
        int count = 0;
        HashSet<String> visted = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                String cord = i + " " + j;

                if (!visted.contains(cord)) {
                    visted.add(cord);

                    if (grid[i][j] == 0) {
                        if (isClosed(grid, i, j, visted)) {
                            count++;
                        }
                    }

                }
            }
        }

        return count;
    }

    public boolean isClosed(int[][] grid, int sr, int sc, HashSet<String> visted) {
        boolean top = false, left = false, right = false, down = false;

        // upper
        if (sr - 1 >= 0) {
            if (grid[sr - 1][sc] == 1) {
                top = true;
            } else {
                visted.add((sr - 1) + " " + sc);
                top = isClosed(grid, sr - 1, sc, visted);
            }
        }

        // down
        if (sr + 1 < grid.length) {
            if (grid[sr + 1][sc] == 1) {
                down = true;
            } else {
                visted.add((sr + 1) + " " + sc);
                down = isClosed(grid, sr + 1, sc, visted);
            }
        }

        // left
        if (sc - 1 >= 0) {
            if (grid[sr][sc - 1] == 1) {
                left = true;
            } else {
                visted.add(sr + " " + (sc - 1));
                left = isClosed(grid, sr, sc - 1, visted);
            }
        }

        // right
        if (sc + 1 < grid[0].length) {
            if (grid[sr][sc + 1] == 1) {
                right = true;
            } else {
                visted.add(sr + " " + (sc + 1));
                right = isClosed(grid, sr, sc + 1, visted);
            }
        }

        return top || right || down || left;
    }
}