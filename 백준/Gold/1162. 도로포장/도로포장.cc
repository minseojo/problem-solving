#include <bits/stdc++.h>
#define ll long long
using namespace std;

struct Edge {
    int node;
    ll cost;
    int paved;
    bool operator<(const Edge& e) const {
        return cost > e.cost;
    }
};
vector<Edge> adj[10001];
ll dist[10001][21];
const ll INF = 1e11;
priority_queue<Edge> pq;    

ll dijkstra(int start, int end, int k) {
    for (int i = 1; i <= 10000; i++) {
        for (int j = 0; j <= 20; j++) {
            dist[i][j] = INF;
        }
    }
    pq.push({start, 0, 0});
    for (int i = 0; i <= k; i++) dist[start][i] = 0;
    while(!pq.empty()) {
        Edge e = pq.top();
        pq.pop();
        int node = e.node;
        ll cost = e.cost;
        int paved = e.paved;
        if (dist[node][paved] < cost) continue;

        for (int i = 0; i < adj[node].size(); i++) {
            int next_node = adj[node][i].node;
            ll next_cost = adj[node][i].cost;
            // 비포장
            if (dist[next_node][paved] > cost + next_cost) {
                dist[next_node][paved] = cost + next_cost;
                pq.push({next_node, dist[next_node][paved], paved});
            }
            // 포장
            if (paved < k && dist[next_node][paved+1] > cost) {
                dist[next_node][paved+1] = cost;
                pq.push({next_node, dist[next_node][paved+1], paved+1});
            }
        }
    }
    
    ll result = INF;
    for (int i = 0; i <= k; i++) {
        result = min(result, dist[end][i]);
    }
    return result;
}

int main() {
    int n, m, k;
    cin >> n >> m >> k;
    for (int i = 0; i < m; i++) {
        int u, v, c;
        cin >> u >> v >> c;
        adj[u].push_back({v, c, -1});
        adj[v].push_back({u, c, -1});
    }
    cout << dijkstra(1, n, k);
    return 0;
}