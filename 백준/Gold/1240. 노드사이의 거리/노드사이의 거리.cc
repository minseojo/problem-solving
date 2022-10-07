#include <bits/stdc++.h>
using namespace std;

struct St{
	int node;
	int dis;
};

vector<St> graph[1001];
bool visited[1001];

void bfs(int start, int end) {
	queue<St> q;
	memset(visited, 0, sizeof(visited));
	q.push({start, 0});
	visited[start] = true;
	
	while(!q.empty()) {
		int cur = q.front().node;
		int dis = q.front().dis;
		q.pop();
		
		if(cur == end) {
			cout << dis << endl;
			return;
		}
		for(int i=0; i<graph[cur].size(); i++) {
			int next = graph[cur][i].node;
			int nextDis = graph[cur][i].dis;
			if(!visited[next]) {
				visited[next] = true;
				q.push({next, dis + nextDis});
			}
		}
	}
}

int main() {
	int n, m;
	cin >> n >> m;
	
	int a, b, c;
	for(int i=0; i<n-1; i++) {
		cin >> a >> b >> c;
		graph[a].push_back({b, c});
		graph[b].push_back({a, c});
	}
	for(int i=0; i<m; i++) {
		cin >> a >> b;
		bfs(a, b);
	}
    
    return 0;
}