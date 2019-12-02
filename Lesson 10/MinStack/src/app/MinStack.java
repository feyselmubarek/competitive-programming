package app;

import java.util.ArrayList;
import java.util.Collections;

/**
 * MinStack
 */
public class MinStack {

    /** initialize your data structure here. */
    private ArrayList<Integer> stack;
    int min = 0;

    public MinStack() {
        stack = new ArrayList<>();
    }

    public void push(int x) {
        stack.add(x);
        min = Collections.min(stack);
    }

    public void pop() {
        if (getSize() > 0) {
            int tempMin = stack.remove(getSize() - 1);
            if (tempMin == min && getSize() > 0) {
                min = Collections.min(stack);
            }
        }
    }

    public int top() {
        if (getSize() > 0) {
            return stack.get(getSize() - 1);
        }
        return 0;
    }

    public int getMin() {
        return min;
    }

    public int getSize() {
        return stack.size();
    }
}