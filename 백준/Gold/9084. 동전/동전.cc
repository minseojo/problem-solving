#include <bits/stdc++.h>
using namespace std;

int T, N, M;
vector<int> coin;
int dp[10001];

void solve() {
	dp[0] = 1;
	for(int c : coin) {
		for(int i=c; i<=M; i++) {
			dp[i] += dp[i-c]; 
		}
	}
}

int main() {
	cin >> T;
	while(T--) {
		cin >> N;
		int c;
		memset(dp, 0, sizeof(dp));
		coin.clear();
		for(int i=0; i<N; i++) {
			cin >> c;
			coin.push_back(c);
		}
		
		sort(coin.begin(), coin.end());
		cin >> M;
		solve();
		cout << dp[M] << endl;
	}
}