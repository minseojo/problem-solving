#include <bits/stdc++.h>
using namespace std;

int n, m;
int DAG[32001];
vector<int> graph[32001];

void solve() {
	queue<int> q;
	
	for(int i=1; i<=n; i++) {
		if(DAG[i] == 0) {
			q.push(i);
		}
	}
	
	while(!q.empty()) {
		int now = q.front();
		q.pop();
		
		cout << now << " ";
		for(int i = 0; i < graph[now].size(); i++) {
			int next = graph[now][i];
			DAG[next]--;
			
			if(DAG[next] == 0) q.push(next);
		}
	}
}

int main() {
	cin >> n >> m;
	
	int u, v;
	for(int i=0; i<m; i++) {
		cin >> u >> v;
		graph[u].push_back(v);
		DAG[v]++;
	}
	solve();
} 
