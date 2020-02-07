package app;

import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public boolean canReach(int[] arr, int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        boolean[] vistedIndex = new boolean[arr.length];
        vistedIndex[start] = true;

        while (!stack.isEmpty()) {
            int index = stack.pop();

            if (arr[index] == 0) {
                return true;
            }

            vistedIndex[index] = true;

            int left = index - arr[index];
            int right = index + arr[index];

            if (left >= 0 && vistedIndex[left] == false) {
                stack.push(left);
            }

            if (right < arr.length && vistedIndex[right] == false) {
                stack.push(right);
            }
        }

        return false;
    }
}