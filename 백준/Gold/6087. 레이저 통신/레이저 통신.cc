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
        return a.cost > b.cost; // 오름차순
    }
};
priority_queue<St, vector<St>, cmp> q;

int n, m;
char a[100][100];
int cache[100][100];
int dy[4] = {0,1,0,-1}; // 우하좌상
int dx[4] = {1,0,-1,0};
int sy=-1, sx, ey, ex;

void dijkstra() {
    cache[sy][sx] = 0;
    q.push(St{sy, sx, 0});
	
    while(!q.empty()) {
		int y = q.top().y;
		int x = q.top().x;
		int cost = q.top().cost;
		q.pop();
        for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
            int next = i;
            
          while(1) {
             if(ny < 0 || nx < 0 || ny > n-1 || nx > m-1 || a[ny][nx] =='*') break;
                 if(cache[ny][nx] == INF) { 
                     cache[ny][nx] = cost;
                     q.push(St{ny, nx, cost+1});
                 }
             ny += dy[i]; 
             nx += dx[i];
         }
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
	cout << cache[ey][ex]; 
}

int main() {
	ios_base::sync_with_stdio(false);	
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> m >> n;
	for(int i=0; i<n; i++) {
		for(int j=0; j<m; j++) {
			cin >> a[i][j];
        if(a[i][j] == 'C') {
             if(sy==-1) {
                sy = i; 
                sx = j; 
             } else {
                 ey = i;
                 ex = j;
              }
            }
		}
	}
	solve();
	return 0;
}