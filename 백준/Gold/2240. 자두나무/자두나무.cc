#include <bits/stdc++.h>
using namespace std;

int a[1001];
int dp[1001][31][3]; // 시간, 이동횟수, 현재위치 

int main() {
	int t, w;
	cin >> t >> w;
	for (int i = 1; i <= t; i++) {
		cin >> a[i];
	}
	
	for (int i = 1; i <= t; i++) { // 시간 
		for (int j = 0; j <= w; j++) { // 이동 
			if (j == 0) { //  처음에는 항상 나무 1에 있음 
				dp[i][j][1] = dp[i-1][j][1] + (a[i] == 1);
			} else {
				dp[i][j][1] = max(dp[i-1][j][1] + (a[i] == 1), dp[i-1][j-1][2] + (a[i] == 1));
				dp[i][j][2] = max(dp[i-1][j][2] + (a[i] == 2), dp[i-1][j-1][1] + (a[i] == 2));
			}
		}
	}
	
	int ans = 0;
	for (int i = 1; i <= t; i++) {
		for (int j =0; j<=w; j++) {
			ans = max(ans, dp[i][j][1]);
			ans = max(ans, dp[i][j][2]);
		//	cout << dp[i][j][1] << " ";
		}//cout << endl;
	}
	
//	cout << endl;
	for (int i = 1; i <= t; i++) {
		for (int j =0; j<=w; j++) {
			//cout << dp[i][j][2] << " ";
		}//cout << endl;
	}
	cout << ans;
	return 0;

}