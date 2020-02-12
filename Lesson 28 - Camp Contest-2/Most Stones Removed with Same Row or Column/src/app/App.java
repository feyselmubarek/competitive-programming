package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(
                new App().removeStones(new int[][] { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 2 }, { 2, 1 }, { 2, 2 } }));
    }

    public int removeStones(int[][] stones) {
        HashMap<Point, List<Point>> adj = generateAdjacency(stones);
        HashSet<Point> visted = new HashSet<>();
        Queue<Point> queue = new LinkedList<>();

        int currMax = 0;
        int max = 0;

        for (Point p_key : adj.keySet()) {
            currMax = 0;

            if (!visted.contains(p_key)) {

                visted.add(p_key);
                queue.add(p_key);

                while (!queue.isEmpty()) {
                    Point curr = queue.poll();
                    List<Point> list = adj.get(curr);

                    for (Point neghPoint : list) {
                        if (!visted.contains(neghPoint)) {
                            visted.add(neghPoint);
                            currMax++;
                            queue.add(neghPoint);
                        }
                    }

                }

                max += currMax;
            }
        }

        return max;
    }

    public HashMap<Point, List<Point>> generateAdjacency(int[][] data) {

        HashMap<Point, List<Point>> adjList = new HashMap<>();

        for (int i = 0; i < data.length; i++) {
            Point p = new Point(data[i][0], data[i][1]);
            ArrayList<Point> list = new ArrayList<>();

            for (int j = 0; j < data.length; j++) {
                Point adj = new Point(data[j][0], data[j][1]);

                if ((adj.i == p.i || adj.j == p.j) && !adj.equals(p)) {
                    list.add(adj);
                }
            }

            adjList.put(p, list);
        }

        return adjList;
    }
}

class Point {
    public int i;
    public int j;

    public Point(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public int hashCode() {
        return (i + "," + j).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Point p = (Point) obj;
        return p.i == this.i && p.j == this.j;
    }
}