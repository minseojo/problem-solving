#include <bits/stdc++.h>
#define INF 987654321
using namespace std;

struct st {
	int from;
	int to;
	int cost;
};

vector<st> edge;
long long dist[501];

void bellmanFord(int n, int m) {
	for(int i=1; i<=n; i++) dist[i] = INF;
	dist[1] = 0;
	
	for(int i=1; i<=n-1; i++) {
		for(int j=0; j<edge.size(); j++) {
			int from = edge[j].from;
			int to = edge[j].to;
			int cost = edge[j].cost;
			
			if(dist[from] == INF) continue;
			if(dist[to] > dist[from] + cost) dist[to] = dist[from] + cost;
		}
	}


	for(int j=0; j<edge.size(); j++) {
		int from = edge[j].from;
		int to = edge[j].to;
		int cost = edge[j].cost;
		
		if(dist[from] == INF) continue;
		if(dist[to] > dist[from] + cost) {
			cout << -1;
			return;
		}
	}
	
	
	for(int i=2; i<=n; i++) {
		// 해당 도시로 가는 경로가 없다.
		if(dist[i] == INF) cout << -1 << endl; 
		// 해당 도시로 가는 경로가 있다. 
		else cout << dist[i] << endl;
	}

}

int main() {
	int n, m;
	cin >> n >> m;
	for(int i=0; i<m; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		edge.push_back({a, b, c}); // from, to, cost
	}
	
	bellmanFord(n, m);
	
	return 0;
}