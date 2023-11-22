#include <iostream>
#include <vector>
#include <math.h>
#include <queue>
using namespace std;

struct Edge {
    int node;
    int cost;
};

vector<int> adj[501];
int dag[501];
int dist[501];
int ans[501];
bool visited[501];

void dfs(int here) {
    visited[here] = true;
    for (int i = 0; i < adj[here].size(); i++) {
        int next = adj[here][i];
        dag[next]--;
        ans[next] = max(ans[next], dist[next] + ans[here]);
        if (!visited[next] && dag[next] == 0) {
            dfs(next);
        }
    }
}

int main() {
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        cin >> dist[i];
        while(1) {
            int node;
            cin >> node;
            if (node == -1) break;
            adj[node].push_back(i);
            dag[i]++;
        }
    }
    for (int i = 1; i <= n; i++) {
        if (dag[i] == 0 && !visited[i]) {
            ans[i] = dist[i];
            dfs(i);
        }
    }
    for (int i = 1; i <= n; i++) {
        cout << ans[i] << endl;
    }
    return 0;
}