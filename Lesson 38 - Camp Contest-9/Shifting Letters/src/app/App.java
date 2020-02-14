package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public String shiftingLetters(String S, int[] shifts) {
        int sum = 0;

        for (int i = shifts.length - 1; i >= 0; i--) {
            shifts[i] %= 26;
            sum += shifts[i];
            shifts[i] = sum;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            int currVal = (S.charAt(i) - 97 + shifts[i]) % 26;

            builder.append((char) (currVal + 97));
        }

        return builder.toString();
    }
}