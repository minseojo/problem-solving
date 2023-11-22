#include <bits/stdc++.h>
using namespace std;

int n;
double percent[4];
bool visited[30][30];
int dy[4] = {1, -1, 0, 0};
int dx[4] = {0, 0, 1, -1};

double DFS(int y, int x, int cnt) {
	if (cnt == n) return 1.0; 	

	visited[y][x] = true;
	double result = 0.0;
	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (visited[ny][nx]) continue;
		result = result + percent[i] * DFS(ny, nx, cnt + 1);
	}
	visited[y][x] = false;
	return result;
}

int main() {
	cin >> n;
	for (int i = 0; i < 4; i++) {
		cin >> percent[i];
		percent[i] /= 100;
	}
	cout.precision(10);
	cout << fixed;
	cout << DFS(14, 14, 0);
	return 0;
}