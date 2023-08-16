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
				// 현재위치 -> 현재위치 (1->2->1, 2->1->2)  or  다른위치 -> 현재위치 (1->2, 2->1)
				dp[i][j][1] = max(dp[i-1][j][1] + (a[i] == 1), dp[i-1][j-1][2] + (a[i] == 1));
				dp[i][j][2] = max(dp[i-1][j][2] + (a[i] == 2), dp[i-1][j-1][1] + (a[i] == 2));
			}
		}
	}

	cout << max(dp[t][w][2], dp[t][w][1]);
	return 0;

}