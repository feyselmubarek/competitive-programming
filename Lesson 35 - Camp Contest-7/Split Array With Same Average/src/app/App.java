package app;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().splitArraySameAverage(new int[] { 4, 4, 4, 4, 4, 4, 5, 4, 4, 4, 4, 4, 4, 5 }));
    }

    public HashSet<Pair> getEndStates(int[] A) {
        Arrays.sort(A);
        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }

        HashSet<Pair> end_states = new HashSet<>();

        for (int i = 1; i <= A.length / 2; i++) {
            if ((sum * i) % A.length == 0) {
                end_states.add(new Pair((sum * i) / A.length, i));
                end_states.add(new Pair((sum * (A.length - i)) / A.length, A.length - i));
            }
        }

        return end_states;
    }

    public HashSet<Integer> copy(HashSet<Integer> p, int i) {
        HashSet<Integer> new_ = new HashSet<>();
        for (int index : p) {
            new_.add(index);
        }

        new_.add(i);
        return new_;
    }

    public boolean splitArraySameAverage(int[] A) {
        HashSet<Pair> end_states = getEndStates(A);

        if (end_states.size() == 0) {
            return false;
        }

        HashMap<Pair, HashSet<Integer>> visted = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();

        Pair start = new Pair(0, 0);
        visted.put(start, new HashSet<>());
        queue.add(start);

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            HashSet<Integer> children = visted.get(curr);
            HashSet<Pair> unique = new HashSet<>();

            for (int i = 0; i < A.length; i++) {
                if (children.contains(i)) {
                    continue;
                }

                Pair p = new Pair(curr.x + A[i], curr.y + 1);
                if (end_states.contains(p)) {
                    return true;
                }

                if (!unique.contains(p) && !visted.containsKey(p) && p.y <= A.length / 2) {
                    unique.add(p);

                    HashSet<Integer> new_set = copy(children, i);
                    visted.put(p, new_set);

                    queue.add(p);
                }
            }
        }

        return false;
    }
}

class Pair {
    public int x;
    public int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return ((x + y) * (x + y + 1) / 2) + y;
    }

    @Override
    public boolean equals(Object obj) {
        Pair o = (Pair) obj;
        return o.x == this.x && o.y == this.y;
    }
}