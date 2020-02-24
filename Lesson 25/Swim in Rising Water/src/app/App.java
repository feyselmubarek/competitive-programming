package app;

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int swimInWater(int[][] grid) {
        int gridLength = grid.length;
        int gridElementLength = grid[0].length;
        int maxMinTime = Integer.MIN_VALUE;

        State start = new State(0, 0, grid[0][0], grid[0][0]);
        State end = new State(gridLength - 1, gridElementLength - 1, 0, grid[gridLength - 1][gridElementLength - 1]);

        HashSet<Integer> seen = new HashSet<>();
        PriorityQueue<State> priQueue = new PriorityQueue<>();

        priQueue.add(start);
        seen.add(start.val);

        while (!priQueue.peek().equals(end)) {
            State currentState = priQueue.poll();

            int lastMinMax = currentState.maxSoFar;
            maxMinTime = lastMinMax;

            // up
            if (currentState.row - 1 >= 0 && !seen.contains(grid[currentState.row - 1][currentState.column])) {
                int newVal = grid[currentState.row - 1][currentState.column];

                seen.add(newVal);
                priQueue.add(
                        new State(currentState.row - 1, currentState.column, Math.max(lastMinMax, newVal), newVal));
            }

            // down
            if (currentState.row + 1 < gridLength && !seen.contains(grid[currentState.row + 1][currentState.column])) {
                int newVal = grid[currentState.row + 1][currentState.column];

                seen.add(newVal);
                priQueue.add(
                        new State(currentState.row + 1, currentState.column, Math.max(lastMinMax, newVal), newVal));
            }

            // left
            if (currentState.column - 1 >= 0 && !seen.contains(grid[currentState.row][currentState.column - 1])) {
                int newVal = grid[currentState.row][currentState.column - 1];

                seen.add(newVal);
                priQueue.add(
                        new State(currentState.row, currentState.column - 1, Math.max(lastMinMax, newVal), newVal));
            }

            // right
            if (currentState.column + 1 < gridElementLength
                    && !seen.contains(grid[currentState.row][currentState.column + 1])) {
                int newVal = grid[currentState.row][currentState.column + 1];

                seen.add(newVal);
                priQueue.add(
                        new State(currentState.row, currentState.column + 1, Math.max(lastMinMax, newVal), newVal));
            }

        }

        return Math.max(maxMinTime, grid[gridLength - 1][gridElementLength - 1]);
    }
}

class State implements Comparable<State> {
    public int row;
    public int column;
    public int maxSoFar;
    public int val;

    public State(int row, int column, int maxSoFar, int val) {
        this.row = row;
        this.column = column;
        this.maxSoFar = maxSoFar;
        this.val = val;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof State) {
            State otherState = (State) object;
            return this.row == otherState.row && this.column == otherState.column;
        }

        return false;
    }

    @Override
    public int compareTo(State otherState) {
        if (this.maxSoFar < otherState.maxSoFar) {
            return -1;
        } else if (this.maxSoFar > otherState.maxSoFar) {
            return 1;
        }

        return 0;
    }
}