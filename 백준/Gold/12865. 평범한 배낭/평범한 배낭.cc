// 0-1 Knapsack
#include <bits/stdc++.h>
using namespace std;

struct St {
	int w;
	int v;
};

vector<St> v;
int dp[110][100001];

int main() {
	int n, k;
	cin >> n >> k;
	
	int W, V;
	v.push_back({-1, -1});
	for(int i=0; i<n; i++) {
		cin >> W >> V;
		v.push_back({W, V});
	}
	
	
	for(int i=1; i<=n; i++) {
		for(int j=1; j<=k; j++) {
			if(j >= v[i].w) {
				dp[i][j] = max(dp[i-1][j], dp[i-1][j-v[i].w] + v[i].v);  	
			} else dp[i][j] = dp[i-1][j];
		}
	}
	
	cout << dp[n][k];
}