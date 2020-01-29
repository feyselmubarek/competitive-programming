package app;

import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();

        int pushedIndex = 0, poppedIndex = 0;
        int target = popped[poppedIndex];

        while (pushedIndex < pushed.length || poppedIndex < popped.length) {
            while (pushedIndex < pushed.length && target != pushed[pushedIndex]) {
                stack.push(pushed[pushedIndex]);
                pushedIndex++;
            }

            if (pushedIndex < pushed.length && target == pushed[pushedIndex]) {
                poppedIndex++;
                pushedIndex++;
                target = popped[poppedIndex];
            } else {
                int a = stack.pop();
                if (a != popped[poppedIndex]) {
                    return false;
                }

                poppedIndex++;
            }
        }

        return true;
    }
}