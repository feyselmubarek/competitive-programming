package app;

import java.util.Scanner;

public class App {
    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int totalBribes = 0;

        for (int index = q.length - 1; index >= 0; index--) {
            if (index + 1 != q[index]) {
                int otherIndex = findCorrectNum(index, q);

                if (otherIndex == -1) {
                    System.out.println("Too chaotic");
                    return;
                }

                totalBribes += swapUntilCurrent(otherIndex, index, q);
            }
        }

        System.out.println(totalBribes);

    }

    static int swapUntilCurrent(int index, int myIndex, int[] q) {
        int swaps = myIndex - index;

        while (index < myIndex) {
            swap(q, index, index + 1);
            index++;
        }

        return swaps;
    }

    static void swap(int[] q, int indexOne, int indexTwo) {
        q[indexOne] += q[indexTwo];
        q[indexTwo] = q[indexOne] - q[indexTwo];
        q[indexOne] = q[indexOne] - q[indexTwo];
    }

    static int findCorrectNum(int index, int[] q) {
        int lastIndexToCheck = index - 2;
        int numToFind = index + 1;

        while (index >= 0 && index >= lastIndexToCheck) {
            if (q[index] == numToFind) {
                return index;
            }

            index--;
        }

        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}