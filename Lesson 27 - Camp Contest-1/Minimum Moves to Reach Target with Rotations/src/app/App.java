package app;

public class App {
    public static void main(String[] args) throws Exception {

    }

    public int minimumMoves(int[][] grid) {

        return -1;
    }

    public boolean isValidMove(State newState, State lastState, int[][] grid) {

        return false;
    }
}

class State {
    public Pair head;
    public Pair tail;

    public State(Pair head, Pair tail) {
        this.head = head;
        this.tail = tail;
    }

    public State genRightMove() {
        return new State(new Pair(head.x + 1, head.y), new Pair(tail.x + 1, tail.y));
    }

    public State genClockWiseMove() {
        return new State(new Pair(head.x, head.y), new Pair(tail.x - 1, tail.y + 1));
    }

    public State genCounterClockwiseMove() {
        return new State(new Pair(head.x, head.y), new Pair(tail.x - 1, tail.y - 1));
    }

    public State genDownMove() {
        return new State(new Pair(head.x, head.y + 1), new Pair(tail.x, tail.y + 1));
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