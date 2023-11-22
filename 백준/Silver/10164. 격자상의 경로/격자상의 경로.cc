#include <bits/stdc++.h>
using namespace std;

int a[55][55];
void init(int n, int m, int k) {
	for (int i = 1; i <= n; i++) a[i][1] = 1;
	for (int i = 1; i <= m; i++) a[1][i] = 1;
	
	if (k != 0) {
		int y = k / m + 1; 
		int x = k % m;
		for (int i = y+1; i <= n; i++) a[i][x] = 1;
		for (int i = x+1; i <= m; i++) a[y][i] = 1;
	}

	for (int i = 2; i <= n; i++) {
		for (int j = 2; j <= m; j++) {
			if (a[i][j] == 0) a[i][j] = a[i-1][j] + a[i][j-1];
		}
	}

}
int main() {
	int n, m, k, ans = 0;
	cin >> n >> m >> k;
	init(n, m, k);
	if (k == 0) {
		cout << a[n][m];
		return 0;
	}
	cout << a[k/m+1][k%m] * a[n][m];
	return 0;
	
}