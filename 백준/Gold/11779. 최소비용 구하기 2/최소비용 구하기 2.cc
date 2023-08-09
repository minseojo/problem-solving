#include <iostream>
#include <vector>
#include <queue>
#include <stack>
using namespace std;

struct Edge {
    int node;
    int cost;
    bool operator< (const Edge& a) const {
        return cost > a.cost;
    }
};
priority_queue<Edge> pq;
vector<Edge> adj[1001];
vector<Edge> rAdj[1001];
int dist[1001];
const int INF = 1e9;
int route[1001];

void dijkstra(int start, int end) {
    pq.push({start, 0});
    dist[start] = 0;
    while(!pq.empty()) {
        int node = pq.top().node;
        int cost = pq.top().cost;
        pq.pop();

        if (cost > dist[node]) continue;

        for (int i = 0; i < adj[node].size(); i++) {
            int next_node = adj[node][i].node;
            int next_cost = adj[node][i].cost;
            if (dist[next_node] > cost + next_cost) {
                route[next_node] = node;
                dist[next_node] = cost + next_cost;
                pq.push({next_node, dist[next_node]});
            }
        }
    }
}

void findRoute(int start, int end) {
    int node = end;
    stack<int> ans;
    while(node != start) {
        ans.push(node);
        node = route[node];
    }
    ans.push(start);
    cout << dist[end] << endl;
    cout << ans.size() << endl;
    while(!ans.empty()) {
        cout << ans.top() << " ";
        ans.pop();
    }
}
int main() {
    int n, m;
    cin >> n >> m;
    for (int i = 1; i <= n; i++) dist[i] = INF;
    for (int i = 0 ; i < m; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        adj[u].push_back({v, w});
        rAdj[v].push_back({u, w});
    }
    int start, end;
    cin >> start >> end;
    
    dijkstra(start, end);
    findRoute(start, end);

    return 0;
}