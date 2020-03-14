package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().generateTheString(2));
    }

    public String generateTheString(int n) {
        StringBuilder builder = new StringBuilder();
        int size = n;

        if (n % 2 == 0) {
            builder.append('b');
            size = n - 1;
        }

        for (int index = 0; index < size; index++) {
            builder.append('a');
        }

        return builder.toString();
    }
}