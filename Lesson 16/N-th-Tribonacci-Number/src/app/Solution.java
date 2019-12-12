package app;

public class Solution {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        int res = 0, n2 = 1, n1 = 1, n0 = 0;

        for (int i = 3; i <= n; i++) {
            res = n1 + n2 + n0;
            n0 = n1;
            n1 = n2;
            n2 = res;
        }

        return res;
    }
}