#include <bits/stdc++.h>
using namespace std;

struct Point {
	int x, y;
};

int N;
vector<Point> police;
Point thief;

const int UP = 0;
const int DOWN = 1;
const int LEFT = 2;
const int RIGHT = 3;
const int PLUS = 1e9;
long long dist[4];

int MyAbs(int x) {
    if (x < 0) return -x;
    return x;
}

int main() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		int x, y;
		cin >> x >> y;
        police.push_back({x, y});
	}
	cin >> thief.x >> thief.y;

    for (int i = 0; i < 4; i++) dist[i] = 4e9 + 1;
    for (Point p : police) {
        // thief.x, 1e9
        // thief.x, -1e9
        // -1e9, thief.y
        // 1e9, thief.y 
        dist[UP] = min(dist[UP], MyAbs(thief.x - p.x) + (long long) (PLUS - p.y));
        dist[DOWN] = min(dist[DOWN], MyAbs(thief.x - p.x) + (long long) (PLUS + p.y));
        dist[LEFT] = min(dist[LEFT], (long long) (PLUS + p.x) + MyAbs(thief.y - p.y));
        dist[RIGHT] = min(dist[RIGHT], (long long) (PLUS - p.x) + MyAbs(thief.y - p.y));
    }

    bool ok = false;
    if (dist[UP] > PLUS - thief.y) ok = true;
    if (dist[DOWN] > PLUS + thief.y) ok = true;
    if (dist[LEFT] > PLUS + thief.x) ok = true;
    if (dist[RIGHT] > PLUS - thief.x) ok = true;
    if (ok) cout << "YES";
    else cout << "NO";
    return 0;
}