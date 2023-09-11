#include <bits/stdc++.h>
using namespace std;

struct Edge {
    int from;
    int to;
    int width;
};

int p, w, c, v;
int parent[1000];
vector<Edge> adj;
bool Comp(const Edge& a, const Edge& b) {
    return a.width > b.width;
}

int Find(int x) {
    if (x == parent[x]) return x;
    return parent[x] = Find(parent[x]);
}

void Merge(int u, int v) {
    u = Find(u);
    v = Find(v);
    if (u < v) parent[v] = u;
    else parent[u] = v;
}

int main() {
    cin >> p >> w >> c >> v;
    for (int i = 0; i < p; i++) parent[i] = i; // makeSet

    for (int i = 0; i < w; i++) {
        int start, end, width;
        cin >> start >> end >> width;
        adj.push_back({start, end, width});
    }
    sort(adj.begin(), adj.end(), Comp);

    for (Edge e : adj) {
        if (Find(e.from) != Find(e.to)) {
            Merge(e.from, e.to);
        }
        if (Find(c) == Find(v)) {
            cout << e.width;
            break;
        }
    }
    return 0;
}