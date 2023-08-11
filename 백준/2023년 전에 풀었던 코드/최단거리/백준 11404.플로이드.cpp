#include <bits/stdc++.h>
#define INF 1e9
using namespace std;

int n, m;
int city[101][101];

void Input() {
	cin >> n >> m;
	
	for(int i=1; i<=n; i++) {
		for(int j=1; j<=n; j++) {
			city[i][j] = INF;
		}
	}
	
	int a, b, c;
	for(int i=0; i<m; i++) {
		cin >> a >> b >> c;
		if(city[a][b] > c) city[a][b] = c; //입력부분을 생각못함 (1 4 1 , 1 4 2)
	}
}

void Floyd() {
	for(int k=1; k<=n; k++) {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i==j || j==k || k==i) continue;
				if(city[i][j] > city[i][k] + city[k][j]) {
					city[i][j] = city[i][k] + city[k][j];
				}
			}
		}
	}
	
	for(int i=1; i<=n; i++) {
		for(int j=1; j<=n; j++) {
			if(city[i][j] == INF) cout << "0 ";
			else cout << city[i][j] << " ";
		}
		cout << endl;
	}
}

int main() {
	Input();
	Floyd();
	return 0;
}
