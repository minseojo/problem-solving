#include <bits/stdc++.h>
#define MAX 100001
using namespace std;

int N, M;
vector<int> adj[MAX];
bool visited[MAX];

int DFS(int here) {
	visited[here] = true;
	if (adj[here].empty()) return 0; // 마지막 노드 
	
	int next = adj[here][0];
	if (visited[next]) return -1; // 사이클 탐지 
	
	int result = DFS(next);
	if (result == -1) return -1;
	
	return result + 1;
}

int main() {
	int P;
	cin >> N >> M >> P;

	for (int i = 1; i <= N; i++) {
		int a, b;
		cin >> a >> b;
		if (adj[b].empty()) adj[b].push_back(a);
	}
	
	int ans = DFS(P);
	cout << ans << "\n";
	return 0;
}