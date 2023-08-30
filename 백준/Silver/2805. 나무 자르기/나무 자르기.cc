#include <bits/stdc++.h>
using namespace std;

int a[1000000];

int main() {
    int N, M;
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        cin >> a[i];
    }

    int l = 0, r = 2e9;
    while (l <= r) {
        int m = (l + r) / 2;
        long long sum = 0;
        for (int i = 0; i < N; i++) {
            if (a[i] - m > 0) sum += (a[i] - m);
        }

        if (sum < M) r = m - 1;
        else l = m + 1;
    }
    cout << l - 1;
    return 0;
}