package app;

import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int uniqueMorseRepresentations(String[] words) {
        String[] morse_code = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
                "-.--", "--.." };

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder builder = new StringBuilder();

            for (int j = 0; j < word.length(); j++) {
                builder.append(morse_code[word.charAt(j)]);
            }

            set.add(builder.toString());
        }

        return set.size();
    }
}