package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().minAddToMakeValid("()(()()()()())))))((("));
    }

    public int minAddToMakeValid(String S) {
        int openingNeeded = 0;
        int closingNeeded = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                closingNeeded++;
            } else {
                if (closingNeeded == 0) {
                    openingNeeded++;
                } else {
                    closingNeeded--;
                }
            }
        }

        return openingNeeded + closingNeeded;
    }
}