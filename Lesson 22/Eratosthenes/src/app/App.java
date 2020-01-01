package app;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        System.out.println(countPrimes(100));
    }

    public static int countPrimes(int n) {
        if (n <= 2)
            return 0;

        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;

        int m = (int) Math.sqrt(n);

        for (int i = 2; i <= m; i++) {
            if (prime[i]) {
                for (int k = i * i; k <= n; k += i) {
                    prime[k] = false;
                }
            }
        }

        int count = 0;

        for (int i = 2; i < prime.length - 1; i++) {
            if (prime[i] == true) {
                count++;
            }
        }

        return count;
    }
}