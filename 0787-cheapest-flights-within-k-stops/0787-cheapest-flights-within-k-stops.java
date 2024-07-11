class Solution {

    static int MAX = 987654321;

    class Node implements Comparable<Node> {
        int id;
        int cost;
        int step;

        Node (int id, int cost) {
            this.id = id;
            this.cost = cost;
            this.step = 0;
        }

        Node (int id, int cost, int step) {
            this.id = id;
            this.cost = cost;
            this.step = step;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(this.cost, node.cost);
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {
        Map<Integer, List<Node>> graph = new HashMap<>();
        
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int c = flight[2];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.get(u).add(new Node(v, c));
        }

        return dijkstra(graph, n, src, dest, k);
    }

    private int dijkstra(Map<Integer, List<Node>> graph, int n, int src, int dest, int k) {
        Queue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n];
        Arrays.fill(dist, MAX);
        pq.add(new Node(src, 0));
        dist[src] = 0;

        Map<Integer, Integer> visited = new HashMap<>();

        while (!pq.isEmpty()) {
            int size = pq.size();
            while (size-- > 0) {
                Node cur = pq.poll();
                int id = cur.id;
                int cost = cur.cost;
                int step = cur.step;

                if (id == dest) return cost;
                if (step > k) continue;
                
                visited.put(id, step);

                for (Node next : graph.getOrDefault(id, new ArrayList<>())) {
                    int nextId = next.id;
                    int nextCost = next.cost;
                    if (!visited.containsKey(nextId) || step < visited.get(nextId))
                    pq.add(new Node(nextId, cost + nextCost, step + 1));
                }
            }
        }

        return -1;
    }
}