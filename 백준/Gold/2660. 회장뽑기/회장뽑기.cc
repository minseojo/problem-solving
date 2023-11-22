#include <bits/stdc++.h>
using namespace std;

struct St {
	int node;
	int score;
	bool operator< (const St& st) {
		if (score == st.score) return node < st.node;
		return score < st.score;
	}
};

vector<int> adj[51];
bool visited[51];
vector<St> temp;

void bfs(int start) {
	memset(visited, 0, sizeof(visited));
	queue<St> q;
	q.push({start, 0});
	visited[start] = true;
	int result = 0;
	
	while(!q.empty()) {
		int node = q.front().node;
		int score = q.front().score;
		result = max(result, score);
		q.pop();
		for (int i = 0; i < adj[node].size(); i++) {
			int next_node = adj[node][i];
			if (visited[next_node]) continue;
			visited[next_node] = true;
			q.push({next_node, score+1});
		}
	}

	temp.push_back({start, result});
}

int main() {
	int n;
	cin >> n;
	while(1) {
		int u, v;
		cin >> u >> v;
		if(u == -1 && v == -1) break;
		adj[u].push_back(v);
		adj[v].push_back(u);
	}
	
	for (int i = 1; i <= n; i++) {
		bfs(i);
	}
	
	sort(temp.begin(), temp.end());
	int max_score = temp[0].score;
	vector<St> ans;
	for (int i = 0; i < temp.size(); i++) {
		if (max_score == temp[i].score) {
			ans.push_back({temp[i].node, max_score});
		}
	}
	cout << max_score << " " << ans.size() << endl; 
	for (St i : ans) cout << i.node << " ";

	return 0;
}