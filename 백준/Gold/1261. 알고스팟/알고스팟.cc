#include <iostream>
#include <queue>
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
priority_queue<Point, vector<Point>, comp> pq;

int a[101][101];
int dist[101][101];
int dy[4] = {0, 0, 1, -1};
int dx[4] = {1, -1, 0, 0};

void dijkstra(int n, int m) {

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            dist[i][j] = 1e5;
        }
    }


    if (a[0][0] == 0) {
        pq.push({0, 0, 0});
        dist[0][0] = 0;
    }

    while(!pq.empty()) {
        Point p = pq.top();
        pq.pop();
        int y = p.y;
        int x = p.x;
        int cost = p.cost;
        if (dist[y][x] < cost) continue;
        if (y == n-1 && x == m-1) continue;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
            if (a[ny][nx] == 1) {
                if (dist[ny][nx] > cost+1) {
                    dist[ny][nx] = cost+1;
                    pq.push({ny, nx, dist[ny][nx]});
                }
            } else {
                if (dist[ny][nx] > cost) {
                    dist[ny][nx] = cost;
                    pq.push({ny, nx, dist[ny][nx]});
                }
            }
        }
        
    }
}

int main() {
    int n, m;
    cin >> m >> n;
    for (int i = 0; i < n; i++) {
        string str;
        cin >> str;
        for (int j = 0; j < m; j++) {
            a[i][j] = str[j]-'0';
        }
    }

    dijkstra(n, m);

    cout << dist[n-1][m-1];
    return 0;
}