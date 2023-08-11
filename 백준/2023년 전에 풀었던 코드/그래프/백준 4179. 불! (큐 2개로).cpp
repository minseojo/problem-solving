#include <bits/stdc++.h>
#define INF 987654321
using namespace std;

int r, c;
char a[1111][1111];
queue<pair<int, int> > fire;
queue<pair<int, int> > jihoon;
int dy[4] = {1,-1,0,0};
int dx[4] = {0,0,1,-1};
int num_a[1111][1111];

void input() {
	for(int i=0; i<r; i++) {
		for(int j=0; j<c; j++) {
			cin >> a[i][j];
			if(a[i][j]=='J') {
				jihoon.push({i, j});
			} else if(a[i][j]=='F') {
				num_a[i][j]=1;
				fire.push({i, j});
			} else if(a[i][j]=='#') {
				num_a[i][j]=INF;
			} else {
				num_a[i][j]=INF;
			}
		}
	}	
}

void burn_fire() {
	int y, x, size, cnt=2;
	while(!fire.empty()) {
		size = fire.size();
		while(size--) {
			y = fire.front().first;
			x = fire.front().second; 
			fire.pop();
			for(int i=0; i<4; i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				if(ny<0 || nx<0 || ny>r-1 || nx>c-1) continue;
				else if(a[ny][nx]=='#' || a[ny][nx]=='J') continue;
				
				if(a[ny][nx]=='.') {
					a[ny][nx]='f';
					num_a[ny][nx]=cnt;
					fire.push({ny, nx});
				}
			}
		}
		cnt++;
	}
}

void run_jihoon() {
	int y, x, cnt=1, size;
	while(!jihoon.empty()) {
		size = jihoon.size();
		while(size--) {
			y = jihoon.front().first;
			x = jihoon.front().second;
			jihoon.pop();
			if(y==0 || y==r-1 || x==0 || x==c-1) {
				cout << cnt;
				return;
			}
			for(int i=0; i<4; i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				if(ny<0 || nx<0 || ny>r-1 || nx>c-1) continue;
				else if(a[ny][nx]=='#' || a[ny][nx]=='F') continue;
				
				if(a[ny][nx]=='f' || a[ny][nx]=='.') {
					a[ny][nx]='j';
					if(cnt+1 < num_a[ny][nx]) {
						jihoon.push({ny, nx});
					}
				}
			}
		}
		cnt++;
	}
	cout << "IMPOSSIBLE";
	return;
}

int main() {
	cin >> r >> c;
	input();
	burn_fire();
	run_jihoon();
	return 0;
}
