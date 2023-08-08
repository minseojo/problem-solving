#include <iostream>
#include <vector>
#include <algorithm>
#include <math.h>
#include <string.h>
#include <queue>
#include <set>

using namespace std;

struct Point {
    int to;
    int cost;
};

vector<Point> adj[10001];
vector<Point> rAdj[10001];
int dag[10001];
int rDag[10001];
int ans_time[10001];

void dfs(int here, int to) {
    for (int i = 0; i < adj[here].size(); i++) {
        int next = adj[here][i].to;
        int cost = adj[here][i].cost;
        dag[next]--;
        ans_time[next] = max(ans_time[next], ans_time[here] + cost);
        if (dag[next] == 0) {
            dfs(next, to);
        }
    }
}

int ans = 0;
void findRoute(int dest) {
    bool visited[10001] = {0};
    memset(visited, 0, sizeof(visited));
    queue<int> q;
    q.push(dest);
    visited[dest] = true;
    while(!q.empty()) {
        int from = q.front();
        q.pop();
        for (int i = 0; i < rAdj[from].size(); i++) {
            int next = rAdj[from][i].to;
            int next_cost = rAdj[from][i].cost;
            rDag[next]--;
            if (visited[from] && (ans_time[from] - next_cost) == ans_time[next]) {
                visited[next] = true;
                ans++;
            } 
            if (rDag[next] == 0) {
                q.push(next);
            }
        }
    }
}

int main() {
    int n, m;
    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        int u, v, c;
        cin >> u >> v >> c;
        adj[u].push_back({v, c});
        rAdj[v].push_back({u, c});
        dag[v]++;
        rDag[u]++;
    }

    int from, to;
    cin >> from >> to;

    if (dag[from] == 0) {
        ans_time[from] = 0;
        dfs(from, to);
        findRoute(to);
        cout << ans_time[n] << endl;
        cout << ans;
    }

    return 0;
}