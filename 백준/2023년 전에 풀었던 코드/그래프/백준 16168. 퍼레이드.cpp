#include <bits/stdc++.h>
using namespace std;

int V, E;
int a[3333][3333];

void solve(int here, int cnt) {
	if(cnt==0) {
		cout << "YES";
		exit(0);
	}
	for(int i=1; i<=V; i++) {
		if(a[here][i]) {
			a[here][i]--;
			a[i][here]--;
			cnt--;
			solve(i, cnt);
			a[here][i]++;
			a[i][here]++;
			return; // 그 순간 남은 정점이 없으면 바로바로 처음으로 돌아옴 
		}
	}
}

int main() {
	cin >> V >> E;
	int u, v;
	for(int i=0; i<E; i++) {
		cin >> u >> v;
		a[u][v]=1;
		a[v][u]=1;
	}
	for(int i=1; i<=V; i++) {
		solve(i, E);
	}
	cout << "NO";
	return 0;
}
