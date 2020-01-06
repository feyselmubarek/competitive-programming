package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().myPow(2.00000, 2));
    }

    public double myPow(double x, int n) {
        double res = getPosPow(x, Math.abs(n));

        return n < 0 ? (1 / res) : res;
    }

    public double getPosPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double halfRes = getPosPow(x, (n / 2));

        if (n % 2 != 0) {
            return halfRes * halfRes * x;
        }

        return halfRes * halfRes;

    }
}