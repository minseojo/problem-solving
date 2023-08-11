#include <bits/stdc++.h>
#define MAX 100001
using namespace std;

struct st {
	int u;
	int v;
	int cost;
	
};

bool comp(const st& town1, const st& town2) {
	return town1.cost < town2.cost;
}

int V, E;
vector<st> link;
int town[MAX];

void init() {
	cin >> V >> E;
	
	for(int i = 1; i < V + 1; i++) town[i] = i;
	
	int u, v, cost;
	for(int i = 0; i < E; i++) {
		cin >> u >> v >> cost;
		link.push_back({u, v, cost});
	}
}

int Find(int x) {
	if(x == town[x]) return x;
	else return town[x] = Find(town[x]);
}

void Union(int u, int v) {
	u = Find(u);
	v = Find(v);
	
	if(u > v) town[u] = v;
	else town[v] = u;
}

int solve() {
	sort(link.begin(), link.end(), comp);
	
	int result = 0;
	int cnt = 0;
	for(int i = 0; i < E; i++) {
		int town1 = link[i].u;
		int town2 = link[i].v;
		int cost = link[i].cost;
		
		if(cnt == V-2) break;
		
		if(Find(town1) != Find(town2)) {
			Union(town1, town2);
			cnt++;
			result += cost;
		}
	}
	
	return result;
}

int main() {
	init();
	cout << solve();
	
	return 0;
}
