package app;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int lengthOfString = scanner.nextInt();
        int noOfLetters = scanner.nextInt();
        scanner.nextLine();

        String line = scanner.nextLine();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < noOfLetters; i++) {
            set.add(scanner.next().charAt(0));
        }

        System.out.println(getPosibleSubString(line, lengthOfString, set));
        scanner.close();
    }

    private static long getPosibleSubString(String string, int length, Set<Character> set) {
        long posibility = 0;
        long counter = 0;

        for (int i = 0; i < length; i++) {
            char c = string.charAt(i);
            if (!set.contains(c)) {
                posibility += counter;
                counter = 0;
            } else {
                posibility += counter;
                counter++;
            }
        }

        if (counter != 0) {
            posibility += counter;
        }

        return posibility;
    }
}