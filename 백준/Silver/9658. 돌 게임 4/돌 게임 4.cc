#include <bits/stdc++.h>
#define MAX 1000
using namespace std;

bool dp[MAX + 1];
int main() {
	dp[2] = true;

	for (int i = 4; i <= MAX; i++) {
		if (!dp[i - 1] || !dp[i - 3] || !dp[i - 4]) dp[i] = true;
	}
	
	int N;
	cin >> N;
	if (dp[N]) cout << "SK";
	else cout << "CY";
	return 0;
}