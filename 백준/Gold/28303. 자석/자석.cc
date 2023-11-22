#include <bits/stdc++.h>
#define MAX 500000
using namespace std;

int N, K;
int a[MAX];

int main() {
    cin >> N >> K;
    for (int i = 0; i < N; i++) {
        cin >> a[i];
    }
    
    int ans = -1e9;
    for (int tc = 0; tc < 2; tc++) {
        int mn = a[0];
        for (int i = 1; i < N; i++) {
            ans = max(ans, a[i] - K * i - mn);
            mn = min(mn, a[i] - K * i);
        }
        reverse(a, a+N);
    }

    cout << ans << "\n";
    return 0;
}