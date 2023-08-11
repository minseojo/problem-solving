#include <bits/stdc++.h>
using namespace std;

int n;
vector<pair<int, int > > v[10001];
int visited[10001];
int answer=-1;
int root=-1;

void solve(int here, int sum) {
    visited[here]=1;
    
	if(answer<sum){
		root=here;
		answer=sum;
	}

	for(int i=0; i<v[here].size(); i++) {
		int nextNode=v[here][i].first;
		int nextW=v[here][i].second;
		if(visited[nextNode]==-1) {
			solve(nextNode, sum+nextW);
		}
	}
	
	return;
}

int main() {
	cin >> n;
	int a, b, c;
	
	for(int i=0; i<n-1; i++) {
		cin >> a >> b >>  c;
		v[a].push_back({b, c});
		v[b].push_back({a, c});
	}	
	
	memset(visited, -1, sizeof(visited));
	solve(1, 0);
	
	memset(visited, -1, sizeof(visited));
	solve(root, 0);
	cout << answer;
	return 0;
} 
