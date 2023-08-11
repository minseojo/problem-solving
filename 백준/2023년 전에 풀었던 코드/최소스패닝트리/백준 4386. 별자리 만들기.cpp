#include <bits/stdc++.h>
#define MAX 101
using namespace std;

struct st {
	int u;
	int v;
	double cost;
};

bool comp(const st& straight1, const st& straight2) {
	return straight1.cost < straight2.cost;
}

int V;
vector<pair<double, double> > star;
vector<st> straight;
int parent[MAX];

void init() {
	cin >> V;
	for(int i = 0; i < V; i++) parent[i] = i;
	
	double x, y;
	for(int i = 0; i < V; i++) {
		cin >> x >> y ;
		star.push_back({x, y});
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

double solve() {
	for(int i = 0; i < star.size(); i++) {
		for(int j = 0; j < star.size(); j++) {
			if(i == j) continue;
			double y = abs(star[i].first - star[j].first);
			double x = abs(star[i].second - star[j].second);
			y = pow(y, 2);
			x = pow(x, 2);
			double sum = sqrt(y + x);

			straight.push_back({i, j, sum});
		}
	}

	sort(straight.begin(), straight.end(), comp);	
	
	double result = 0;
	for(int i = 0; i < straight.size(); i++) {
		int straight1 = straight[i].u;
		int straight2 = straight[i].v;
		double cost = straight[i].cost;

		if(Find(straight1) != Find(straight2)) {
			Union(straight1, straight2);
			result += cost;
		}
	}
	
	return result;
}

int main() {
	init();
	cout << fixed;
	cout.precision(2);
	cout << solve();
	
	return 0;
}
