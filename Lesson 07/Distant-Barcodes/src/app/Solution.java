package app;

import java.util.HashMap;

public class Solution {
    /**
     * NOTE => not fully working solution for a complete solution see Solution2
     */
    public int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[barcodes.length];

        for (int i = 0; i < barcodes.length; i++) {
            int num = barcodes[i];

            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        int zeroIndex = 0, oneIndex = 1;

        for (int i : map.keySet()) {
            int occ = map.get(i);

            while (occ > 0) {
                if (zeroIndex < result.length) {
                    result[zeroIndex] = i;
                    occ--;
                    zeroIndex += 2;

                } else if (oneIndex < result.length) {
                    result[oneIndex] = i;
                    occ--;
                    oneIndex += 2;
                }
            }
        }

        return result;
    }
}