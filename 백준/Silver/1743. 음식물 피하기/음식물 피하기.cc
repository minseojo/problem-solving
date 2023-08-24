#include <bits/stdc++.h>
using namespace std;

int a[101][101];
bool visited[101][101];
int dy[4] = {1, -1, 0, 0};
int dx[4] = {0, 0, 1, -1};


int dfs(int y, int x, int n, int m) {
    int nodes = 1;
    visited[y][x] = true;
    for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if (ny < 1 || nx < 1 || ny > n || nx > m || visited[ny][nx]) continue;
        if (a[ny][nx] == 1) nodes += dfs(ny, nx, n, m);
    }

    return nodes;
}

int main() {
    int n, m, k;
    cin >> n >> m >> k;
    for (int i = 0; i < k; i++) {
        int y, x;
        cin >> y >> x;
        a[y][x] = 1;
    }

    int ans = 0;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            if (a[i][j] == 1 && !visited[i][j]) {
                ans = max(ans, dfs(i, j, n, m));
            }
        }
    }

    cout << ans;
    return 0;
}