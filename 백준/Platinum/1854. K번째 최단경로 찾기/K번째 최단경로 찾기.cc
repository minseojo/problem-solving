#include <bits/stdc++.h>
#define INF 1e9
using namespace std;

int V, E, k, start = 1;
vector<pair<int, int> > graph[1001];
priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
priority_queue<int, vector<int>, less<int>> city[1001];

void input() {
	cin >> V >> E >> k;
	
	int u, v, w;
	for(int i=0; i<E; i++) {
		cin >> u >> v >> w;
		graph[u].push_back({w, v});
	}
}

void dijkstra() {
	pq.push({0, start});
	city[start].push(0);
	
	while(!pq.empty()) {
		int now_cost = pq.top().first;
		int now_node = pq.top().second;
		pq.pop();
		
		for(int i=0; i<graph[now_node].size(); i++) {
			int next_cost = now_cost + graph[now_node][i].first;
			int next_node = graph[now_node][i].second;
			
			if(city[next_node].size() < k) {
				city[next_node].push(next_cost);
				pq.push({next_cost, next_node});
			} else {
				if(city[next_node].top() > next_cost) {
					city[next_node].pop();
					city[next_node].push(next_cost);
					pq.push({next_cost, next_node});
				}
			}
		}
	}
	
}

int main() {
   	ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
	input();
	dijkstra();
	
	for(int i=1; i<=V; i++) {
		if(city[i].size() < k) cout << -1 << endl;
		else {
			cout << city[i].top() << endl;
		}
	}
	return 0;
}