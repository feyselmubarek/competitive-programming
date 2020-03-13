package app;

import java.util.*;
import java.io.*;

public class App {
    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {

        Queue<Pair> queue = new LinkedList<>();
        boolean[] seen = new boolean[c.length];
        // pair fisrt as index, second as distance
        queue.add(new Pair(0, 0));
        seen[0] = true;

        while (queue.peek().first != c.length - 1) {
            Pair curr = queue.poll();

            if (curr.first + 1 < c.length && c[curr.first + 1] == 0 && !seen[curr.first + 1]) {
                queue.add(new Pair(curr.first + 1, curr.second + 1));
                seen[curr.first + 1] = true;
            }

            if (curr.first + 2 < c.length && c[curr.first + 2] == 0 && !seen[curr.first + 2]) {
                queue.add(new Pair(curr.first + 2, curr.second + 1));
                seen[curr.first + 2] = true;
            }
        }

        return queue.peek().second;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

class Pair {
    public int first;
    public int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}