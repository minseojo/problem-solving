#include <bits/stdc++.h>
using namespace std;

int n, m;
vector<int> v[2222];
int visited[2222];
int ans=0;

void dfs(int idx, int cnt) {

	if(cnt>=4) {
		cout << 1; 
		exit(0);
	}
	
	for(int i=0; i<v[idx].size(); i++) {
		int x=v[idx][i];
		if(!visited[x]) {
			visited[x]=true;
			dfs(x, cnt+1);
			visited[x]=false;
		}
	}
	//visited[idx]=false;
	return;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	
	cin >> n >> m;
	
	int a, b;
	for(int i=0; i<m; i++) {
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a); 
	}	
	
	for(int i=0; i<n; i++) {
		memset(visited, 0, sizeof(visited));
		visited[i]=true;
		dfs(i, 0);
	}
	
	cout << ans;

	return 0;
}
