#include <bits/stdc++.h>
using namespace std;

const int MAX = 201;
int parent[MAX];

int find(int x) {
    if (x == parent[x]) return x;
    return find(parent[x]);
}

void merge(int u, int v) {
    u = find(u);
    v = find(v);
    if (u < v) parent[v] = u;
    else parent[u] = v;
}

int main() {
    int N, M;
    cin >> N >> M;
    for (int i = 1; i <= N; i++) parent[i] = i;
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            int x;
            cin >> x;
            if (x == 1) {
                merge(i, j);
            }
        }
    }

    int pre = -1;
    for (int i = 0; i < M; i++) {
        int x;
        cin >> x;
        x = find(x);
        
        if (pre == -1) {
            pre = x;
        }
        
        if (x != pre) {
            cout << "NO";
            return 0;
        }
        pre = x;
    }

    cout << "YES";
    return 0;
}