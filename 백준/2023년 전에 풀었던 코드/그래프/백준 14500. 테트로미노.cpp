#include <bits/stdc++.h>
using namespace std;

int n, m;
int a[555][555];
int dy[4] = {0, 0, 1, -1};
int dx[4] = {1, -1, 0, 0};
int visited[555][555];
int ans=0;

void dfs(int y, int x, int cnt, int sum) {
	visited[y][x]=1;
	if(y<1 || x<1 || y>n || x>m) return;
	if(cnt==3) {
		ans = max(ans, sum);
		return;
	}
	
	for(int i=0; i<4; i++) {
		int ny = y+dy[i];
		int nx = x+dx[i];
		if(visited[ny][nx]!=1) {		
			dfs(ny, nx, cnt+1, sum+a[ny][nx]);
			visited[ny][nx]=0;
		}
	}
	visited[y][x]=0;
}

int main() {
	cin >> n >> m;
	memset(a, 0, sizeof(a));
	for(int i=1; i<=n; i++) {
		for(int j=1; j<=m; j++) {
			cin >> a[i][j];
		}
	}
	
	for(int i=1; i<=n; i++) {
		for(int j=1; j<=m; j++) {
			dfs(i, j, 0, a[i][j]);
			
			int s = a[i][j] + a[i][j+1] + a[i][j+2];
			ans = max(ans, s+a[i-1][j+1]);
			ans = max(ans, s+a[i+1][j+1]);
			
			int s2 = a[i][j] + a[i+1][j] + a[i+2][j];
			ans = max(ans, s2+a[i+1][j-1]);
			ans = max(ans, s2+a[i+1][j+1]);
		}
	}
	cout << ans;
	return 0;
}
