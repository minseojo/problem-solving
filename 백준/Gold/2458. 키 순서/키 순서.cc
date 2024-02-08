#include <bits/stdc++.h>
using namespace std;

const int INF = 1e9;
int n, m;
bool dist[501][501];
int main() {
	cin >> n >> m;
		
	int a, b, c;
	for (int i = 0; i < m; i++) {
		cin >> a >> b;
		dist[a][b] = true;
	}
	
	for (int k = 1; k <= n; k++) { // x
		for (int i = 1; i <= n; i++) { // x보다 큰 사람 
			for (int j = 1; j <= n; j++) { // x보다 작은 사람 
				if (dist[i][k] && dist[k][j]) {
					dist[i][j] = true;
				}
			}
		}
	}
	
	int answer = 0;
	for (int i = 1; i <= n; i++) {
		int count = 0;
		for (int j = 1; j <= n; j++) {
			if (dist[i][j] || dist[j][i]) count++;
		}
		if (count + 1 == n) answer++;
	}
	cout << answer;
	
	return 0;
}