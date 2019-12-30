package app;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Integer> res = new Solution().topKFrequent(new int[] { 1, 2, 1, 2, 3, 1 }, 2);

        System.out.println();
        for (Integer integer : res) {
            System.out.print(integer + ", ");
        }
        System.out.println();
    }
}