#include <bits/stdc++.h>
using namespace std;

int a[1001][1001];
bool visited[1001][1001];
int dy[4] = {0, 0, 1, -1};
int dx[4] = {1, -1, 0, 0};

int n, m;
int cnt = 0;
void dfs(int y, int x) {
	visited[y][x] = true;
	if (y%2 == 0 && x%2 == 0) cnt++;
	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (ny < 1 || nx < 1 || ny > n*2 || nx > m*2 || visited[ny][nx] || a[ny][nx] == 1) continue;
		if (a[ny][nx] == 0)
		dfs(ny, nx);
	}
}

int main() {
	int cut_size;
	cin >> m >> n >> cut_size;
	for (int i = 0; i < cut_size; i++) {
		int type, pos; //타입이 0이면 가로, 1이면 세로 
		cin >> type >> pos;
		if (type == 0) {
			for (int j = 1; j <= m*2; j++) {
				a[pos*2+1][j] = 1;
			}
		} else {
			for (int j = 1; j <= n*2; j++) {
				a[j][pos*2+1] = 1;
			}
		}
	}
	
	int ans = 0;
	for (int i = 1; i <= n*2; i++) {
		for (int j = 1; j <= m*2; j++) {
			if (!visited[i][j]) {
				cnt = 0;
				dfs(i, j);
				ans = max(ans, cnt);
			}
		}
	}

	cout << ans;
}