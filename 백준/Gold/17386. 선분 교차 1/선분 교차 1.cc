#include <bits/stdc++.h>
#define ll long long
using namespace std;

struct P {
    ll x;
    ll y;
};
vector<P> p;

int ccw(P p1, P p2, P p3) {
    ll res = p1.x * p2.y + p2.x * p3.y + p3.x * p1.y - (p1.y * p2.x + p2.y * p3.x + p3.y * p1.x);
    if (res > 0) return 1;
    else if (res == 0) return 0;
    else return -1;
}

int main() {
    for (int i = 0; i < 4; i++) {
        int x, y;
        cin >> x >> y;
        p.push_back({x, y});
    } 
    ll a = ccw(p[0], p[1], p[2]) * ccw(p[0], p[1], p[3]);
    ll b = ccw(p[2], p[3], p[0]) * ccw(p[2], p[3], p[1]);
    if (a < 0 && b < 0) { // x 자 모양
        cout << 1;
    } else if (a == 0 && b == 0) { // 같은 직선에 있는 경우, but 문제에서는 이 상황이 없다함. 원래 추가과정이 필요함.
        // 추가 코드...
        cout << 1;
    } else { // 안겹치는 경우
        cout << 0;
    }
    return 0;
}