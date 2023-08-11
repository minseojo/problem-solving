#include <bits/stdc++.h>
using namespace std;

int n, m;
int a[222][222];
int answer=0;
int x;
void solve(int here, int pos) {	
	if(pos==3) {
		answer++;
		return;
	}
	
	for(int i=here+1; i<=n; i++) {
		if(a[x][i] || a[here][i]) continue;
		solve(i, pos+1);
	}
}

int main() {
	cin >> n >> m;
	int u, v;
	for(int i=0; i<m; i++) {
		cin >> u >> v;
		a[u][v]=1;
		a[v][u]=1;
	}
	
	for(int i=1; i<=n-2; i++) {
		x=i; 
		solve(i, 1);
	}
	cout << answer;
	return 0;
} 
