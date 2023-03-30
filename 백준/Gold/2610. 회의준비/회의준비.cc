#include <bits/stdc++.h>
#define enld "\n"
using namespace std;

int n, m;
int parent[101];
bool visited[101];
vector<int> v[101];
vector<int> graph[101]; 
vector<int> answer;

int Find(int x) {
	if(parent[x] == x) return x;
	else return parent[x] = Find(parent[x]);
}

void Union(int u, int v) {
	u = Find(u);
	v = Find(v);
	if(u < v) parent[v] = u;
	else parent[u] = v;
}

int bfs(int here) {
	memset(visited, false, sizeof(visited));
	queue<int> q;
	q.push(here);
	int result = 0;
	visited[here] = true;
	while(!q.empty()) {
		int size = q.size();
		while(size--) {
			int cur = q.front();
			q.pop();
			for(int i=0; i<graph[cur].size(); i++) {
				int next = graph[cur][i];
				if(visited[next]) continue;
				visited[next] = true;
				q.push(next);
			}
		}
		result++;
	}
	return result;
}

int main() {
	cin >> n >> m;
	for(int i=1; i<=n; i++) parent[i] = i;
	
	for(int i=0; i<m; i++) {
		int a, b;
		cin >> a >> b;
		graph[a].push_back(b);
		graph[b].push_back(a);

		Union(a, b);
	}

	for(int i=1; i<=n; i++) {
		int val = Find(i);
		v[val].push_back(i);
	}

	for(int i=1; i<=n; i++) {
		int min = 1e9;
		int index = 0;
		int size = 1e9;
		for(int j=0; j<v[i].size(); j++) {
			int idx = v[i].at(j);
			size = bfs(idx);
			if(size < min) {
				min = size;
				index = idx;
			}
		}
		if(min < 1e9) answer.push_back(index);
	}
	
	sort(answer.begin(), answer.end());
	cout << answer.size() << endl;
	for(int i=0; i<answer.size(); i++) {
		cout << answer.at(i) << endl;
	}
}