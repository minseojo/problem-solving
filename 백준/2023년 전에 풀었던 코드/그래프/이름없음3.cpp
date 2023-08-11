#include <bits/stdc++.h>
using namespace std;

int n, m;
vector<pair<int, int> > v[801];
int dist[801];
int INF = 1e9;
int path, path2;

void dijkstra(int s) {
	for(int i=1; i<=n; i++) dist[i] = INF;	
	dist[s] = 0;
	priority_queue<tuple<int, int, bool, bool> > pq;
	pq.push(make_tuple(dist[s], s, 0, 0));
	
	while(!pq.empty()) {
		int cost = -get<0>(pq.top());
		int cur = get<1>(pq.top());
		int pt1 = get<2>(pq.top());
		int pt2 = get<3>(pq.top());
		pq.pop();

 		for(int i=0; i<v[cur].size(); i++) {
			int next = v[cur][i].first;
			int next_cost = cost + v[cur][i].second;
			
			if(pt1==1 && pt2==1) {
				if(dist[next] > next_cost) {
					dist[next] = next_cost;
					pq.push(make_tuple(-dist[next], next, pt1, pt2));
				}
			} else if(next==path) {
				pq.push(make_tuple(-dist[next], 0, 1, pt2));
			} else if(next==path2) {
				pq.push(make_tuple(-dist[next], 0, pt1, 1));
			} else if(pt1 !=1 && pt2 != 1) {
				pq.push(make_tuple(-dist[next], 0, pt1, pt2));
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
		v[v2].push_back({u, w});
	}
	
	cin >> path >> path2;
	dijkstra(1);
	if(dist[n] == INF) cout << -1;
	else cout << dist[n];
	
	return 0;
} 
