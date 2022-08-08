#include <bits/stdc++.h>
using namespace std;

struct st {
	int cost;
	int value;
};

int N, T;
vector<st> v;
int dp[101][10001];

int main() {
	cin >> N >> T;
	
	int K, S;
	v.push_back({-1 -1}); //더미값 추가 
	for(int i=0; i<N; i++) {
		cin >> K >> S;
		v.push_back({K, S});
	}
	
	
	for(int i=1; i<=N; i++) {
		for(int j=1; j<=T; j++) {
			if(j >= v[i].cost) {
				dp[i][j] = max(dp[i-1][j], dp[i-1][j-v[i].cost] + v[i].value);	
			}
			else dp[i][j] = dp[i-1][j];
		}
	}
	
	cout << dp[N][T];
}