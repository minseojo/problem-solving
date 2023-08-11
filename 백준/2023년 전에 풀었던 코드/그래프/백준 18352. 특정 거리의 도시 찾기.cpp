#include <bits/stdc++.h>
#define INF 987654321
using namespace std;

int n, m, k, x;
vector<int> v[300001];
int visited[300001];

void bfs() {
	visited[x]=0;
	queue<int> q;
	q.push(x);
	
	while(!q.empty()) {
		int here = q.front();
		q.pop();
		for(int i=0; i<v[here].size(); i++) {
			int next = v[here][i];
			if(visited[next] > visited[here]+1) {
				visited[next] = visited[here]+1;
				q.push(next);
			}
		}
	}
}

int main() {
	cin >> n >> m >> k >> x;
	for(int i=1; i<=n; i++) {
		visited[i]=INF;
	}
	int a, b;
	for(int i=0; i<m; i++) {
		cin >> a >> b;
		v[a].push_back(b);
	}


	bfs();
	bool flag=false;
	for(int i=1; i<=n; i++) {
		if(visited[i]==k) {
			cout << i << endl;
			flag=true;
		}
	}
	if(!flag) cout << -1;
	
	return 0;
}
