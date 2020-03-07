package app;

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        int[] paths = new App().shortestAlternatingPaths(3, new int[][] { { 0, 1 } }, new int[][] { { 1, 2 } });

        System.out.print("[ ");
        for (int i : paths) {
            System.out.print(i + ", ");
        }
        System.out.println("]");
    }

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        HashMap<Integer, List<State>> adjMap = constructAdjMap(red_edges, blue_edges);
        Queue<State> queue = new LinkedList<>();
        HashSet<State> seen = new HashSet<>();

        State start = new State(0, -1);
        queue.add(start);
        seen.add(start);

        int[] minPaths = preparePathArray(n);

        while (!queue.isEmpty()) {
            State curr = queue.poll();

            if (adjMap.containsKey(curr.node)) {
                List<State> neighStates = adjMap.get(curr.node);

                for (State state : neighStates) {
                    if (!seen.contains(state) && state.color != curr.color) {
                        state.distance = curr.distance + 1;

                        queue.add(state);
                        seen.add(state);

                        if (minPaths[state.node] == -1) {
                            minPaths[state.node] = state.distance;
                        }
                    }
                }
            }
        }

        return minPaths;
    }

    private int[] preparePathArray(int n) {
        int[] minPaths = new int[n];
        Arrays.fill(minPaths, -1);
        minPaths[0] = 0;

        return minPaths;
    }

    private HashMap<Integer, List<State>> constructAdjMap(int[][] red_edges, int[][] blue_edges) {
        HashMap<Integer, List<State>> adjMap = new HashMap<>();

        // populating red edges : 0 represents red edge
        populateEdges(adjMap, 0, red_edges);

        // populating blue edges : 1 represents blue edge
        populateEdges(adjMap, 1, blue_edges);

        return adjMap;
    }

    private void populateEdges(HashMap<Integer, List<State>> adjMap, int color, int[][] edges) {
        for (int[] edge : edges) {
            if (adjMap.containsKey(edge[0])) {
                adjMap.get(edge[0]).add(new State(edge[1], color));
            } else {
                List<State> neigh = new ArrayList<>();
                neigh.add(new State(edge[1], color));

                adjMap.put(edge[0], neigh);
            }
        }
    }

}

class State {
    public int node;
    public int color;
    public int distance;

    public State(int node, int color) {
        this.node = node;
        this.color = color;
        this.distance = 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof State) {
            State newState = (State) obj;
            return this.node == newState.node && this.color == newState.color;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.node, this.color);
    }

    @Override
    public String toString() {
        return " [" + node + " : " + color + "] ";
    }
}