#include <bits/stdc++.h>
#define INF 1e9
using namespace std;

int V, E;
vector<pair<int, int> > graph[10001]; // cost, destination 
bool visited[10001];

void input() {
	cin >> V >> E;
	
	int A, B, C;
	for(int i=0; i<E; i++) {
		cin >> A >> B >> C;
		graph[A].push_back({C, B});
		graph[B].push_back({C, A});
	}
}

int prim() {
	int answer = 0;
	priority_queue<pair<int, int>, vector<pair<int, int> >, greater<pair<int, int> >> pq;
	pq.push({0, 1}); // 비용=0, 시작노드=1, 최종적으로 모든 노드를 지나므로 어디서 시작해도 무방 
	
	while(!pq.empty()) {
		int now_cost = pq.top().first;
		int now_node = pq.top().second;
		pq.pop();
		
		if(visited[now_node]) continue;
		visited[now_node] = true;

		answer += now_cost;

		for(int i=0; i < graph[now_node].size(); i++) {
			int next_cost = graph[now_node][i].first;
			int next_node = graph[now_node][i].second;
			if(!visited[next_node]) {
				pq.push({next_cost, next_node});
			}
		}
	}	 
	
	return answer;
}

int main() {
	input();
	cout << prim();
	return 0;
} 
