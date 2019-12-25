package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCaseAmount = scanner.nextInt();
        scanner.nextLine();
        String[] testCases = new String[testCaseAmount];

        for (int i = 0; i < testCaseAmount; i++) {
            testCases[i] = scanner.nextLine();
        }

        for (int i = 0; i < testCaseAmount; i++) {
            System.out.println(getUnavilableTime(testCases[i].split(" ")));
        }

        scanner.close();
    }

    private static int getUnavilableTime(String[] arrayStrings) {

        int a = Integer.parseInt(arrayStrings[0]);
        int b = Integer.parseInt(arrayStrings[1]);
        int c = Integer.parseInt(arrayStrings[2]);
        int r = Integer.parseInt(arrayStrings[3]);

        if (a > b) {
            int temp = b;
            b = a;
            a = temp;
        }

        int c_l = c - r;
        int c_r = c + r;

        int dis = Math.abs(b - a);

        if (a <= c_l && c_r <= b) {
            // check in the mid
            return dis - (c_r - c_l);
        } else if (c_l <= a && a <= c_r && b > c_r) {
            // a between coverage
            return dis - (c_r - a);
        } else if (c_l <= b && b <= c_r && a < c_l) {
            // b between coverage
            return dis - (b - c_l);
        } else if (c_r <= a) {
            // out side coverage
            return dis;
        } else if (b <= c_l) {
            // outside coverage
            return dis;
        }

        return 0;
    }
}