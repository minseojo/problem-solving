#include <bits/stdc++.h>
using namespace std;

int rule[10000][3];

int main() {
    int N, K;
    long long D;
    cin >> N >> K >> D;
    for (int i = 0; i < K; i++) {
        cin >> rule[i][0] >> rule[i][1] >> rule[i][2];
    }

    int l = 1, r = N, ans = 1e6;
    while (l <= r) {
        int m = (l + r) / 2;

        long long d = 0;
        for (int i = 0; i < K; i++) {
            int x = min(m, rule[i][1]);
            if (rule[i][0] <= x) {
                d = d + (x - rule[i][0]) / rule[i][2] + 1;
            }
        }

        if (d >= D) {
            ans = min(ans, m);
            r = m - 1;
        } else {
            l = m + 1;
        }
    }
    cout << ans;
}