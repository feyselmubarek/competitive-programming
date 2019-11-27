package app;

public class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int[] result = new int[A.length];
        int oddPointer = 1;
        int evenPointer = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                result[evenPointer] = A[i];
                evenPointer += 2;
            } else {
                result[oddPointer] = A[i];
                oddPointer += 2;
            }
        }

        return result;
    }
}