package app;

import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().longestPalindromeSubseq("bbbab"));
    }

    public int longestPalindromeSubseq(String s) {
        return findMaxPalindrome(new HashMap<String, Integer>(), s, 0, s.length() - 1);
    }

    public int findMaxPalindrome(HashMap<String, Integer> memo, String S, int start, int end) {
        String pos = start + ":" + end;

        if (!memo.containsKey(pos)) {

            if (start == end) {
                memo.put(pos, 1);
                return 1;
            }

            int count = 0;
            int left = start, right = end;

            while (left < right && S.charAt(left) == S.charAt(right)) {
                count += 2;
                left++;
                right--;
            }

            if (left < right) {
                count += Math.max(findMaxPalindrome(memo, S, left, right - 1),
                        findMaxPalindrome(memo, S, left + 1, right));
            } else if (left == right) {
                count += 1;
            }

            memo.put(pos, count);

        }

        return memo.get(pos);
    }
}