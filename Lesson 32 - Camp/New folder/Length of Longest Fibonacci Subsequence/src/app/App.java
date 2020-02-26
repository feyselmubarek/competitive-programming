package app;

import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int lenLongestFibSubseq(int[] A) {
        HashMap<Integer, Integer> elements = new HashMap<>();

        for (int index = 0; index < A.length; index++) {
            elements.put(A[index], index);
        }

        return getFibSubSeqMaxLen(A, elements);
    }

    public int getFibSubSeqMaxLen(int[] A, HashMap<Integer, Integer> elements) {
        int maxLen = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (elements.containsKey(A[i] + A[j])) {
                    maxLen = Math.max(maxLen, getMeDepth(A, 3, j, elements.get(A[i] + A[j]), elements));
                }
            }
        }

        return maxLen;
    }

    public int getMeDepth(int[] A, int len, int last, int index, HashMap<Integer, Integer> elements) {
        if (!elements.containsKey(A[last] + A[index])) {
            System.out.println();
            return len;
        }

        return getMeDepth(A, len + 1, index, elements.get(A[last] + A[index]), elements);
    }
}