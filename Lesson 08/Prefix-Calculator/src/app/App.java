package app;

public class App {
    public static void main(String[] args) throws Exception {
        new Calculator().performPrefixCalculation("+ 4 * 3 12");
    }
}