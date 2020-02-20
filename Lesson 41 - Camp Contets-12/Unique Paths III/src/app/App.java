package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int uniquePathsIII(int[][] grid) {
        int initPosRow = 0;
        int initPosColumn = 0;
        int zeroCount = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == 0) {
                    zeroCount++;
                } else if (grid[row][column] == 1) {
                    initPosRow = row;
                    initPosColumn = column;
                }
            }
        }

        State state = new State(0, 0, zeroCount);
        dfs(state, grid, initPosRow, initPosColumn);

        return state.pathCount;
    }

    public void dfs(State state, int[][] grid, int row, int column) {
        if (grid[row][column] == 2) {
            if ((state.noOfZeros - 1) == state.totalZeros) {
                state.pathCount++;
            }

            return;
        }

        grid[row][column] = -2;
        state.noOfZeros++;

        // up
        if (row - 1 >= 0 && (grid[row - 1][column] == 0 || grid[row - 1][column] == 2)) {
            dfs(state, grid, row - 1, column);
        }

        // down
        if (row + 1 < grid.length && (grid[row + 1][column] == 0 || grid[row + 1][column] == 2)) {
            dfs(state, grid, row + 1, column);
        }

        // left
        if (column - 1 >= 0 && (grid[row][column - 1] == 0 || grid[row][column - 1] == 2)) {
            dfs(state, grid, row, column - 1);
        }

        // right
        if (column + 1 < grid[row].length && (grid[row][column + 1] == 0 || grid[row][column + 1] == 2)) {
            dfs(state, grid, row, column + 1);
        }

        grid[row][column] = 0;
        state.noOfZeros--;
    }
}

class State {
    public int pathCount;
    public int noOfZeros;
    public int totalZeros;

    public State(int pathCount, int noOfZeros, int totalZeros) {
        this.pathCount = pathCount;
        this.noOfZeros = noOfZeros;
        this.totalZeros = totalZeros;
    }
}