#include <bits/stdc++.h>
using namespace std;

int M, N;
int a[500][500];
int dp[500][500];
int dy[4] = {0,-1,0,1}; //우 상 좌 하 
int dx[4] = {1,0,-1,0};
int answer=0;

void input() {
	cin >> M >> N;
	for(int i=0; i<M; i++) {
		for(int j=0; j<N; j++) {
			cin >> a[i][j];
		}
	}
}

int solve(int y, int x) {
	if(y==M-1 && x==N-1) return 1;
	
	int &ret = dp[y][x];
	if(ret!=-1) return ret;
	ret=0; // 처음에 dp[][]를 -1로 전부 초기화. but, 처음 cnt는 0이므로 0으로 초기화 
	for(int i=0; i<4; i++) {
		int ny = y+dy[i];
		int nx = x+dx[i];
		if(ny<0 || nx<0 || ny>M-1 || nx>N-1) continue;
		if(a[y][x]>a[ny][nx])
			ret += solve(ny, nx);
	}
	
	return ret;
	
}

int main() {
	input();
	memset(dp, -1, sizeof(dp));
	solve(0, 0);
	
	cout << dp[0][0];
	return 0;
}
