package app;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public String longestWord(String[] words) {
        Node root = new Node(false);
        Node curr = root;

        Arrays.sort(words);

        String longWord = "";

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);

                if (curr.children[c - 97] == null) {
                    if (words[i].length() - j != 1) {
                        break;
                    }
                    curr.children[c - 97] = new Node(true);
                    longWord = words[i].length() > longWord.length() ? words[i] : longWord;
                }

                curr = curr.children[c - 97];
            }

            curr = root;
        }

        return longWord;
    }
}

class Node {
    public Node[] children;
    public boolean isEnd;

    public Node(boolean isEnd) {
        this.children = new Node[26];
        this.isEnd = isEnd;
    }
}