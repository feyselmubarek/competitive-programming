package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().minSteps(20));
    }

    public int minSteps(int n) {
        int steps = 0;
        int copyChar = 0;
        int notePadChar = 1;

        while (n != notePadChar) {
            if (n % notePadChar == 0) {
                copyChar = notePadChar;
                steps++;
            }

            notePadChar += copyChar;
            steps++;
        }

        return steps;
    }
}