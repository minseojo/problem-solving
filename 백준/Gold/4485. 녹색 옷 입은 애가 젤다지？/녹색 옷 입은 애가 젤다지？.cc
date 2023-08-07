#include <iostream>
#include <queue>
#include <string.h>
using namespace std;

struct Point {
    int y;
    int x;
    int cost;
};

struct comp {
    bool operator()(Point &a, Point &b) {
        return a.cost > b.cost;
    }
};

int a[150][150];
int dist[150][150];
int dy[4] = {0, 0, 1, -1};
int dx[4] = {1, -1, 0, 0};

void dijkstra(int n) {
    priority_queue<Point, vector<Point>, comp> pq;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            dist[i][j] = 1e5;
        }
    }

    pq.push({0, 0, a[0][0]});
    dist[0][0] = a[0][0];

    while(!pq.empty()) {
        Point p = pq.top();
        pq.pop();
        int y = p.y;
        int x = p.x;
        int cost = p.cost;
        if (dist[y][x] < cost) continue;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
            if (dist[ny][nx] > a[ny][nx] + cost) {
                dist[ny][nx] = a[ny][nx] + cost;
                pq.push({ny, nx, dist[ny][nx]});
            }
        }
    }
}

int main() {
    for (int i = 1; ; i++) {
        int n;
        cin >> n;
        if (n == 0) break;
        memset(a, 0, sizeof(a));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cin >> a[i][j];
            }
        }
        dijkstra(n);
        cout << "Problem " << i << ": " <<  dist[n-1][n-1] << endl;
    }
    return 0;
}