#include <bits/stdc++.h>
#define MAX 5
using namespace std;

int R, C, K;
char a[MAX][MAX];
bool visited[MAX][MAX];
int dy[4] = {1, -1, 0, 0};
int dx[4] = {0, 0, 1, -1};
int ans;

void DFS(int y, int x, int dist) {
	if (dist > K) return;
	
	if (y == 0 && x == C-1) {
		if (dist == K) ans++;
		return;
	}

	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (ny < 0 || nx < 0 || ny >= R || nx >= C || visited[ny][nx] || a[ny][nx] == 'T') continue;
		visited[ny][nx] = true;
		DFS(ny, nx, dist+1);
		visited[ny][nx] = false;
	}
}

int main() {
	cin >> R >> C >> K;
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < R; j++) {
			cin >> a[i][j];
		}
	}
	
	visited[R-1][0] = true;
	DFS(R-1, 0, 1);
	cout << ans;
	return 0;
}