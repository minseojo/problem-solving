#include <bits/stdc++.h>
#define MAX 100001
#define MOD 9901
using namespace std;

int N;
int dp[MAX][3]; // 안넣은거, 왼쪽, 오른쪽 

int main() {
	cin >> N;
	dp[1][0] = dp[1][1] = dp[1][2] = 1;
	 
	for (int i = 2; i <= N; i++) {
		dp[i][0] = dp[i-1][0] % MOD + dp[i-1][1] % MOD + dp[i-1][2] % MOD;
		dp[i][1] = dp[i-1][0] % MOD + dp[i-1][2] % MOD;
		dp[i][2] = dp[i-1][0] % MOD + dp[i-1][1] % MOD;
	}
	
	int ans = 0;
	for (int i = 0; i < 3; i++) {
		ans += (dp[N][i] % MOD) ;
	}
	cout << ans % MOD;
	return 0;
}