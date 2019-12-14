package app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int arrayLength = scanner.nextInt();
        scanner.nextLine();

        int[] list = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            list[i] = scanner.nextInt();
        }

        System.out.println(getMaxSubStrLength(list, arrayLength));

        scanner.close();
    }

    private static int getMaxSubStrLength(int[] list, int arrayLength) {
        int maxLength = 0, length = 0;
        boolean isOneElementRemoved = false;
        int prevNo = list[0];
        int currentNo = prevNo;

        for (int i = 1; i < arrayLength; i++) {
            currentNo = list[i];

            if (currentNo > prevNo) {
                length++;
                prevNo = currentNo;
            } else {
                if (!isOneElementRemoved && (i >= 2) && (list[i - 2] < currentNo)) {

                    if (length > 0) {
                        isOneElementRemoved = true;
                        prevNo = currentNo;
                        continue;
                    }

                } else if (!isOneElementRemoved && (i < arrayLength - 1) && list[i - 1] < list[i + 1]) {

                    if (length > 0) {
                        isOneElementRemoved = true;
                        continue;
                    }

                } else {
                    if (length > maxLength) {
                        maxLength = length;
                    }
                    length = 0;
                    isOneElementRemoved = false;
                    prevNo = currentNo;
                }
            }
        }

        if (length > maxLength) {
            maxLength = length;
        }

        if (maxLength > 0) {
            maxLength++;
        }

        if (maxLength == 0) {
            return 1;
        }

        return maxLength;
    }
}