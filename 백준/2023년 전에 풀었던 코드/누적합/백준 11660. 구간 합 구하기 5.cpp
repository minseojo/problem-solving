#include <bits/stdc++.h>
using namespace std;

int n, m;
int prefix_sum[1222][1222];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
	
	cin >> n >> m;
	int now;
	for(int i=1; i<=n; i++) {
		for(int j=1; j<=n; j++) { 
			cin >> now;
			prefix_sum[i][j]=prefix_sum[i-1][j]+prefix_sum[i][j-1]-prefix_sum[i-1][j-1]+now;
		}
	}
	
	int x1, x2, y1, y2;
	for(int i=0; i<m; i++) {
		cin >> y1 >> x1 >> y2 >> x2; // 문제에서 제시한 x y 순서 달라서 임의로 변경 
		cout << prefix_sum[y2][x2]-prefix_sum[y1-1][x2]-prefix_sum[y2][x1-1]+prefix_sum[y1-1][x1-1] << '\n';
	}
	
	return 0;
}
