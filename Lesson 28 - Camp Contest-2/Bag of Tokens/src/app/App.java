package app;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
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