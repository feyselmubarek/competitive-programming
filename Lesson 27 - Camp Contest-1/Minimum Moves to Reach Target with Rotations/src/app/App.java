package app;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new State(new Pair(0, 1), new Pair(0, 0), 0).genDownMove());
    }

    public int minimumMoves(int[][] grid) {
        Queue<State> queue = new LinkedList<>();
        HashSet<State> set = new HashSet<>();

        State init = new State(new Pair(0, 1), new Pair(0, 0), 0);
        queue.add(init);
        set.add(init);

        int len = grid.length;
        State finalDes = new State(new Pair(len - 1, len - 1), new Pair(len - 1, len - 2), -1);

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            if (cur.equals(finalDes)) {
                return cur.distance;
            }

            for (int i = 1; i <= 4; i++) {
                State newState = null;

                if (i == 1) {
                    if (isValidMove(cur.genRightMove(), 1, grid)) {
                        newState = cur.genRightMove();
                    }
                } else if (i == 2) {
                    if (isValidMove(cur.genDownMove(), 2, grid)) {
                        newState = cur.genDownMove();
                    }
                } else if (i == 3) {
                    if (isValidMove(cur.genClockWiseMove(), 3, grid)) {
                        newState = cur.genClockWiseMove();
                    }
                } else {
                    if (isValidMove(cur.genCounterClockwiseMove(), 4, grid)) {
                        newState = cur.genCounterClockwiseMove();
                    }
                }

                if (newState != null && !set.contains(newState)) {
                    queue.add(newState);
                    set.add(newState);
                }
            }
        }

        return -1;
    }

    public boolean isValidMove(State newstate, int moveId, int[][] grid) {
        int len = grid.length;

        if (newstate.head.x < 0 || newstate.head.x >= len || newstate.tail.x < 0 || newstate.tail.x >= len
                || newstate.head.y < 0 || newstate.head.y >= len || newstate.tail.y < 0 || newstate.tail.y >= len
                || grid[newstate.head.x][newstate.head.y] == 1 || grid[newstate.tail.x][newstate.tail.y] == 1) {
            return false;
        }

        // clockwise head(x,y) and tail(x,y), thier x coordiante must be the same
        if (moveId == 3) {
            if (newstate.head.y != newstate.tail.y || grid[newstate.head.x][newstate.head.y + 1] == 1) {
                return false;
            }
        }

        // counter clockwise head(x,y) and tail(x,y), thier y coordinate must be the
        // same
        if (moveId == 4) {
            if (newstate.head.x != newstate.tail.x || grid[newstate.head.x + 1][newstate.head.y] == 1) {
                return false;
            }
        }

        return true;
    }
}

class State {
    public Pair head;
    public Pair tail;
    public int distance;

    public State(Pair head, Pair tail, int distance) {
        this.head = head;
        this.tail = tail;
        this.distance = distance;
    }

    public State genRightMove() {
        return new State(new Pair(head.x, head.y + 1), new Pair(tail.x, tail.y + 1), distance + 1);
    }

    public State genClockWiseMove() {
        return new State(new Pair(head.x + 1, head.y - 1), new Pair(tail.x, tail.y), distance + 1);
    }

    public State genCounterClockwiseMove() {
        return new State(new Pair(head.x - 1, head.y + 1), new Pair(tail.x, tail.y), distance + 1);
    }

    public State genDownMove() {
        return new State(new Pair(head.x + 1, head.y), new Pair(tail.x + 1, tail.y), distance + 1);
    }

    @Override
    public boolean equals(Object obj) {
        State newState = (State) obj;

        if (newState.head.equals(this.head) && newState.tail.equals(this.tail)) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return (head + " " + tail).hashCode();
    }

    @Override
    public String toString() {
        return "H => (" + head.x + ", " + head.y + ") : T => (" + tail.x + ", " + tail.y + ")";
    }

}

class Pair {
    public int x;
    public int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        Pair newPair = (Pair) obj;
        if (newPair.x == this.x && newPair.y == this.y) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}