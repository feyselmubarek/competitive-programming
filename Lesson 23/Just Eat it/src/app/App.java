package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int testCaseAmount = scanner.nextInt();
        scanner.nextLine();

        String[] testCases = new String[testCaseAmount];

        for (int i = 0; i < testCaseAmount; i++) {
            scanner.nextInt();
            scanner.nextLine();
            testCases[i] = scanner.nextLine();
        }

        for (int i = 0; i < testCases.length; i++) {
            System.out.println(checkIfYasserIsHappy(testCases[i]));
        }

        scanner.close();
    }

    private static String checkIfYasserIsHappy(String string) {
        String[] strArr = string.split(" ");
        int[] intArr = new int[strArr.length];

        long YasserSum = 0, maxSum = 0;

        for (int i = 0; i < strArr.length; i++) {
            int n = Integer.parseInt(strArr[i]);
            intArr[i] = n;
            YasserSum += n;
        }

        // sum1 holdes summation from arr[0] - arr[n -1]
        long sum1 = 0;
        for (int i = 0; i < intArr.length - 1; i++) {
            sum1 += intArr[i];
            sum1 = sum1 < 0 ? 0 : sum1;

            if (sum1 > maxSum) {
                maxSum = sum1;
            }
        }
        sum1 = maxSum;
        maxSum = 0;

        // sum2 holdes summation from arr[1] - arr[n]
        long sum2 = 0;
        for (int i = 1; i < intArr.length; i++) {
            sum2 += intArr[i];
            sum2 = sum2 < 0 ? 0 : sum2;

            if (sum2 > maxSum) {
                maxSum = sum2;
            }
        }
        sum2 = maxSum;

        if (sum1 >= YasserSum || sum2 >= YasserSum) {
            return "NO";
        }

        return "YES";
    }
}