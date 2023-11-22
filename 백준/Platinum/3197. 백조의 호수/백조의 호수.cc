#include <bits/stdc++.h>
using namespace std;

struct Point {
    int y;
    int x;
};

const int MAX = 1500;
const int WATER = 0;
const int ICE = -1;
const int DUCK = 2;

int R, C;
int a[MAX][MAX];
bool visited[MAX][MAX];
int dy[4] = {0, 0, 1, -1};
int dx[4] = {1, -1, 0, 0};
Point swanStart;
queue<Point> swan, tempSwan;
queue<Point> water, tempWater;

bool isValidRange(int y, int x) {
    if (y < 0 || x < 0 || y >= R || x >= C) return false;
    return true;
}

bool BFS() {
    while (!swan.empty()) {
        int y = swan.front().y;
        int x = swan.front().x;
        swan.pop();
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (!isValidRange(ny, nx) || visited[ny][nx]) continue;
            visited[ny][nx] = true;
            if (a[ny][nx] == DUCK) return true;
            if (a[ny][nx] == WATER) swan.push({ny, nx});
            if (a[ny][nx] == ICE) tempSwan.push({ny, nx});
        }
    }

    while (!water.empty()) {
        int y = water.front().y;
        int x = water.front().x;
        water.pop();
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (!isValidRange(ny, nx) || visited[ny][nx]) continue;
            if (a[ny][nx] == ICE) {
                a[ny][nx] = WATER;
                tempWater.push({ny, nx});
            }
        }
    }

    swan = tempSwan;
    water = tempWater;
    while (!tempSwan.empty()) tempSwan.pop();
    while (!tempWater.empty()) tempWater.pop();
    return false;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> R >> C;

    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) { 
            char c;
            cin >> c;
            if (c == 'L') {
                a[i][j] = DUCK;
                swanStart.y = i;
                swanStart.x = j;
                water.push({i, j});
            }
            else if (c == '.') {
                a[i][j] = WATER;
                water.push({i, j});
            }
            else if (c == 'X') {
                a[i][j] = ICE;
            }
        }
    }
    visited[swanStart.y][swanStart.x] = true;
    swan.push({swanStart.y, swanStart.x});
    int ans = 0;
    while (1) {
        if (BFS()) break;
        ans++;
    }
    cout << ans; 
    return 0;
}