package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int maxTurbulenceSize(int[] A) {
        if (A.length == 1) {
            return 1;
        }

        int maxLen = 1;
        int count = 0;
        boolean wasIncreasing = false;
        boolean isDetected = false;

        for (int i = 0; i < A.length - 1; i++) {
            if (!isDetected) {
                if (A[i] != A[i + 1]) {
                    isDetected = true;
                    wasIncreasing = A[i] < A[i + 1] ? true : wasIncreasing;
                    wasIncreasing = A[i] > A[i + 1] ? false : wasIncreasing;

                    count = 1;
                }

                continue;
            }

            if (A[i] < A[i + 1]) {
                if (!wasIncreasing) {
                    count++;
                    wasIncreasing = true;
                } else {
                    maxLen = Math.max(maxLen, count + 1);
                    count = 1;
                }
            } else if (A[i] > A[i + 1]) {
                if (wasIncreasing) {
                    count++;
                    wasIncreasing = false;
                } else {
                    maxLen = Math.max(maxLen, count + 1);
                    count = 1;
                }
            } else {
                isDetected = false;
                maxLen = Math.max(maxLen, count + 1);
                count = 1;
            }
        }

        maxLen = Math.max(maxLen, count + 1);

        return maxLen;
    }
}