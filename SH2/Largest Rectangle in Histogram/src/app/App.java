package app;

import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();

        int index = 0;
        int maxArea = 0;

        while (!stack.isEmpty() || index < heights.length) {
            if (index < heights.length && (stack.isEmpty() || heights[stack.peek()] <= heights[index])) {
                stack.push(index);
                index++;
            } else {
                int current = stack.pop();
                int units = stack.isEmpty() ? index : index - 1 - stack.peek();
                int area = heights[current] * units;

                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}