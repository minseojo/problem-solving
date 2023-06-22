#include <bits/stdc++.h>
using namespace std;

int d_trees = 0;
int g_trees = 0;

vector<int> tree[300001];
int degree[300001];

void count_degree(int root) {
	for (int i = 0; i < tree[root].size(); i++) {
		int next = tree[root][i];
		degree[root]++;
	}
}

int main() {
	int n, start;
	cin >> n;
	for (int i = 1; i < n; i++) {
		int u, v;
		cin >> u >> v;
		tree[u].push_back(v);
		tree[v].push_back(u);
	}
	
	// g트리
	// 주변 간선이 3개 이상이면 nC3 
	for (int i = 1; i <= n; i++) {
		int size = tree[i].size();
		if (size >= 3) {
			g_trees += ((size * (size-1) * (size-2)) / 6); // nC3
		}
	}
	
	// d트리 
	// 간선의 개수를 찾기. : dfs
	for (int i = 1; i <= n; i++) {
		count_degree(i);
	}
	
	for (int i = 1; i <= n; i++) {
		// 자식이 2개 미만이면, 
		// 현재 노드와 자식 노드, 자식 노드의 노드를 연결해도 노드가 3개뿐임.   
		if (tree[i].size() < 2) continue; 
		
		for (int j = 0; j < tree[i].size(); j++) {
			int x = tree[i][j];
			if (x <= i) continue; // 양방향 간선 간의 중복 제거 
			if (tree[x].size() < 2) continue; // 자식이 1개 인 경우는 부모와 연결한 거.
			d_trees += ((tree[i].size()-1) * (tree[x].size()-1)); 
		}
	}
	if (d_trees > 3 * g_trees) {
		cout << "D\n";
	} else if (d_trees < 3 * g_trees) {
		cout << "G\n";
	} else {
		cout << "DUDUDUNGA\n";
	}
	return 0;
}