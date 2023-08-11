#include <bits/stdc++.h>
#define INF 1e9
using namespace std;

int V;
vector<pair<int, int> > graph[1001]; // cost, destination 
bool visited[1001];

void input() {
	cin >> V;

	int cost;
	for(int i=1; i<=V; i++) {
		for(int j=1; j<=V; j++) {
			cin >> cost;
			if(i < j) {
				graph[i].push_back({cost, j});
				graph[j].push_back({cost, i});
			}
		}
	}
	
	for(int i=0; i<1001; i++) visited[i] = false;
}

// long long형 리턴해야하는데 자꾸 int형 함수로 리턴함; 
long long prim() {
	long long answer = 0;
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
