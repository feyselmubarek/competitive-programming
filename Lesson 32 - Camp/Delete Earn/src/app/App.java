package app;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().deleteAndEarn(new int[] { 1, 2, 3, 4, 5 }));
    }

    public int deleteAndEarn(int[] nums) {
        int[] countingArray = new int[10001];

        for (int i = 0; i < nums.length; i++) {
            countingArray[nums[i]] += 1;
        }

        ArrayList<Integer> sorted = new ArrayList<>();

        for (int j = 0; j < countingArray.length; j++) {
            if (countingArray[j] != 0) {
                sorted.add(j);
            }
        }

        int[] memo = new int[sorted.size()];
        int maxPoint = 0;
        int max = 0;

        for (int k = 0; k < memo.length; k++) {
            int curr = sorted.get(k);

            if (k != 0) {
                if (sorted.get(k - 1) != curr - 1) {
                    maxPoint = Math.max(maxPoint, memo[k - 1]);
                } else if (k - 3 >= 0) {
                    maxPoint = Math.max(maxPoint, memo[k - 3]);
                }

                if (k - 2 >= 0) {
                    maxPoint = Math.max(maxPoint, memo[k - 2]);
                }

            }

            int point = maxPoint + (curr * countingArray[curr]);
            max = Math.max(max, point);

            memo[k] = point;
        }

        return max;
    }
}