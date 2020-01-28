package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().isSubsequence("Hello Java", "Hello Javaello Java"));
    }

    public boolean isSubsequence(String s, String t) {
        if (s.equals("")) {
            return true;
        }

        int s_count = 0, s_len = s.length();
        char c = s.charAt(s_count);

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == c) {
                if (s_count == s_len - 1) {
                    return true;
                } else if (s_count < s_len) {
                    s_count++;
                    c = s.charAt(s_count);
                }
            }
        }

        return false;
    }
}