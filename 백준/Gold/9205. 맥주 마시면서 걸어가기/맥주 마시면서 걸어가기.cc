#include <bits/stdc++.h>
using namespace std;

struct Point {
    int y;
    int x;
};
int n;
Point from, to;
vector<Point> v;
bool visited[100];

int myAbs(int num) {
    if (num < 0) return num * -1;
    return num;
}

bool isPossibleDist(int y, int x, int ny, int nx) {
    int dist = (myAbs(ny - y) + myAbs(nx - x)) / 50;
    if ((myAbs(ny - y) + myAbs(nx - x)) % 50 > 0) dist++;
    if (dist > 20) return false;
    return true;
}

bool BFS() {
    queue<Point> q;
    q.push({from.y, from.x});
    while (!q.empty()) {
        int size = q.size();
        int y = q.front().y;
        int x = q.front().x;
        q.pop();
        if (isPossibleDist(y, x, to.y, to.x)) return true;
        while (size--) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) continue;
                if (!isPossibleDist(y, x, v[i].y, v[i].x)) continue;
                visited[i] = true;
                q.push({v[i].y, v[i].x});
            }
        }
    }

    return false;
} 

int main() {
    int t;
    cin >> t;
    while (t--) {
        cin >> n;
        cin >> from.y >> from.x;
        for (int i = 0; i < n; i++) {
            int y, x;
            cin >> y >> x;
            v.push_back({y, x});
        }
        cin >> to.y >> to.x;

        if (BFS()) cout << "happy" << "\n";
        else cout << "sad" << "\n";
        memset(visited, false, sizeof(visited));
        v.clear();
    }
    return 0;
}