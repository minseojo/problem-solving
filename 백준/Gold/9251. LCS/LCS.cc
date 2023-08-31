#include <bits/stdc++.h>
using namespace std;

int dp[1000];

int main() {
    string a, b;
    cin >> a >> b;
    for (int i = 0; i < a.size(); i++) {
        int cnt = 0;
        for (int j = 0; j < b.size(); j++) {
            if (cnt < dp[j]) cnt = dp[j];
            else if (a[i] == b[j]) {
                dp[j] = cnt + 1;
            }
        }
    }
    int ans = 0;
    for (int i = 0; i < b.size(); i++) {
        ans = max(ans, dp[i]);
    }
    cout << ans;
    return 0;
}