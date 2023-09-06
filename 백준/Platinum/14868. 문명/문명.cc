#include <bits/stdc++.h>
#define MAX 2001
using namespace std;

struct Point {
    int y;
    int x;
};

int N, K;
int parent[100001];
int road[MAX][MAX];
queue<Point> union_q;
queue<Point> spread_q;
int find(int x) {
    if (x == parent[x]) return x;
    return parent[x] = find(parent[x]);
}

void merge(int u, int v) {
    u = find(u);
    v = find(v);
    if (u != v) parent[v] = u;
}

void BFS() {
    int dy[4] = {0, 0, 1, -1};
    int dx[4] = {1, -1, 0, 0};

    while (!union_q.empty()) { // 주변에 문명이 있는지 확인하는 BFS
        int y = union_q.front().y;
        int x = union_q.front().x;
        union_q.pop();
        spread_q.push({y, x});
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 1 || nx < 1 || ny > N || nx > N || road[ny][nx] == 0) continue;
            if (road[y][x] == road[ny][nx] || find(road[y][x]) == find(road[ny][nx])) continue; // 같은 문명인지 확인
            merge(road[y][x], road[ny][nx]);
            K--;
            if (K == 1) return;
        }
    }

    while(!spread_q.empty()) {
        int y = spread_q.front().y;
        int x = spread_q.front().x;
        spread_q.pop();
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 1 || nx < 1 || ny > N || nx > N || road[ny][nx] != 0) continue;
            road[ny][nx] = road[y][x]; // 문명 확장
            union_q.push({ny, nx}); // 문명 확장 후, 확장한 문명 주변에 다른 문명이 있는지 확인 해야한다.
        }
    }
}

int main() {
    cin >> N >> K;
    for (int i = 1; i <= K; i++) parent[i] = i;
    for (int i = 1; i <= K; i++) {
        int y, x;
        cin >> y >> x;
        road[y][x] = i;
        union_q.push({y, x});
    }

    int ans = 0;
    while (K > 1) {
        BFS();
        ans++;
    }
    cout << ans - 1; 
    return 0;
}