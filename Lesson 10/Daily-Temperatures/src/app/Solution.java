package app;

import java.util.Stack;

public class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(T[T.length - 1], T.length - 1));

        for (int i = T.length - 2; i >= 0; i--) {
            int currentTemp = T[i];

            while (!stack.isEmpty() && stack.peek().val <= currentTemp) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek().index - i;
            } else {
                result[i] = 0;
            }

            stack.push(new Pair(currentTemp, i));

        }

        return result;
    }
}

class Pair {
    int val;
    int index;

    public Pair(int val, int index) {
        this.val = val;
        this.index = index;
    }
}