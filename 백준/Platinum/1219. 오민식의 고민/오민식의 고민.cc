#include <iostream>
#include <vector>
using namespace std;

struct Edge {
    int from;
    int to;
    int cost;
};
vector<Edge> adj;

const static long long INF = -1e10;
long long dist[55];
long long earn[55];
bool check[55];

vector<int> route[55];
bool visited[55];
vector<int> findRoute;

void bellmanFord(int n, int start, int end) {
    for (int i = 0; i < n; i++) dist[i] = INF;
    dist[start] = earn[start];
    for (int j = 0; j < n; j++) {
        for (int j = 0; j < adj.size(); j++) {
            int from = adj[j].from;
            int to = adj[j].to;
            long long cost = adj[j].cost;
            if (dist[from] == INF) continue;
            if (dist[to] < dist[from] + cost + earn[to]) {
                dist[to] = dist[from] + cost + earn[to];
            }
        }
    }

    for (int j = 0; j < adj.size(); j++) {
        int from = adj[j].from;
        int to = adj[j].to;
        long long cost = adj[j].cost;
        if (dist[from] == INF) continue;
        if (dist[to] < dist[from] + cost + earn[to]) {
            findRoute.push_back(to);    
        }
    }
}

bool isGee = false;
void dfs(int here, int end) {
    visited[here] = true;
    if (here == end) {
        isGee = true;
        return;
    }
    for (int i = 0; i < route[here].size(); i++) {
        int next = route[here][i];
        if (visited[next]) continue;
        dfs(next, end);
    }
}
int main() {
    int n, start, end, m;
    cin >> n >> start >> end >> m;
    for (int i = 0; i < m; i++) {
        int a, b, c;
        cin >> a >> b >> c;
        adj.push_back({a, b, -c});
        route[a].push_back(b);
    }
    for (int i = 0; i < n; i++) {
        cin >> earn[i];
    }

    bellmanFord(n, start, end);

    if (dist[end] == INF) {
        cout << "gg";
    } else {
        for (int i = 0; i < findRoute.size(); i++) {
            if (!visited[findRoute[i]]) dfs(findRoute[i], end);
        }
        if (isGee) cout << "Gee";
        else cout << dist[end];
    }
    return 0;
}