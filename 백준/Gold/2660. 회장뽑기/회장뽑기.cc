#include <bits/stdc++.h>
using namespace std;

struct St {
	int score;
	int person;
	bool operator< (const St& st) {
		if (score == st.score) return person < st.person;
		return score < st.score;
	}
};

vector<int> adj[51];
bool visited[51];
vector<St> ans;
vector<St> ans2;
void bfs(int start) {
	queue<St> q;
	q.push({0, start});
	visited[start] = true;
	int result = 0;
	while(!q.empty()) {
		int size = q.size();
		while(size--) {
			int node = q.front().person;
			int score = q.front().score;
			result = max(result, score);
			q.pop();
			for (int i = 0; i < adj[node].size(); i++) {
				int next_node = adj[node][i];
				if (visited[next_node]) continue;
				visited[next_node] = true;
				q.push({score+1, next_node});
			}
		}
	}
	ans.push_back({result, start});
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
		memset(visited, 0, sizeof(visited));
		bfs(i);
	}
	sort(ans.begin(), ans.end());
	int max_score = ans[0].score;
	
	for (int i = 0; i < ans.size(); i++) {
		if (max_score == ans[i].score) {
			ans2.push_back({max_score, ans[i].person});
		}
	}

	cout << max_score << " " << ans2.size() << endl;
	for (St i: ans2) {
		cout << i.person <<" ";
	}
	return 0;
}