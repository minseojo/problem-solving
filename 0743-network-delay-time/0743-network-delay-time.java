class Solution {

    static int MAX_VALUE = 1_000_000;

    class Vertex implements Comparable<Vertex> {
        int node;
        int cost;

        Vertex(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Vertex vertex) {
            return Integer.compare(this.cost, vertex.cost);
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

        Queue<Vertex> pq = new PriorityQueue<>();
        pq.add(new Vertex(k, 0));
        dist[k] = 0;
        while (!pq.isEmpty()) {
            Vertex cur = pq.poll();
            int node = cur.node;
            int cost = cur.cost;

            if (dist[node] < cost) continue;

            for (Vertex next : graph.getOrDefault(node, new ArrayList<>())) {
                int nextNode = next.node;
                int nextCost = next.cost;
                if (dist[nextNode] > cost + nextCost) {
                    dist[nextNode] = cost + nextCost;
                    pq.add(new Vertex(nextNode, dist[nextNode]));
                } 
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dist[i] == MAX_VALUE) return -1;
            result = Math.max(result, dist[i]);
        }
        return result;
    }
}