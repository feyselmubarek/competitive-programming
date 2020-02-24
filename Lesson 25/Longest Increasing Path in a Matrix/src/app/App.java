package app;

import java.util.HashMap;
import java.util.Objects;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int longestIncreasingPath(int[][] matrix) {
        int maxLength = 0;
        HashMap<State, Integer> memo = new HashMap<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                maxLength = Math.max(maxLength, getIncMaxPath(row, column, memo, matrix));
            }
        }

        return maxLength;
    }

    public int getIncMaxPath(int row, int column, HashMap<State, Integer> memo, int[][] matrix) {
        int maxCount = 0;
        int matLen = matrix.length;
        int matRowLen = matrix[matLen - 1].length;
        int currentVal = matrix[row][column];

        State curr = new State(row, column);

        if (!memo.containsKey(curr)) {
            // up
            if (row - 1 >= 0 && matrix[row - 1][column] > currentVal) {
                maxCount = Math.max(maxCount, getIncMaxPath(row - 1, column, memo, matrix));
            }

            // down
            if (row + 1 < matLen && matrix[row + 1][column] > currentVal) {
                maxCount = Math.max(maxCount, getIncMaxPath(row + 1, column, memo, matrix));
            }

            // left
            if (column - 1 >= 0 && matrix[row][column - 1] > currentVal) {
                maxCount = Math.max(maxCount, getIncMaxPath(row, column - 1, memo, matrix));
            }

            // right
            if (column + 1 < matRowLen && matrix[row][column + 1] > currentVal) {
                maxCount = Math.max(maxCount, getIncMaxPath(row, column + 1, memo, matrix));
            }

            memo.put(curr, maxCount + 1);
        }

        return memo.get(curr);
    }
}

class State {
    int row;
    int column;

    public State(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof State) {
            State otherState = (State) obj;

            return this.row == otherState.row && this.column == otherState.column;
        }

        return false;
    }
}