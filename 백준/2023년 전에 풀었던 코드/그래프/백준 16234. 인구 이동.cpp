#include <bits/stdc++.h>
using namespace std;

int N, L, R;
int a[55][55];
int visited[55][55];
int ans=0;
int dy[4] = {0, 0, 1, -1};
int dx[4] = {1, -1, 0, 0};
bool flag=false;

void bfs(int yy, int xx) {
	queue<pair<int, int> > q;
	q.push({yy, xx});
	queue<pair<int, int> > ch;
	ch.push({yy, xx});
	
	visited[yy][xx]=1;	
	int sum=a[yy][xx];
	while(!q.empty()) {
		int y=q.front().first;
		int x=q.front().second;
		q.pop();
		for(int i=0; i<4; i++) {
			int ny=y+dy[i];
			int nx=x+dx[i];
			if(ny<0 || nx<0 || ny>N-1 || nx>N-1) continue;
			if(visited[ny][nx]) continue;		
			int dif=abs(a[y][x]-a[ny][nx]);
			if(L<=dif && dif<=R) {
				visited[ny][nx]=1;
				sum+=a[ny][nx];
				q.push({ny, nx});
				ch.push({ny, nx});
			}
		}
	}
	
	int value=sum/ch.size();
	if(ch.size()>1) flag=true;
	while(!ch.empty()) {
		int y2, x2;
		y2=ch.front().first;
		x2=ch.front().second;
		a[y2][x2]=value;
		ch.pop();
	}
}

int main() {
	cin >> N >> L >> R;
	for(int i=0; i<N; i++) {
		for(int j=0; j<N; j++) {
			cin >> a[i][j];
		}
	}
	
	while(1) {
		flag=false;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					bfs(i, j);
				}
			}
		}
		if(flag==false) break; 
		ans++;
		memset(visited, 0, sizeof(visited));
	}
	
	cout << ans;
	return 0;
} 
