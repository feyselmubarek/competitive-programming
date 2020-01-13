package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().smallestRepunitDivByK(9999));
    }

    public int smallestRepunitDivByK(int K) {
        if (K % 5 == 0 || K % 2 == 0) {
            return -1;
        }

        int length = 1, number = 1;

        while (number % K != 0) {
            number = ((number % K) * 10) + 1;
            length++;
        }

        return length;
    }
}