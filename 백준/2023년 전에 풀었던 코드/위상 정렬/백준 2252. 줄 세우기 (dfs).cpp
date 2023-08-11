#include <bits/stdc++.h>
using namespace std;

int DAG[32001];
vector<int> graph[32001];
int n, m;
vector<int> start;

void solve(int here) {
	cout << here << " ";
	for(int i=0; i<graph[here].size(); i++) {
		int next = graph[here][i];
		
		DAG[next]--;
		if(DAG[next] == 0) solve(next);
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
	
	for(int i=1; i<=n; i++) {
		if(DAG[i] == 0) start.push_back(i);
	}
	
	sort(start.begin(), start.end());
	for(int i=0; i<start.size(); i++) {
		solve(start[i]);
	}
	
	return 0;
}
