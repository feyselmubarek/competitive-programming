package app;

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(new App().canFinish(3, new int[][] { { 1, 0 }, { 1, 2 }, { 0, 1 } }));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][1];

            if (adjList.containsKey(course)) {
                adjList.get(course).add(prerequisites[i][0]);
            } else {
                List<Integer> nigh = new ArrayList<>();
                nigh.add(prerequisites[i][0]);

                adjList.put(course, nigh);
            }
        }

        int[] check = new int[numCourses];

        for (int key : adjList.keySet()) {
            List<Integer> nigh = adjList.get(key);

            for (int i : nigh) {
                check[i] += 1;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        int coursesCoverd = 0;
        for (int i = 0; i < check.length; i++) {
            if (check[i] == 0) {
                queue.add(i);
                coursesCoverd++;
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (adjList.containsKey(current)) {
                List<Integer> currList = adjList.get(current);

                for (int nd : currList) {
                    check[nd] -= 1;

                    if (check[nd] == 0) {
                        queue.add(nd);
                        coursesCoverd++;
                    }
                }
            }
        }

        return coursesCoverd == numCourses;
    }
}