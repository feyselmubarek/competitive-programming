package app;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> res = new Solution().topKFrequent(new String[] { "aaa", "aa", "a" }, 1);

        //
        // String[] r = new String[] { "love", "feysel" };
        // Arrays.sort(r);

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}