#include <bits/stdc++.h>
using namespace std;

int a[100000];

int main() {
    int N, M, mn = 0;
    cin >> N >> M;
    int l = 1, r = 1;
    for (int i = 0; i < N; i++) {
        cin >> a[i];
        r += a[i];
        mn = max(mn, a[i]);
    }
    int ans = 1e9;
    while (l <= r) {
        int m = (l + r) / 2;
        int cost = 0, cnt = 0;
        for (int i = 0; i < N; i++) {
            if (cost < a[i]) {
                cost = m;
                cnt++;
            }
            cost -= a[i];
        }
        if (cnt > M || m < mn) {
            l = m + 1;
        } else {
            ans = min(ans, m);
            r = m - 1;
        }
    }
    cout << l;
    return 0;
}