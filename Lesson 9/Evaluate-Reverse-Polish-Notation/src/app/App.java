package app;

public class App {
    public static void main(String[] args) throws Exception {
        String[] strings = new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        System.out.println(new Solution().evalRPN(strings));
    }
}