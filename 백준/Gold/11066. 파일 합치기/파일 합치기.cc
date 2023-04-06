#include <bits/stdc++.h>
using namespace std;

const int INF = 1e8;

int sum[505];
int dp[505][505];
int files[505];

int solve(int from, int to) {
	if(from == to) return files[from];
	
	int &ret = dp[from][to];
	if(ret != -1) return ret;
	
	ret = INF;
	for(int i=from; i<to; i++) {
		ret = min(ret, solve(from, i) + solve(i+1, to));
	}
	
	ret += (sum[to]-sum[from-1]); 
	return ret;
}

int main() {
	int tc;
	cin >> tc;
	while(tc--) {
		int k;
		cin >> k;
		
		memset(files, 0, sizeof(files));
		memset(sum, 0, sizeof(sum));
		memset(dp, -1, sizeof(dp));
		
		int file;
		for(int i=1; i<=k; i++) {
			cin >> files[i];
			sum[i] = files[i] + sum[i-1];
		}
		cout << solve(1, k)-sum[k] << "\n";
	}
}