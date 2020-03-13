package app;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long aOcc = getAOcc(s);
        int len = s.length();

        long ans = (n / len) * aOcc;
        long rem = n % len;
        int count = 0;

        while (count < rem) {
            if (s.charAt(count) == 'a') {
                ans++;
            }

            count++;
        }

        return ans;
    }

    static long getAOcc(String s) {
        long aOcc = 0;

        for (int index = 0; index < s.length(); index++) {
            if (s.charAt(index) == 'a') {
                aOcc++;
            }
        }

        return aOcc;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}