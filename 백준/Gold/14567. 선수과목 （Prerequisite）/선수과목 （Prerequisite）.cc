#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> adj[32001];
int dag[32001];
bool visited[32001];
int ans[32001];

void dfs(int here) {
    visited[here] = true;
    for (int i = 0; i < adj[here].size(); i++) {
        int next = adj[here][i];
        dag[next]--;
        ans[next] = max(ans[next], ans[here]+1);
        if (dag[next] == 0 && !visited[next]) {
            dfs(next);    
        }
    }
}

int main() {
    int n, m;
    cin >> n >> m;
    
    for (int i = 0; i < m; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        dag[v]++;
    }
    
    for (int i = 1; i <= n; i++) {
        if (dag[i] == 0 && !visited[i]) {
            ans[i] = 1;
            dfs(i);
        }
    }

    for (int i = 1; i <= n; i++) {
        cout << ans[i] << " ";
    }
    return 0;
}