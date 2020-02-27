package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] graph = new int[n][];
        initGraph(graph, n);

        // making graph adjucancy list
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }

        dijkstra(graph);

        return getMinCity(graph, distanceThreshold);
    }

    public int getMinCity(int[][] graph, int distanceThreshold) {
        int minCity = Integer.MAX_VALUE;
        int min = 0;

        for (int city = 0; city < graph.length; city++) {
            int currCityCount = 0;

            for (int dist = 0; dist < graph[city].length; dist++) {
                if (graph[city][dist] != 0 && graph[city][dist] <= distanceThreshold) {
                    currCityCount++;
                }
            }

            if (minCity >= currCityCount) {
                minCity = currCityCount;
                min = city;
            }
        }

        return min;
    }

    public void initGraph(int[][] graph, int n) {
        for (int row = 0; row < n; row++) {
            graph[row] = new int[n];

            for (int column = 0; column < graph[row].length; column++) {
                graph[row][column] = row == column ? 0 : 10001;
            }
        }
    }

    public void dijkstra(int[][] graph) {
        for (int mid = 0; mid < graph.length; mid++) {

            for (int start = 0; start < graph.length; start++) {
                for (int end = 0; end < graph.length; end++) {
                    graph[start][end] = Math.min(graph[start][end], graph[start][mid] + graph[mid][end]);
                    graph[end][start] = graph[start][end];
                }
            }

        }
    }

}