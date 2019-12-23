package app;

/**
 * Solution
 */
public class Solution {
    public int hIndex(int[] citations) {
        int length = citations.length, i = 0, j = length - 1;
        int mid = 0;

        while (i <= j) {
            mid = i == j ? i : ((i + j) - 1) / 2;
            int numberOfPapers = length - mid;

            if (numberOfPapers < citations[mid]) {
                j = mid - 1;
            } else if (numberOfPapers > citations[mid]) {
                i = mid + 1;
            } else {
                return numberOfPapers;
            }
        }
        return length - i;
    }
}