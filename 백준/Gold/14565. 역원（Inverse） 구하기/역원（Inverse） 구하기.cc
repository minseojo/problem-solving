#include <bits/stdc++.h>
#define ll long long
using namespace std;

ll gcd(ll a, ll b) {
    if (b == 0) return a;
    return gcd(b, a % b);
}

ll x, y;
void ext_gcd(ll a, ll b) {
    if (b == 0) {
        x = 1;
        y = 0;
        return;
    }
    ext_gcd(b, a % b);
    ll temp = y;
    y = x - (a/b)*y;
    x = temp;
}

int main() {
    ll n, a;
    cin >> n >> a;
    if (gcd(n, a) == 1) {
        // ax + ny = 1
        ext_gcd(a, n);
        while(x <= 0) {
            x += n;
            y -= a;
        }
        cout << n-a << " " << x;
    }
    else {
        cout << n-a << " " << -1;
    }
    return 0;
}