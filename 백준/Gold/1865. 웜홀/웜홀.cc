#include <iostream>
#include <vector>
#define endl '\n'
using namespace std;

struct Edge {
    int from;
    int to;
    int cost;
};
vector<Edge> adj;

const static int INF = 1e9;
long long dist[501];

bool bellmanFord(int n, int start) {
    for (int i = 1; i <= n; i++) dist[i] = INF;
    dist[start] = 0;
    for (int j = 0; j < n-1; j++) {
        for (int j = 0; j < adj.size(); j++) {
            int from = adj[j].from;
            int to = adj[j].to;
            int cost = adj[j].cost;
            if (dist[to] > dist[from] + cost) {
                dist[to] = dist[from] + cost;
            }
        }
    }
    for (int j = 0; j < adj.size(); j++) {
        int from = adj[j].from;
        int to = adj[j].to;
        int cost = adj[j].cost;
        if (dist[to] > dist[from] + cost) {
            return true;
        }
    } 
    return false;
}

int main() {
    int tc;
    cin >> tc;
    while(tc--) {
        int n, m, w;
        cin >> n >> m >> w;

        for (int i = 0; i < m; i++) {
            int a, b, c;
            cin >> a >> b >> c;
            adj.push_back({a, b, c});
            adj.push_back({b, a, c});
        }

        for (int i = 0; i < w; i++) {
            int a, b, c;
            cin >> a >> b >> c;
            adj.push_back({a, b, -c});
        }

        if (bellmanFord(n, 1)) cout << "YES" << endl;
        else cout << "NO" << endl;

        adj.clear();
    }
    return 0;
}