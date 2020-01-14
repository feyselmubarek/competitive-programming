package app;

import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().containsNearbyDuplicate(new int[] { 1, 2, 3, 4, 1 }, 3));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int lastIndex = map.get(nums[i]);

                if (i - lastIndex <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }

        return false;
    }
}