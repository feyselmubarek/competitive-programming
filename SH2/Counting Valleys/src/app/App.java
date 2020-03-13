package app;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int vallies = 0;
        int currLevel = 0;

        for (int index = 0; index < n; index++) {
            char unit = s.charAt(index);

            if (unit == 'U') {
                currLevel++;

                if (currLevel == 0) {
                    vallies++;
                }

            } else {
                currLevel--;
            }
        }

        return vallies;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}