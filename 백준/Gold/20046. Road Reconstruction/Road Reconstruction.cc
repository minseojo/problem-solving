#include <bits/stdc++.h>
#define INF 1e9
using namespace std;

struct St{
	int y;
	int x;
	int cost;
    
};

struct cmp {
    bool operator()(St a, St b) {
        return a.cost > b.cost;
    }
};
priority_queue<St, vector<St>, cmp> q;

int n, m;
int a[1000][1000];
int cache[1000][1000];
int dy[4] = {0,0,1,-1};
int dx[4] = {1,-1,0,0};

void dijkstra() {
	if(a[0][0] != -1) q.push(St{0, 0, a[0][0]});
	
	while(!q.empty()) {
		int y = q.top().y;
		int x = q.top().x;
		int cost = q.top().cost;
		q.pop();

		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny < 0 || nx < 0 || ny > n-1 || nx > m-1 || a[ny][nx] == -1) continue;
			
			int new_cost = cost + a[ny][nx];
			if(cache[ny][nx] <= new_cost) continue;
			cache[ny][nx] = new_cost;
			q.push(St{ny, nx, new_cost});
		}
	}
}

void solve() {
	for(int i=0; i<n; i++) {
		for(int j=0; j<m; j++) {
			cache[i][j] = INF;
		}
	}
	dijkstra();
	
	if(cache[n-1][m-1] != INF) cout << cache[n-1][m-1];
	else cout << -1;
}

int main() {
	ios_base::sync_with_stdio(false);	
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m;
	for(int i=0; i<n; i++) {
		for(int j=0; j<m; j++) {
			cin >> a[i][j];
		}
	}
	solve();
	return 0;
}