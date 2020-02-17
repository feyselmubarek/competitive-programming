package app;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public String replaceWords(List<String> dict, String sentence) {
        TNode root = constructTries(dict);
        TNode curr = root;

        String[] sen_arr = sentence.split(" ");
        StringBuilder sen_builder = new StringBuilder();

        for (String word : sen_arr) {
            StringBuilder word_builder = new StringBuilder();

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (curr.children[c - 97] == null || i == word.length() - 1) {
                    sen_builder.append(word + " ");
                    break;
                }

                word_builder.append(c);
                curr = curr.children[c - 97];

                if (curr.isEnd) {
                    sen_builder.append(word_builder.toString() + " ");
                    break;
                }

            }

            curr = root;
        }

        return sen_builder.substring(0, sen_builder.length() - 1);
    }

    public TNode constructTries(List<String> dict) {
        TNode root = new TNode(false);
        TNode curr = root;

        for (String str : dict) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (curr.children[c - 97] == null) {
                    curr.children[c - 97] = new TNode(false);
                }

                curr = curr.children[c - 97];
            }

            curr.isEnd = true;
            curr = root;
        }

        return root;
    }
}

class TNode {
    public TNode[] children;
    public boolean isEnd;

    public TNode(boolean isEnd) {
        this.isEnd = isEnd;
        this.children = new TNode[26];
    }
}