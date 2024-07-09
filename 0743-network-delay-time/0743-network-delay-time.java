class Solution {

    static int MAX_VALUE = 1_000_000;

    class Vertex {
        int here;
        int cost;

        Vertex(int here, int cost) {
            this.here = here;
            this.cost = cost;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Vertex>> graph = new HashMap<>();
        
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(new Vertex(v, w));
        }

        return dijkstra(graph, k, n);
    }

    int dijkstra(Map<Integer, List<Vertex>> graph, int k, int n) {
        int result = -1;

        int[] dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = MAX_VALUE;
        }

        Queue<Vertex> pq = new PriorityQueue<>((V1, V2) -> Integer.compare(V1.cost, V2.cost));
        pq.add(new Vertex(k, 0));
        dist[k] = 0;
        while (!pq.isEmpty()) {
            Vertex cur = pq.poll();
            int here = cur.here;
            int cost = cur.cost;

            if (dist[here] > cost) continue;

            if (graph.get(here) != null) {
                for (Vertex next : graph.get(here)) {
                    if (dist[next.here] > cost + next.cost) {
                        dist[next.here] = cost + next.cost;
                        pq.add(new Vertex(next.here, dist[next.here]));
                    } 
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int d = dist[i];
            if (d == MAX_VALUE) return -1;
            result = Math.max(result, d);
        }
        return result;
    }
}