#include <bits/stdc++.h>
using namespace std;

vector<int> adj[101];
bool visited[101];

int bfs(int a, int b) {
    queue<int> q;
    q.push(a);
    visited[a] = true;
    int result = 0;
    while(!q.empty()) {
        int size = q.size();
        while(size--) {
            int here = q.front();
            if (here == b) return result;
            q.pop();
            for (int i = 0; i < adj[here].size(); i++) {
                int next = adj[here][i];
                if (!visited[next]) {
                    q.push(next);
                    visited[next] = true;
                }
            }
        }
        result++;
    }

    return -1;
}

int main() {
    int n, a, b, m;
    cin >> n >> a >> b >> m;
    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    cout << bfs(a, b);
    return 0;
}