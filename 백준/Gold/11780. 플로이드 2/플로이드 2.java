import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int MAX_DIST = 100_000_001;

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int[][] dist = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) dist[i][j] = 0;
                else dist[i][j] = MAX_DIST;
            }
        }

        List<List<List<Integer>>> route = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            route.add(new ArrayList<>());
            for (int j = 0; j <= n; j++) {
                route.get(i).add(new ArrayList<>());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (dist[a][b] > c) {
                dist[a][b] = c;
                route.get(a).get(b).clear();
                route.get(a).get(b).add(a);
                route.get(a).get(b).add(b);
            }
        }

        for (int k = 1; k <= n; k++) { // 중간
            for (int i = 1; i <= n; i++) { // 출발
                for (int j = 1; j <= n; j++) { // 도착
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        route.get(i).get(j).clear();
                        List<Integer> a = new ArrayList<>(route.get(i).get(k));
                        List<Integer> b = new ArrayList<>(route.get(k).get(j));
                        for (int l = 0; l < a.size(); l++) {
                            route.get(i).get(j).add(a.get(l));
                        }

                        for (int l = 1; l < b.size(); l++) {
                            route.get(i).get(j).add(b.get(l));
                        }
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == MAX_DIST) System.out.print(0 + " ");
                else System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(route.get(i).get(j).size() + " ");
                for (int k = 0; k < route.get(i).get(j).size(); k++) {
                    System.out.print(route.get(i).get(j).get(k) + " ");
                }
                System.out.println();
            }
        }
    }
}
