#include <bits/stdc++.h>
#define INF 1e9
using namespace std;

int n, m, r;
int item[101];
int dist[101];
vector<pair<int, int> > graph[101];

void Input() {
	cin >> n >> m >> r;
	for(int i=1; i<=n; i++) {
		cin >> item[i];
	}
	
	int a, b, c;
	for(int i=0; i<r; i++) {
		cin >> a >> b >> c;
		graph[a].push_back({c, b});
		graph[b].push_back({c, a});
	}
}

int dijkstra(int start) {
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	pq.push({0, start}); // 비용, 시작지점
	for(int i=1; i<=n; i++) dist[i]=INF;
	dist[start] = 0;
	while(!pq.empty()) {
		int now_cost = pq.top().first;
		int now_node = pq.top().second;
		pq.pop();
		
		for(int i=0; i<graph[now_node].size(); i++) {
			int next_cost = graph[now_node][i].first;
			int next_node = graph[now_node][i].second;
			
			if(dist[next_node] > now_cost + next_cost && now_cost + next_cost <= m) {
				dist[next_node] = now_cost + next_cost;
				pq.push({dist[next_node], next_node});
			}
		}
	}
	
	int tmp=0;
	for(int i=1; i<=n; i++) {
		if(dist[i] != INF) {
			tmp += item[i];
		}
	}

	return tmp;
}

int main() {
	int answer=-1;
	
	Input();
	for(int i=1; i<=n; i++) {
		answer = max(answer, dijkstra(i));
	}
	cout << answer;
} 
