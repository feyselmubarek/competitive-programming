package app;

public class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int max = A[0];

        for (int i = 1; i < A.length; i++) {
            if (A[i] <= max) {
                return (i - 1);
            }
            max = A[i];
        }

        return 0;
    }
}