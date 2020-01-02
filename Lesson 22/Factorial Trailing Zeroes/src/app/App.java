package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().trailingZeroes(100));
    }

    public int trailingZeroes(int n) {
        int zeros = 0;
        long fivesPower = 5;

        while (n >= fivesPower) {
            zeros += (n / fivesPower);
            fivesPower *= 5;
        }

        return zeros;
    }
}