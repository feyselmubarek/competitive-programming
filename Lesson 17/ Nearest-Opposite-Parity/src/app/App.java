package app;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int arrayLength = scanner.nextInt();
        scanner.nextLine();

        int[] list = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            list[i] = scanner.nextInt();
        }

        System.out.println(getMovesForOpositeParity(list, arrayLength));

        scanner.close();
    }

    private static String getMovesForOpositeParity(int[] list, int arrayLength) {

        return null;
    }
}

class Stack {

    private ArrayList<String> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    public String pop() {
        if (getSize() > 0) {
            return stack.remove(stack.size() - 1);
        }
        return null;
    }

    public void push(String c) {
        stack.add(c);
    }

    public int getSize() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }

}