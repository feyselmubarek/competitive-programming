package app;

public class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1)
            return false;
        int sum = 1;
        int m = (int) Math.sqrt(num);

        for (int i = 2; i <= m; i++) {
            sum += num % i == 0 ? (i + (num / i)) : 0;
        }

        return sum == num;
    }
}