package app;

import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int testCaseAmmount = scanner.nextInt();
        String[] passData = new String[testCaseAmmount];
        String[] hashData = new String[testCaseAmmount];

        scanner.nextLine();

        for (int i = 0; i < testCaseAmmount; i++) {
            passData[i] = scanner.nextLine();
            hashData[i] = scanner.nextLine();
        }

        for (int i = 0; i < testCaseAmmount; i++) {
            System.out.println(checkHashing(passData[i], hashData[i]));
        }

        scanner.close();
    }

    private static String checkHashing(String password, String hash) {
        HashMap<Character, Integer> passCharsOccurance = new HashMap<>();
        HashMap<Character, Integer> holder = new HashMap<>();

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (passCharsOccurance.containsKey(c)) {
                passCharsOccurance.put(c, passCharsOccurance.get(c) + 1);
                holder.put(c, holder.get(c) + 1);
            }else{
                passCharsOccurance.put(c, 1);
                holder.put(c, 1);
            }
        }

        if (hash.length() < password.length()) {
            return "NO";
        }

        boolean result = false;
        int i = 0;

        while (i + password.length() <= hash.length()) {
            String hashSub = hash.substring(i, i + password.length());
            result = isHash(passCharsOccurance, hashSub);

            if (result) {
                return "YES";
            }

            passCharsOccurance.putAll(holder);
            i++;
        }

        return "NO" ;
    }

    private static boolean isHash(HashMap<Character, Integer> passCharsOccurance, String substring) {
        for (int i = 0; i < substring.length(); i++) {
            char c = substring.charAt(i);

            if (!passCharsOccurance.containsKey(c)) {
                return false;
            }

            int occ = passCharsOccurance.get(c);

            if (occ == 1) {
                passCharsOccurance.remove(c);
                continue;
            }

            passCharsOccurance.put(c, occ - 1);
        }

        return passCharsOccurance.size() == 0;
    }
}