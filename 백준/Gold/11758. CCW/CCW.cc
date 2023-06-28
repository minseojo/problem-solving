#include <bits/stdc++.h>
using namespace std;

struct P {
    int x;
    int y;
};
vector<P> p;

int ccw(P p1, P p2, P p3) {
    return p1.x * p2.y + p2.x * p3.y + p3.x * p1.y - (p1.y * p2.x + p2.y * p3.x + p3.y * p1.x);
}
int main() {
    for (int i = 0; i < 3; i++) {
        int x, y;
        cin >> x >> y;
        p.push_back({x, y});
    }
    int d = ccw(p[0], p[1], p[2]);
    if (d < 0) {
        cout << -1;
    } else if (d == 0) {
        cout << 0;
    } else {
        cout << 1;
    }
    return 0;
}