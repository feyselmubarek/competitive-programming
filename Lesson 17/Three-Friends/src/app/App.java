package app;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int testCaseAmmount = scanner.nextInt();
        String[] testCase = new String[testCaseAmmount];
        scanner.nextLine();

        for (int i = 0; i < testCaseAmmount; i++) {
            String line = scanner.nextLine();
            testCase[i] = line;
        }

        for (int i = 0; i < testCase.length; i++) {
            System.out.println(minTotalPairwiseDistance(testCase[i]));
        }
        scanner.close();
    }

    private static int minTotalPairwiseDistance(String string) {

        String[] data = string.split(" ");
        int[] d = new int[data.length];
        int min, mid, max;

        for (int j = 0; j < data.length; j++) {
            d[j] = Integer.parseInt(data[j]);
        }

        Arrays.sort(d);

        min = d[0];
        mid = d[1];
        max = d[2];

        if ((min + 1) < mid) {
            min += 1;
            mid -= 1;
            max -= 1;
        } else if ((mid + 1) < max) {
            min += 1;
            mid += 1;
            max -= 1;
        } else {
            if (min < mid) {
                min += 1;
            }

            if (max > mid) {
                max -= 1;
            }
        }

        int res = (Math.abs(min - mid) + Math.abs(min - max) + Math.abs(mid - max));

        return res;
    }
}