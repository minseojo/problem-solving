#include <bits/stdc++.h>
using namespace std;

int n;
int a[1111];
int dp[1111];

int main() {
	cin >> n;
	for(int i=1; i<=n; i++) {
		cin >> a[i];
		dp[i] = a[i];
	}
	
	for(int i=2; i<=n; i++) {
		for(int j=1; j<=i; j++) {
			dp[i] = min(dp[i], dp[i-j] + dp[j]);
		}
	}
	
	cout << dp[n];
	return 0;
}
