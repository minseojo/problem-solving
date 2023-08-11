#include <bits/stdc++.h>
using namespace std;

int n, m, k;
string s[1001];
int a[1001][1001];
int dy[4] = {0, 0, 1, -1};
int dx[4] = {1, -1, 0, 0}; 
int visited[11][1001][1001];

void input() {
	cin >> n >> m >> k;
	for(int i=0; i<n; i++) {
		cin >> s[i];
	}
	
	for(int i=0; i<n; i++) {
		for(int j=0; j<m; j++) {
			a[i][j] = s[i][j]-'0';
		}
	}
}

void solve() {
	int cnt=1;
	
	queue<tuple<int, int, int>> q;
	q.push(make_tuple(0, 0, 0)); // y, x, wall
	while(!q.empty()) {
		int size = q.size();
		while(size--) {
			int y = get<0>(q.front());
			int x = get<1>(q.front());
			int wall = get<2>(q.front());
			q.pop();
			
			//Á¾·á¹® 
			if(y==n-1 && x==m-1) {
				cout << cnt;
				return;
			}
			
			for(int i=0; i<4; i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				if(ny<0 || nx<0 || ny>=n || nx>=m) continue;
				if(visited[wall][ny][nx]==0 && a[ny][nx]==0 && wall<=k) {
					visited[wall][ny][nx] = 1;
					q.push(make_tuple(ny, nx, wall));
				}
				else if(visited[wall][ny][nx]==0 && a[ny][nx]==1 && wall<k) {
					visited[wall][ny][nx] = 1;
					q.push(make_tuple(ny, nx, wall+1));
				}
			}
		}
		cnt++;
	}
	
	cout << -1;
	return;
}

int main() {
	input();
	solve();
	return 0;
}
