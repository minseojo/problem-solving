#include <bits/stdc++.h>
using namespace std;

int a[41];
int dp[41];
vector<int> v;
int main() {
	int n, m;
	cin >> n >> m;
	
	a[0] = -1;
	for (int i = 0; i < m; i++) {
		int x;
		cin >> x;
		a[x] = -1;
	}

	dp[1] = 1, dp[2] = 2;
	for (int i = 3; i <= n; i++) {
		dp[i] = dp[i-1] + dp[i-2];
	}
	
	int sequence = 0;
	for (int i = 1; i <= n; i++) {
		if (a[i] != -1) {
			sequence++;
		} else {
			if(sequence != 0) {
				v.push_back(dp[sequence]);
				sequence = 0;
			}
		}
	}
	if(sequence != 0) {
		v.push_back(dp[sequence]);
	}

	int ans = 1;
	for (int i : v) {
		ans *= i;
	}
	cout << ans;
}