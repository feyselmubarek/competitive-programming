// question - link : https://leetcode.com/problems/play-with-chips/
package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int minCostToMoveChips(int[] chips) {
        int odd = 0, even = 0;

        for (int i = 0; i < chips.length; i++) {
            if (chips[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        return even < odd ? even : odd;
    }
}