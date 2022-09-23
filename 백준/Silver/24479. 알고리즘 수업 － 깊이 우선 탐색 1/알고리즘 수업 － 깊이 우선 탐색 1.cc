#include <bits/stdc++.h>
using namespace std;

vector<int> v[100001];
int visited[100001];
int result[100001];
int cnt = 0;

void dfs(int idx) {
	visited[idx] = 1;
	result[idx] = ++cnt;
	for(int i=0; i<v[idx].size(); i++) {
		int x = v[idx][i];
		if(!visited[x]) dfs(x);
	}
}

int main() {
	ios_base::sync_with_stdio(false);	
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M, R;
	cin >> N >> M >> R;
	for(int i=0; i<M; i++) {
		int a, b;
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}
	for(int i=0; i<N; i++) {
		sort(v[i].begin(), v[i].end());
	}
	dfs(R);
	for(int i=1; i<=N; i++) cout << result[i] << "\n";
}