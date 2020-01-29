package app;

import java.util.Arrays;
import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().validateStackSequences(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 5, 3, 1, 2 }));
    }

    public int minIncrementForUnique(int[] A) {

        return 0;
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

    public int bagOfTokensScore(int[] tokens, int P) {
        if (tokens.length == 0) {
            return 0;
        }

        Arrays.sort(tokens);
        int maxPoint = 0, currentPoint = 0;
        int pointIndex = 0, powerIndex = tokens.length - 1;

        while (pointIndex <= powerIndex) {
            if (tokens[pointIndex] <= P) {
                P -= tokens[pointIndex];
                currentPoint++;

                if (currentPoint > maxPoint) {
                    maxPoint = currentPoint;
                }

                pointIndex++;
            } else {
                if (currentPoint > 0) {
                    P += tokens[powerIndex];
                    currentPoint--;
                }
                powerIndex--;
            }
        }

        return maxPoint;
    }
}