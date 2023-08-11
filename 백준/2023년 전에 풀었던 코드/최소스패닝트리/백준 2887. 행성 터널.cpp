#include <bits/stdc++.h>
#define MAX 100001
using namespace std;

struct st {
	int u;
	int v;
	int cost;
};

int V;
vector<pair<int, int> > X; 
vector<pair<int, int> > Y;
vector<pair<int, int> > Z;
vector<st> planet;
bool comp(const st& planet1, const st& planet2) {
	return planet1.cost < planet2.cost; 
}
int parent[MAX];

void init() {
	cin >> V;
	
	for(int i = 0; i < V; i++) parent[i] = i;
	
	int x, y, z;
	for(int i = 0; i < V; i++) {
		cin >> x >> y >> z;
		X.push_back({x, i});
		Y.push_back({y, i});
		Z.push_back({z, i});
	}
}

int Find(int x) {
	if(x == parent[x]) return x;
	else return parent[x] = Find(parent[x]);
}

void Union(int u, int v) {
	u = Find(u);
	v = Find(v);
	
	if(u > v) parent[u] = v;
	else parent[v] = u;
}

long long solve() {
	sort(X.begin(), X.end());
	sort(Y.begin(), Y.end());
	sort(Z.begin(), Z.end());
	
	for(int i = 0; i < V - 1; i++) {
		planet.push_back({X[i].second, X[i+1].second, X[i+1].first - X[i].first});
		planet.push_back({Y[i].second, Y[i+1].second, Y[i+1].first - Y[i].first});
		planet.push_back({Z[i].second, Z[i+1].second, Z[i+1].first - Z[i].first});
	}
	
	sort(planet.begin(), planet.end(), comp);	
	
	long long result = 0;
	for(int i = 0; i < planet.size(); i++) {
		int planet1 = planet[i].u;
		int planet2 = planet[i].v;
		int cost = planet[i].cost;

		if(Find(planet1) != Find(planet2)) {
			Union(planet1, planet2);
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
