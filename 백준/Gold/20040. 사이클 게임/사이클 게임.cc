#include <bits/stdc++.h>
using namespace std;

int n, m;
int parent[500001];

int Find(int x) {
	if (x == parent[x]) return x;
	return parent[x] = Find(parent[x]);
}

void Merge(int u, int v) {
	u = Find(u);
	v = Find(v);
	if (u < v) parent[v] = u;
	else parent[u] = v;	
}

int main() {
	cin >> n >> m;
	
	for (int i = 0; i < n; i++) parent[i] = i; // makeSet
	for (int i = 0; i < m; i++) {
		int u, v;
		cin >> u >> v;
		if (Find(u) == Find(v)) {
			cout << i + 1;
			return 0;
		}
		Merge(u, v);
	}
	cout << 0;
	return 0;
}