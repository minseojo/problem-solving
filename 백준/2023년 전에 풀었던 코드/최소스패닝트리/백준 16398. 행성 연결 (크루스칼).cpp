#include <bits/stdc++.h>
using namespace std;

int V, E;
vector<tuple<int, int, int> > graph;
int parent[1001];
long long answer = 0;

bool Comp(tuple<int, int, int> &a, tuple<int, int, int> &b) {
	return get<0>(a) < get<0>(b);
}

void Input() {	
	cin >> V;
	
	for(int i=1; i<=V; i++) parent[i] = i;
		
	int cost;
	for(int i=0; i<V; i++) {
		for(int j=0; j<V; j++) {
			cin >> cost;
			if(i < j) {
				graph.push_back(make_tuple(cost, i, j)); // cost, u, v
			}
		}
	}
	
	sort(graph.begin(), graph.end(), Comp);
}

int Find(int x) {
	if(parent[x] == x) return x;
	return parent[x] = Find(parent[x]);
}

void Union(int u, int v) {
	u = Find(u);
	v = Find(v);
	
	if(u > v) parent[u] = v;
	else parent[v] = u;
}

bool IsSameParent(int u, int v) {
	u = Find(u);
	v = Find(v);
	
	if(u==v) return true;
	return false;
}

void Kruskal() {
	for(int i=0; i<graph.size(); i++) {
		int cost = get<0>(graph[i]);
		int u = get<1>(graph[i]);
		int v = get<2>(graph[i]);
		if(!IsSameParent(u, v)) {
			Union(u, v);
			answer += cost;
		}
	}
	
	cout << answer;
}

int main() {
	Input();
	Kruskal();
	return 0;
}
