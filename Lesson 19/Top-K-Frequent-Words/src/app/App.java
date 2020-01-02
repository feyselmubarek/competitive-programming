package app;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> res = new Solution().topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" },
                2);

        System.out.println();
        for (String str : res) {
            System.out.print(str + ", ");
        }
        System.out.println();
        // String[] r = new String[] { "love", "feysel" };
        // Arrays.sort(r);

        // for (int i = 0; i < r.length; i++) {
        // System.out.println(r[i]);
        // }
    }
}