package app;

public class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int current = barcodes[0];

        for (int i = 1; i < barcodes.length; i++) {
            int j = i + 1;
            while (barcodes[i] == current) {
                current = barcodes[j];
                j++;
            }
            j--;
            int val = barcodes[i];
            barcodes[j] = val;
            barcodes[i] = current;
        }

        return barcodes;
    }
}