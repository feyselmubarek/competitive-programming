package app;

/**
 * Solution
 */
public class Solution {
    public int hIndex(int[] citations) {
        int length = citations.length, i = 0, j = length - 1;
        int mid = ((i + j) + 1) / 2;

        while (j - i > 1) {
            int numberOfPapers = length - mid;

            if (numberOfPapers > citations[mid]) {
                j = mid;
            } else if (numberOfPapers < citations[mid]) {
                i = mid;
            } else {
                return mid;
            }
            mid = ((i + j) + 1) / 2;
        }

        if ((length - i) <= citations[i]) {
            return (length - i);
        } else if ((length - j) >= citations[i]) {
            return (length - j);
        }

        return -1;
    }
}