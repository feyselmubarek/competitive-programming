package app;

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().orangesRotting(new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } }));
    }

    public int orangesRotting(int[][] grid) {
        int[][] timeGrid = new int[grid.length][];

        ArrayList<State> starts = new ArrayList<>();
        Queue<State> queue = new LinkedList<>();

        int freshOranges = constructGrid(starts, grid, timeGrid);

        for (int startPoint = 0; startPoint < starts.size(); startPoint++) {
            HashSet<State> seen = new HashSet<>();

            queue.add(starts.get(startPoint));
            seen.add(starts.get(startPoint));

            while (!queue.isEmpty()) {
                State curr = queue.poll();
                addMyNeighbours(curr, queue, seen, grid, timeGrid);
            }
        }

        return getMinTime(timeGrid, freshOranges);
    }

    public int getMinTime(int[][] timeGrid, int freshOranges) {
        int minTime = Integer.MIN_VALUE;
        int orangeCount = 0;

        for (int i = 0; i < timeGrid.length; i++) {
            for (int j = 0; j < timeGrid[i].length; j++) {
                if (timeGrid[i][j] != 0) {
                    minTime = Math.max(minTime, timeGrid[i][j]);
                    orangeCount++;
                }
            }
        }

        return orangeCount == freshOranges ? minTime : -1;
    }

    public void addMyNeighbours(State curr, Queue<State> queue, HashSet<State> seen, int[][] grid, int[][] timeGrid) {
        int r = curr.row;
        int c = curr.column;
        int t = curr.time;

        int len = grid.length;
        int rowLen = grid[len - 1].length;

        // up
        if (r - 1 >= 0 && grid[r - 1][c] == 1) {
            checkTheState(queue, seen, timeGrid, r - 1, c, t);
        }

        // down
        if (r + 1 < len && grid[r + 1][c] == 1) {
            checkTheState(queue, seen, timeGrid, r + 1, c, t);
        }

        // left
        if (c - 1 >= 0 && grid[r][c - 1] == 1) {
            checkTheState(queue, seen, timeGrid, r, c - 1, t);
        }

        // right
        if (c + 1 < rowLen && grid[r][c + 1] == 1) {
            checkTheState(queue, seen, timeGrid, r, c + 1, t);
        }
    }

    public void checkTheState(Queue<State> queue, HashSet<State> seen, int[][] timeGrid, int r, int c, int t) {
        int lastTime = timeGrid[r][c];
        State newState = new State(r, c, t + 1);

        // has not been rotten or can be rotten with less time
        if (lastTime == 0 || lastTime > t + 1) {
            timeGrid[r][c] = t + 1;
            queue.add(newState);
            seen.add(newState);
        }
    }

    public int constructGrid(ArrayList<State> starts, int[][] grid, int[][] timeGrid) {
        int freshOranges = 0;

        for (int row = 0; row < grid.length; row++) {
            timeGrid[row] = new int[grid[row].length];

            for (int column = 0; column < grid[row].length; column++) {
                int value = grid[row][column];

                if (value == 2) {
                    starts.add(new State(row, column, 0));
                } else if (value == 1) {
                    freshOranges++;
                }
            }
        }

        return freshOranges;
    }
}

class State {
    int row;
    int column;
    int time;

    public State(int row, int column, int time) {
        this.row = row;
        this.column = column;
        this.time = time;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof State) {
            State otherState = (State) obj;
            return this.row == otherState.row && this.column == otherState.column;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
