import java.util.Scanner;
 
public class Dijkstra {

    static int minDistance(int[] dist, boolean[] visited, int V) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }
        return min_index;
    }

    static void dijkstra(int[][] graph, int V, int src) {
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        // Initialize
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        dist[src] = 0;

        // Main loop
        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, visited, V);

            if (u == -1) break; // safety check

            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u] + graph[u][v] < dist[v]) {

                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // Print result
        System.out.println("Vertex\tDistance");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t" + dist[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V;

        // Restrict V < 4
        do {
            System.out.print("Enter number of vertices (<4): ");
            V = sc.nextInt();
        } while (V <= 0 || V >= 4);

        int[][] graph = new int[V][V];

        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        int src;
        do {
            System.out.print("Enter source vertex: ");
            src = sc.nextInt();
        } while (src < 0 || src >= V);

        dijkstra(graph, V, src);

        sc.close();
    }
}
