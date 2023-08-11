#include <bits/stdc++.h>
using namespace std;

int DAG[32001];
vector<int> graph[32001];
int n, m;
priority_queue<int, vector<int>, greater<int>> pq;

void solve() {
	for(int i=1; i<=n; i++) {
		if(DAG[i] == 0) pq.push(i);
	}
	
	while(!pq.empty()) {
		int now = pq.top();
		pq.pop();
		
		cout << now << " ";
		for(int i=0; i<graph[now].size(); i++) {
			int next = graph[now][i];
			
			DAG[next]--;
			if(DAG[next] == 0) pq.push(next);
		}
	}
}

int main() {
	cin >> n >> m;
	
	int a, b;
	for(int i=0; i<m; i++) {
		cin >> a >> b;
		graph[a].push_back(b);
		DAG[b]++;
	}
	
	solve();
	
	return 0;
}
/*
dfs로 할 시 반례 
입력  
4 2
1 4
3 2
*/
