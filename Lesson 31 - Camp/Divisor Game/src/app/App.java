package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().checkWinner(10));
    }

    public boolean divisorGame(int N) {
        return checkWinner(N % 2 == 0 ? 2 : 1);
    }

    public boolean checkWinner(int n) {
        return n == 1 ? false : true;
    }
}