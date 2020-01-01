package app;

import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Integer> res = new Solution().topKFrequent(new int[] { 4, 4, 4, 2, 2, 3, 3 }, 3);

        System.out.println();
        for (Integer integer : res) {
            System.out.print(integer + ", ");
        }
        System.out.println();
    }
}
