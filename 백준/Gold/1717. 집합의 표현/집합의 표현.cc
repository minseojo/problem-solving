#include <bits/stdc++.h>
using namespace std;

const int MAX = 1000001;
int parent[MAX];

int find(int x) {
    if (x == parent[x]) return x;
    return parent[x] = find(parent[x]);
}

void merge(int u, int v) {
    u = find(u);
    v = find(v);
    if (u < v) parent[v] = u;
    else parent[u] = v;
}

int main() {
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);

    int N, M;
    cin >> N >> M;
    for (int i = 1; i <= N; i++) parent[i] = i;

    for (int i = 0; i < M; i++) {
        int type, u, v;
        cin >> type >> u >> v;
        if (type == 0) merge(u, v);
        else if (type == 1) {
            u = find(u);
            v = find(v);
            if (u == v) cout << "YES\n";
            else cout << "NO\n";
        }
    }

    return 0;
}