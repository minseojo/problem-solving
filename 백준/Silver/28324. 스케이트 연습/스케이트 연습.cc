#include <bits/stdc++.h>
using namespace std;

long long a[500000];

int main() {
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }

    a[n-1] = 1;
    for (int i = n-2; i >= 0; i--) {
        if (a[i] > a[i+1]) {
            a[i] = a[i+1] + 1;
        }
    }

    long long ans = 0;
    for (int i = 0; i < n; i++) {
        ans += a[i];
    }
    cout << ans;
    return 0;
}