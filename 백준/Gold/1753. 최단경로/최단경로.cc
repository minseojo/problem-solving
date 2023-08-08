#include <bits/stdc++.h>
#define INF 1e9
using namespace std;

int V, E, start;
vector<pair<int, int> > graph[20001];
int dist[20001];

void Input() {
	cin >> V >> E >> start;
	
	for(int i=1; i<=V; i++) dist[i] = INF;
	
	int u, v, w;
	for(int i=0; i<E; i++) {
		cin >> u >> v >> w;
		graph[u].push_back({w, v});
	}
}
void Dijkstra() {
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	pq.push({0, start});
	dist[start] = 0;
	
	while(!pq.empty()) {
		int now_cost = pq.top().first;
		int now_node = pq.top().second;
		pq.pop();
		
		for(int i=0; i<graph[now_node].size(); i++) {
			int next_cost = graph[now_node][i].first;
			int next_node = graph[now_node][i].second;

			if(dist[next_node] > now_cost + next_cost) {
				dist[next_node] = now_cost + next_cost;
				pq.push({dist[next_node], next_node});
			}
		}
	}
	
	for(int i=1; i<=V; i++) {
		if(dist[i] == INF) cout << "INF" << "\n";
		else cout << dist[i] << "\n";
	}
}

int main() {
   	ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
	Input();
	Dijkstra();
	return 0;
}