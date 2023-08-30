#include <bits/stdc++.h>
using namespace std;

int N, M;
int a[100000];

bool check(int m) {
    int cnt = 1, sum = 0;
    for (int i = 0; i < N; i++) {
        if (sum + a[i] > m) {
            cnt++;
            sum = a[i];
        } else {
            sum += a[i];
        }
    }
    return cnt <= M;
}
int main() {
    cin >> N  >> M;
    int l = 1, r = 1e9, mn = 0;
    for (int i = 0; i < N; i++) {
        cin >> a[i];
        mn = max(mn, a[i]);
    }

    int ans = 1e9;
    while (l <= r) {
        int m = (l + r) / 2;
        if (mn <= m && check(m)) {
            ans = min(ans, m);
            r = m - 1;
        } else {
            l = m + 1;
        }
    }

    cout << ans;
    return 0;
}