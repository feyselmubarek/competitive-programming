package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int[] numberOfLines(int[] widths, String S) {
        int line_no = 1;
        int curr_width = 0;

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (curr_width + widths[c - 97] <= 100) {
                curr_width += widths[c - 97];
            } else {
                line_no++;
                curr_width = widths[c - 97];
            }
        }

        return new int[] { line_no, curr_width };
    }
}