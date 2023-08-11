#include <bits/stdc++.h>
using namespace std;

int n, m, A, B;
vector<int> v[10001];
bool visited[10001];
int answer[10001];
int cnt=0;

void solve(int here) {
	visited[here]=true; 
	cnt++;
	for(int i=0; i<v[here].size(); i++) {
		int next=v[here][i];
		if(!visited[next]) {
			solve(next);
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	
	cin >> n >> m;
	for(int i=0; i<m; i++) {
		cin >> A >> B;
		v[B].push_back(A);
	}
	
	int mx=-99;
	for(int i=1; i<=n; i++) {
		memset(visited, 0, sizeof(visited));
		cnt=0;
		solve(i);
		answer[i]=cnt;
		mx=max(mx, answer[i]);
	}
	
	for(int i=1; i<=n; i++) {
		if(answer[i]==mx) cout << i << " ";
	}
	return 0;
}
