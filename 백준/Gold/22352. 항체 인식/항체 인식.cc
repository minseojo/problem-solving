#include <bits/stdc++.h>
using namespace std;

struct St{
	int y;
	int x;
	int before;
	int vaccine;
};
queue<St> q;

int dy[4] = {0, 0, 1, -1};
int dx[4] = {1, -1, 0, 0};

int a[30][30]; // 투약 전 
int b[30][30]; // 투약 후
int n, m;
bool visited[30][30];


void bfs() {
	while(!q.empty()) {
		St st = q.front();
		int y = st.y;
		int x = st.x;
		int before = st.before;
		int vaccine = st.vaccine;

		q.pop();
		
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (ny < 0 || nx < 0 || ny > n-1 || nx > m-1 || visited[ny][nx]) {
				continue;
			}
			
			if (a[ny][nx] == before) {
				visited[ny][nx] = true;
				a[ny][nx] = vaccine;
				q.push({ny, nx, before, vaccine});
			}
		}
	}
}

int main() {
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> a[i][j];
		}
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> b[i][j];
		}
	}
	
	bool find = false;
	for (int i = 0; i < n; i++) {
		if (find) break;
		for (int j = 0; j < m; j++) {
			if (a[i][j] != b[i][j]) {
				visited[i][j] = true;
				q.push({i, j, a[i][j], b[i][j]}); // a[i][j]에 b[i][j]값을 투약 
				a[i][j] = b[i][j];
				find = true;
				break;
			}
		}
	}
	
	bfs();
	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (a[i][j] != b[i][j]) {
				cout << "NO";
				return 0;
			}
		}
	}
	
	cout << "YES";
	return 0;
}