#include <bits/stdc++.h>
using namespace std;

int n;
int dp[50001];

int main() {
	cin >> n;
	dp[1] = 1;
	
	for(int i=2; i<=n; i++) {
		dp[i] = dp[1] + dp[i-1];
		for(int j=2; j*j <= i; j++) {
			dp[i] = min(dp[i], dp[i-j*j]+1);
		}
	}
	cout << dp[n];
}