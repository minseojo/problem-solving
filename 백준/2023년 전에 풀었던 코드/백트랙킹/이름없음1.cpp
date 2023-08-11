#include<bits/stdc++.h>
using namespace std;

int n, m;
int a[555][555];
int dy[4]={-1,1,0,0};
int dx[4]={0,0,-1,1};
int dp[555][555];
int answer=0;

int solve(int y, int x) {
	if(y==n-1 && x==m-1) return 1;
	int &ret=dp[y][x];
	if(ret!=-1) return ret;
	ret=0;
	
	for(int i=0; i<4; i++) {
		int ny=y+dy[i];
		int nx=x+dx[i];		
		if(ny<0 || nx<0 || ny>n-1 || nx>m-1) continue;
		if(a[y][x]>a[ny][nx]) {
			ret+=solve(ny, nx);
		}
	}
	
	return ret;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	cin >> n >> m;
	for(int i=0; i<n; i++) {
		for(int j=0; j<m; j++) {
			cin >> a[i][j];
		}
	}

	memset(dp, -1, sizeof(dp));
	solve(0, 0);
	cout << dp[0][0];	
	return 0;
} 
