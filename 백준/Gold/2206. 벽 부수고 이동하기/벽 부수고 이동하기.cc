#include <bits/stdc++.h>
using namespace std;

struct Point {
	int y;
	int x;
	int wall;
};

int a[1000][1000];
bool visited[3][1000][1000];
int dy[4] = {1, -1 , 0, 0};
int dx[4] = {0, 0, 1, -1};

bool isValidRange(int ny, int nx, int wall, int n, int m) {
	if (ny < 0 || nx < 0 || ny >= n || nx >= m) return false;
	if (visited[wall][ny][nx]) return false;
	return true;
}

int bfs(int n, int m) {
	queue<Point> q;
	q.push({0, 0, 0});
	visited[0][0][0] = true;
	int result = 0;
	while(!q.empty()) {
		int size = q.size();
		result++;
		while(size--) {
			Point p = q.front();
			int y = p.y;
			int x = p.x;
			int wall = p.wall;
			q.pop();
			if (y == n-1 && x == m-1) return result;
			
			for (int dir = 0; dir < 4; dir++) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if (!isValidRange(ny, nx, wall, n, m)) continue;
				
				visited[wall][ny][nx] = true;
				
				if (wall == 0 && a[ny][nx] == 1) {
					q.push({ny, nx, wall+1});
				} 
				else if (a[ny][nx] == 0) {
					q.push({ny, nx, wall});
				}
				
			}
		}
	}
	
	return -1;
}

int main() {
	int n, m;
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		string s;
		cin >> s;
		for (int j = 0; j < s.size(); j++) {
			a[i][j] = s[j]-'0';
		}
	}

	cout << bfs(n, m);
	return 0;
}