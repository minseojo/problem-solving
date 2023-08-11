#include <iostream>
#include <vector>
#include <bits/stdc++.h>
using namespace std;

int n, m;
int graph[501][501];
int cache[501][501];
int dy[4] = {0,0,1,-1};
int dx[4] = {1,-1,0,0};

int dfs(int y, int x) {
    if(y == n-1 && x == m-1) return 1;

    int &ret = cache[y][x];
    if(ret != -1) return ret;

    ret = 0;
    for(int i=0; i<4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
        if(graph[y][x] <= graph[ny][nx]) continue;
        ret += dfs(ny, nx);
    }

    return ret;
}

int main() {
    cin.tie(NULL);
	ios::sync_with_stdio(false);
    cin >> n >> m;
    
    for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
            cin >> graph[i][j];
        }
    }
    memset(cache, -1, sizeof(cache));
    cout << dfs(0, 0);
    return 0;
}