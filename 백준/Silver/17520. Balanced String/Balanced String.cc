#include <bits/stdc++.h>
using namespace std;

const int MOD = 16769023;

int dp[100001];
int main() {
	int n;
	cin >> n;
	dp[1] = dp[2] = 2;
	for (int i = 3; i <= n; i+=2) {
		dp[i] = dp[i + 1] = ((dp[i - 1] % MOD) * 2) % MOD;
	}
	cout << dp[n];
	return 0;
}