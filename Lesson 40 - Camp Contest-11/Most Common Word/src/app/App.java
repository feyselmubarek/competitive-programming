package app;

import java.util.HashMap;
import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().mostCommonWord("Bob. hIt, baLl", new String[] { "bob", "hit" }));
    }

    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedSet = new HashSet<>();
        HashMap<String, Integer> occMap = new HashMap<>();

        for (String string : banned) {
            bannedSet.add(string);
        }

        String freqWord = "";
        int maxOcc = 0;

        String[] par = paragraph.split(" ");

        for (int i = 0; i < par.length; i++) {
            String parsedWord = parseWord(par[i]);

            if (!bannedSet.contains(parsedWord)) {
                int occ = 1;

                if (occMap.containsKey(parsedWord)) {
                    occ = occMap.get(parsedWord) + 1;
                    occMap.put(parsedWord, occ);
                } else {
                    occMap.put(parsedWord, occ);
                }

                if (maxOcc < occ) {
                    maxOcc = occ;
                    freqWord = parsedWord;
                }
            }
        }

        return freqWord;
    }

    public String parseWord(String word) {
        HashSet<Character> panc = new HashSet<>();
        panc.add('!');
        panc.add('?');
        panc.add('\'');
        panc.add(',');
        panc.add(';');
        panc.add('.');

        int finalIndex = word.length();

        for (int i = 0; i < word.length(); i++) {
            if (panc.contains(word.charAt(i))) {
                finalIndex = i;
                break;
            }
        }

        return word.substring(0, finalIndex).toLowerCase();
    }
}