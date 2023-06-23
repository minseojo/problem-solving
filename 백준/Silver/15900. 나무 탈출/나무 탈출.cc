#include <bits/stdc++.h>
using namespace std;

vector<int> tree[500001];
bool visited[500001];

int bfs() {
	int result = 0, depth = 0;	
	queue<int> q;
	
	q.push(1);
	visited[1] = true;
	
	while (!q.empty()) {
		int size = q.size();
		while (size--) {
			int next_q = q.front();
			q.pop();
			
			if(next_q != 1 && tree[next_q].size() == 1) {
				result += depth;
			}
			
			for (int i = 0; i < tree[next_q].size(); i++) {
				int next = tree[next_q][i];
				if (!visited[next]) {
					visited[next] = true;
					q.push(next);
				}
			}
		}
		depth++;
	}
	
	
	return result;
}

int main() {
	int n;
	cin >> n;
	for (int i = 0; i < n-1; i++) {
		int a, b;
		cin >> a >> b;
		tree[a].push_back(b);
		tree[b].push_back(a);
	}
	// 루트로부터 bfs 하면서 리프노드에 도착한 경우, 결과값에 탐색깊이 더하기
	int total_depth = bfs();
	if(total_depth % 2 == 1) {
		cout << "Yes\n";
	} else {
		cout << "No\n";
	}
	return 0;
}