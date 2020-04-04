package app;

import java.util.HashMap;
import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().largestIsland(new int[][] { { 1, 1 }, { 1, 1 } }));
    }

    public int largestIsland(int[][] grid) {
        int[][] directionMatrix = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        HashMap<Integer, Integer> map = new HashMap<>();

        int maxCount = mapConnected(grid, map);

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == 0) {
                    HashSet<Integer> seen = new HashSet<>();
                    int count = 1;

                    for (int[] direction : directionMatrix) {
                        int newRow = direction[0] + row;
                        int newColumn = direction[1] + column;

                        if (newRow < 0 || newRow >= grid.length || newColumn < 0 || newColumn >= grid[row].length
                                || grid[newRow][newColumn] == 0 || seen.contains(grid[newRow][newColumn])) {
                            continue;
                        }

                        count += map.get(grid[newRow][newColumn]);
                        seen.add(grid[newRow][newColumn]);
                    }

                    maxCount = Math.max(maxCount, count);
                }
            }
        }

        return maxCount;
    }

    public int mapConnected(int[][] grid, HashMap<Integer, Integer> map) {
        int key = 2;
        int maxCount = 1;

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == 1) {
                    int count = dfs(grid, row, column, key);
                    map.put(key, count);

                    maxCount = Math.max(maxCount, count);
                    key++;
                }
            }
        }

        return maxCount;
    }

    public int dfs(int[][] grid, int row, int column, int key) {
        int[][] directionMatrix = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        grid[row][column] = key;
        int count = 1;

        for (int[] direction : directionMatrix) {
            int newRow = direction[0] + row;
            int newColumn = direction[1] + column;

            if (newRow < 0 || newRow >= grid.length || newColumn < 0 || newColumn >= grid[row].length
                    || grid[newRow][newColumn] != 1) {
                continue;
            }

            count += dfs(grid, newRow, newColumn, key);
        }

        return count;
    }
}