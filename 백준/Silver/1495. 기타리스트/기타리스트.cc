#include <bits/stdc++.h>
using namespace std;

int a[51];
bool dp[51][1001];

int main() {
    int N, S, M;
    cin >> N >> S >> M;
    for (int i = 1; i <= N; i++) cin >> a[i];

    if (S + a[1] <= M) dp[1][S + a[1]] = true;
    if (S - a[1] >= 0) dp[1][S - a[1]] = true;   
    for (int i = 2; i <= N; i++) {
        int volume = a[i];
        for (int j = 0; j <= M; j++) {
            if (dp[i - 1][j]) {
                if (j + volume<= M) dp[i][j + volume] = true;
                if (j - volume >= 0) dp[i][j - volume] = true;
            }
        }
    }

    for (int i = M; i >= 0; i--) {
        if (dp[N][i]) {
            cout << i << "\n";
            return 0;
        }
    }
    
    cout << -1 << "\n";
    return 0;
}