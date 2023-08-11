#include <bits/stdc++.h>
using namespace std;

int n, m;
vector<pair<int, int> > v[1001];
int dist[1001];
int INF = 1e9;

void dijkstra(int s) {
	for(int i=1; i<=n; i++) dist[i] = INF;	
	dist[s] = 0;
	priority_queue<pair<int, int> > pq;
	pq.push(make_pair(dist[s], s));
	
	while(!pq.empty()) {
		int cost = -pq.top().first;
		int cur = pq.top().second;
		pq.pop();
		if(cost > dist[cur]) continue;
 		for(int i=0; i<v[cur].size(); i++) {
			int next = v[cur][i].first;
			int next_cost = cost + v[cur][i].second;
			if(dist[next] > next_cost) {
				dist[next] = next_cost;
				pq.push(make_pair(-dist[next], next));
			} 
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
		
	cin >> n >> m;
	for(int i=0; i<m; i++) {
		int u, v2, w;
		cin >> u >> v2 >> w;
		v[u].push_back({v2, w});
	}
	
	int s, e;
	cin >> s >> e;
	dijkstra(s);
	cout << dist[e];
	return 0;
} 
