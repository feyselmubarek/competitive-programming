package app;

import java.util.Dictionary;
import java.util.Hashtable;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Dictionary<Integer, Integer> dictionary = new Hashtable<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            dictionary.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int number = target - nums[i];
            if ((dictionary.get(number) != null) && (dictionary.get(number) != i)) {
                return new int[] { i, dictionary.get(number) };
            }
        }
        return new int[] {};
    }
}