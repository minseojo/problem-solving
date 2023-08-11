#include <bits/stdc++.h>
using namespace std;

int n;
int a[555][555];
int cache[555][555];

int solve(int y, int x) {
	if(y>n || x>n) return 0;
	
	int &ret=cache[y][x];
	if(ret!=-1) return ret;
	
	return ret = a[y][x] + max(solve(y+1, x), solve(y+1, x+1));
}

int main() {
	cin >> n;
	for(int i=1; i<=n; i++) {
		for(int j=1; j<=i; j++) {
			cin >> a[i][j];
		}
	}
	
	memset(cache, -1, sizeof(cache));
	cout << solve(1, 1) << "\n";

	return 0;
}
