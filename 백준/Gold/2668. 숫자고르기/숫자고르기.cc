#include <bits/stdc++.h>
using namespace std;

vector<int> v[101];
bool visited[101];
vector<int> ans;


bool finish = false, cnt = 0;
void dfs(int start, int here) {
	visited[here] = true;
	
	for (int i = 0; i < v[here].size(); i++) {
		int next = v[here][i];
		
		if (next == start) {
			ans.push_back(here);
			finish = true;
			return;
		}
		
		if (!finish) {
			if (!visited[next]) {
				dfs(start, next);
			}
		}
		else {
			ans.push_back(here);
			return;
		}
	
	}
}

int main() {
	int n;
	cin >> n;
	
	for (int i = 1; i <= n; i++) {
		int u;
		cin >> u;
		v[i].push_back(u);
	}
	
	for (int i = 1; i <= n; i++) {
		memset(visited, 0, sizeof(visited));
		finish = false;
		dfs(i, i);
	}
	
	cout << ans.size() << endl;
	sort(ans.begin(), ans.end());
	for (int i : ans) {
		cout << i << endl;
	}	
	return 0;
}