#include <bits/stdc++.h>
#define MAX 1000001
using namespace std;

const int UNWATCHED = 0;
const int WATCHED = 1;
const int INSTALLED = 2;

int N, M;
vector<int> adj[MAX];
int visited[MAX];
int installed;

int dfs(int here) {
	visited[here] = true;
	int children[3] = {0, 0, 0};
	for(int i = 0; i < adj[here].size(); i++) {
		int next = adj[here][i];
		if(!visited[next]) {
			children[dfs(next)]++;
		}
	}
	
	if(children[UNWATCHED]) {
		installed++;
		return INSTALLED;
	}
	
	if(children[INSTALLED]) {
		return WATCHED;
	}
	
	return UNWATCHED;
}

void solve() {
	installed = 0;
	
	for(int i = 0; i < N; i++) {
		if(!visited[i] && dfs(i) == UNWATCHED) {
			installed ++;
		}
	}
	
	cout << installed << "\n";
}

void init() {
	int tc;
	cin >> tc;
	while(tc--) {
		cin >> N >> M;
		memset(visited, 0, sizeof(visited));
		memset(adj, 0, sizeof(adj));
		int u, v;
		for(int i = 0; i < M; i++) {
			cin >> u >> v;
			adj[u].push_back(v);
			adj[v].push_back(u);
		}
		
		solve();
	}

}

int main() {
	init();
	
	return 0;	
}
