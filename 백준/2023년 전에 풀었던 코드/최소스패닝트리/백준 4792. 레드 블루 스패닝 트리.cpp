#include <bits/stdc++.h>
using namespace std;

int V, E, K;
vector<tuple<char, int, int> > graph;
vector<tuple<char, int, int> > graph2;
int parent[2][1001];

int Find(int mode, int x) {
	if(parent[mode][x] == x) return x;
	return parent[mode][x] = Find(mode, parent[mode][x]);
}

void Union(int mode, int u, int v) {
	u = Find(mode, u);
	v = Find(mode, v);
	
	if(u > v) parent[mode][u] = v;
	else parent[mode][v] = u;
}

bool IsSameParent(int mode, int u, int v) {
	u = Find(mode, u);
	v = Find(mode, v);
	
	if(u==v) return true;
	return false;
}

int KruskalBlue(int mode) {
	int blue = 0;
	for(int i=0; i<graph.size(); i++) {
		char cost = get<0>(graph[i]);
		int u = get<1>(graph[i]);
		int v = get<2>(graph[i]);
		if(!IsSameParent(0, u, v)) {
			Union(0, u, v);
			if(cost == 'B') blue++;
		}
	}
	
	return blue;
}

int KruskalRed(int mode) {
	int blue = 0;
	for(int i=0; i<graph2.size(); i++) {
		char cost = get<0>(graph2[i]);
		int u = get<1>(graph2[i]);
		int v = get<2>(graph2[i]);
		if(!IsSameParent(mode, u, v)) {
			Union(mode, u, v);
			if(cost == 'B') blue++;
		}
	}
	
	return blue;
}


bool Comp(tuple<char, int, int> &a, tuple<char, int, int> &b) {
	return get<0>(a) > get<0>(b);
}

void Input() {	
	while(1) {
		graph.clear();
		graph2.clear();
		
		cin >> V >> E >> K; // 정점 간선 블루개수 
		if(V==0 && E==0 && K==0) break;
	
		for(int i=1; i<=V; i++) {
			parent[0][i] = i;
			parent[1][i] = i;
		}
		
		char c;
		int f, t;
		for(int i=0; i<E; i++) {
			cin >> c >> f >> t;
			graph.push_back(make_tuple(c, f, t));
			graph2.push_back(make_tuple(c, f, t));
		}
		
		sort(graph.begin(), graph.end()); // 블루시작 
		sort(graph2.begin(), graph2.end(), Comp); // 레드시작 
		
		int r = KruskalBlue(0);
		int l = KruskalRed(1);

		if(l<=K && K<=r) cout << 1 << endl;
		else cout << 0 << endl;
	}

	
}

int main() {
	Input();
	return 0;
}
