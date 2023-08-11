#include <bits/stdc++.h>
using namespace std;

int a[222][222];
int MOD = 1000000000;

int main() {
	int n, m;
	cin >> n >> m;
	for(int i=1; i<=200; i++) {
		a[1][i] = i;
		a[i][1] = 1;		
	}
	a[2][2]=3;

	for(int i=2; i<=200; i++) {
		for(int j=2; j<=200; j++) {
			a[i][j] = (a[i-1][j] + a[i][j-1])%MOD;
		}
	}
	cout << a[n][m];
	return 0;
}
