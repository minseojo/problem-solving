#include <bits/stdc++.h>
using namespace std;

vector<int> graph[101];
bool visited[101];

int bfs(int start) {
	queue<int> q;
	memset(visited, 0, sizeof(visited));
	q.push(start);
	visited[start] = true;
	int kevin_bacon = 0;
	int depth = 1;
	
	while(!q.empty()) {
		int size = q.size();
		while(size--) {
			int cur = q.front();
			q.pop();
			for(int i=0; i<graph[cur].size(); i++) {
				int next = graph[cur][i];
				if(!visited[next]) {
					kevin_bacon += depth;
					q.push(next);
					visited[next] = true;
				}
			}
		}
		depth++;
	}
	
	return kevin_bacon;
}

int main() {
	// input
	int n, m;
	cin >> n >> m;
	for(int i=0; i<m; i++) {
		int u, v;
		cin >> u >> v;
		graph[u].push_back(v);
		graph[v].push_back(u);
	}
	
	//solve
	int answer = -1, kevin_bacon = 5001;
	for(int i=1; i<=n; i++) {
		int x = bfs(i);
		if(kevin_bacon > x) {
			kevin_bacon = x;
			answer = i;
		}
	}
	cout << answer;
	
	return 0;
}