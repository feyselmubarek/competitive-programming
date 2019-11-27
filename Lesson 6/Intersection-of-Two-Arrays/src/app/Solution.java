package app;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> intersection = new HashMap<>();

        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        for (int i = 0; i < nums2.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                if ((nums1[j] == nums2[i]) && (!intersection.containsKey(j))) {
                    intersection.put(j, nums1[j]);
                    break;
                }
            }
        }

        return intersection.values().stream().mapToInt(i -> i).toArray();
    }
}