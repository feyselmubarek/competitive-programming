package app;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int testCaseAmmount = scanner.nextInt();
        String[] testCase = new String[testCaseAmmount];

        for (int i = 0; i < testCaseAmmount; i++) {
            scanner.nextInt();
            scanner.nextLine();

            String line = scanner.nextLine();
            testCase[i] = line;
        }

        for (int i = 0; i < testCase.length; i++) {
            System.out.println(distributeMedal(testCase[i]));
        }
        scanner.close();
    }

    private static String distributeMedal(String string) {
        String[] data = string.split(" ");
        if (data.length < 10) {
            return "0 0 0";
        } else {
            int medalistLastIndex = data.length / 2 - 1;

            while ((medalistLastIndex >= 0) && data[medalistLastIndex].equals(data[medalistLastIndex + 1])) {
                medalistLastIndex--;
            }

            if ((medalistLastIndex + 1) < 5) {
                return "0 0 0";
            }

            String[] medalList = Arrays.copyOfRange(data, 0, medalistLastIndex + 1);
            int goldMedals = 0;
            int silverMedals = 0;
            int bronzeMedals = 0;
            int i;

            String goldValue = medalList[0];
            for (i = 0; i < medalList.length; i++) {
                if (!goldValue.equals(medalList[i])) {
                    break;
                }
                goldMedals++;
            }

            if (i == medalList.length) {
                return "0 0 0";
            }

            String silverValue = medalList[i];
            for (; i < medalList.length; i++) {
                if ((silverMedals > goldMedals) && (!silverValue.equals(medalList[i]))) {
                    break;
                }
                if (!silverValue.equals(medalList[i])) {
                    silverValue = medalList[i];
                }
                silverMedals++;
            }

            bronzeMedals = medalList.length - (goldMedals + silverMedals);

            return checkValidity(goldMedals, silverMedals, bronzeMedals);
        }
    }

    private static String checkValidity(int goldMedals, int silverMedals, int bronzeMedals) {
        if (goldMedals > 0 && silverMedals > 0 && bronzeMedals > 0) {
            if (silverMedals > goldMedals && bronzeMedals > goldMedals) {
                return goldMedals + " " + silverMedals + " " + bronzeMedals;
            }
        }
        return "0 0 0";
    }
}