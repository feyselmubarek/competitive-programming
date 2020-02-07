package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().integerBreak(10));
    }

    public int integerBreak(int n) {
        if (n < 4) {
            return n - 1;
        }

        if (n % 3 == 2) {
            return (int) Math.pow(3, n / 3) * 2;
        }

        return (int) Math.pow(3, (n / 3 - 1)) * ((n % 3) + 3);
    }
}