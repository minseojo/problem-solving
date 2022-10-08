#include <bits/stdc++.h>
using namespace std;
 
int n, m;
int table[301][301];
int sum[301][301]; //sum[i][j]는 1,1부터 i,j까지의 총 합
int answer = 0;

void solve(int y, int x) {
	for (int i=y; i<=n; i++) {
		for (int j=x; j<=m; j++) { //y행x열부터 i행 j열까지 합이 10인지 검사
			int tmp = sum[i][j] - sum[i][x-1] - sum[y-1][j] + sum[y-1][x-1];
			if (tmp >= 10) {
				if (tmp == 10) answer++;
				break;
			}
		}
	}
}
 
int main() {
	cin >> n >> m;
	for (int i=1; i<=n; i++) {
		for (int j=1; j<=m; j++) {
			cin >> table[i][j];
		}
	}
	for (int i=1; i<=n; i++) {
		for (int j=1; j<=m; j++) {
			sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + table[i][j];
		}
	}
	for (int i=1; i<=n; i++) {
		for (int j=1;j<=m; j++) {
			solve(i, j);
		}
	}
	cout << answer;
 
	return 0;
}