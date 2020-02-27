package app;

import java.util.Objects;
import java.util.Stack;

/**
 * MinStack
 */
public class MinStack {

    /** initialize your data structure here. */
    private Stack<Pair<Integer, Integer>> stack;

    public MinStack() {
        // pair elemenrt : min
        stack = new Stack<>();
    }

    public void push(int x) {
        int min = x;

        if (stack.size() != 0 && stack.peek().getSecond() < x) {
            min = stack.peek().getSecond();
        }

        stack.push(new Pair<>(x, min));
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek().getFirst();
        }

        return -1;
    }

    public int getMin() {
        if (!stack.isEmpty()) {
            return stack.peek().getSecond();
        }

        return -1;
    }
}

class Pair<F extends Comparable<F>, S extends Comparable<S>> implements Comparable<Pair<F, S>> {
    private F first;
    private S second;

    public Pair() {
    }

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pair<?, ?>) {
            Pair<?, ?> pair = (Pair<?, ?>) obj;
            return pair.first.equals(this.first) && pair.second.equals(this.second);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    @Override
    public int compareTo(Pair<F, S> o) {
        return this.getFirst().compareTo(o.getFirst());
    }

    @Override
    public String toString() {
        return "{ " + getFirst() + " : " + getSecond() + " }";
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */