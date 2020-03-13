package app;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int[][] sumArr = populateSumArr(arr);
        int maxHourGlass = Integer.MIN_VALUE;

        for (int row = 1; row < arr.length - 1; row++) {
            for (int column = 1; column < arr[row].length - 1; column++) {
                int left = column - 1;
                int right = column + 2;

                int upperSum = sumArr[row - 1][right] - sumArr[row - 1][left];
                int underSum = sumArr[row + 1][right] - sumArr[row + 1][left];

                maxHourGlass = Math.max(maxHourGlass, (upperSum + underSum + arr[row][column]));
            }
        }

        return maxHourGlass;

    }

    static int[][] populateSumArr(int[][] arr) {
        int[][] sumArr = new int[arr.length][];

        for (int row = 0; row < arr.length; row++) {
            sumArr[row] = new int[arr[row].length + 1];
            int sum = 0;

            for (int column = 1; column < sumArr[row].length; column++) {
                sum += arr[row][column - 1];
                sumArr[row][column] = sum;
            }
        }

        return sumArr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}