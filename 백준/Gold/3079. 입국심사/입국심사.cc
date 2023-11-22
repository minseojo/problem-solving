#include <bits/stdc++.h>
using namespace std;

int a[100000];

int main() {
    int N, M;
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        cin >> a[i];
    }
    long long l = 1, r = 1e18;
    while (l <= r) {
        long long m = (l + r) / 2;
        long long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (m / a[i]);
            if (sum > M) break;
        }
        if (sum < M) {
            l = m + 1;
        } else {
            r = m - 1;
        }
    }
    cout << l;
    return 0;
}