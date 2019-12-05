package app;

public class Solution {
    public int[] dailyTemperatures(int[] T) {
        if (T == null) {
            return null;
        }
        int[] result = new int[T.length];

        for (int i = 0; i < T.length; i++) {
            int curentTemp = T[i];

            for (int j = i + 1; j < T.length; j++) {
                int maxTemp = T[j];

                if (curentTemp < maxTemp) {
                    result[i] = j - i;
                    break;
                }
            }

        }

        return result;
    }
}