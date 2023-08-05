#include <bits/stdc++.h>
using namespace std;

int a[300][300];
int copy_a[300][300]; 
int n, m;

void melt() {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (a[i][j] > 0) {
				// up
				if ((i-1) >= 0) {
					if (copy_a[i-1][j] <= 0) a[i][j]--;
				}
				// down
				if ((i+1) < n) {
					if (copy_a[i+1][j] <= 0) a[i][j]--;	
				}
				// left
				if ((j-1) >= 0) {
					if (copy_a[i][j-1] <= 0) a[i][j]--;
				}
				//right
				if ((j+1) < m) {
					if (copy_a[i][j+1] <= 0) a[i][j]--;
				}
			}
		}
	}
	for (int i = 0 ; i < n; i++) {
		for (int j = 0; j < m; j++) {
		//	cout << a[i][j];
			copy_a[i][j] = a[i][j];
		}
	//	cout << endl;
	}

}

bool visited[300][300];
int dy[4] = {1, -1, 0, 0};
int dx[4] = {0, 0, 1, -1};
void check(int y, int x) {
	visited[y][x] = true;
	
	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx]) continue;
		if (a[ny][nx] <= 0) continue;
		check(ny, nx);
	}
}

int main() {
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> a[i][j];
			copy_a[i][j] = a[i][j];
		}
	}
	
	int cnt= 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (!visited[i][j] && a[i][j] > 0) {
				check(i, j);
				cnt++;
			}
		}
	}

	// 빙산이 없거나, 이미 두동강 난 경우 
	if (cnt == 0 || cnt > 1) {
		cout << 0;
		return 0;
	}
	
	int ans = 0;
	bool okMelt = false;
	while(1) {
		melt();
		ans++;
		memset(visited, 0, sizeof(visited));
		cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && a[i][j] > 0) {
					check(i, j);
					cnt++;
				}
			}
		}
		if (cnt == 0) {
			okMelt = false;
			break;
		}
		if (cnt > 1) {
			okMelt = true;
			break;
		}
	}
	if (okMelt) cout << ans << endl;
	else cout << 0 << endl;
}