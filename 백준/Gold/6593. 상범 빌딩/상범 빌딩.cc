#include <bits/stdc++.h>
#define MAX 30
using namespace std;

struct Point {
    int z;
    int y;
    int x;
};

int L, R, C;
char builiding[MAX][MAX][MAX];
bool visited[MAX][MAX][MAX];
int dir[6][3] = {{0, 0, 1}, {0, 0, -1}, {0, 1, 0}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}};

int BFS(Point start, Point end) {
    queue<Point> q;
    q.push({start.z, start.y, start.x});
    visited[start.z][start.y][start.x] = true;
    int result = 0;
    while (!q.empty()) {
        int size = q.size();
        while (size--) {
            int z = q.front().z;
            int y = q.front().y;
            int x = q.front().x;
            if (z == end.z && y == end.y && x == end.x) {
                return result;
            }
            q.pop();
            for (int i = 0; i < 6; i++) {
                int nz = z + dir[i][0];
                int ny = y + dir[i][1];
                int nx = x + dir[i][2];
                if (nz < 0 || ny < 0 || nx < 0 || nz >= L || ny >= R || nx >= C) continue;
                if (visited[nz][ny][nx] || builiding[nz][ny][nx] == '#') continue;
                visited[nz][ny][nx] = true;
                q.push({nz, ny, nx});
            }
        }
        result++;
    }

    return -1;
}

int main() {
    while (1) {
        cin >> L >> R >> C;
        if (L == 0 && R == 0 && C == 0) {
            break;   
        }

        Point start, end;
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < R; j++) {
                for (int k = 0; k < C; k++) {
                    cin >> builiding[i][j][k];
                    if (builiding[i][j][k] == 'S') {
                        start = {i, j, k};
                    }
                    if (builiding[i][j][k] == 'E') {
                        end = {i, j, k};
                    }
                }
            }
        }
        int ans = BFS(start, end);
        if (ans == -1) cout << "Trapped!" << "\n";
        else cout << "Escaped in " << ans  << " minute(s)." << "\n";
        memset(builiding, 0, sizeof(builiding));
        memset(visited, false, sizeof(visited));
    }
}