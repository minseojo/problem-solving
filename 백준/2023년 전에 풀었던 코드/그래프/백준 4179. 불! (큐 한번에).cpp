#include <bits/stdc++.h>
using namespace std;

int r, c;
char a[1111][1111];
queue<pair<int, int> > fire;
queue<pair<int, int> > jihoon;
int dy[4] = {1,-1,0,0};
int dx[4] = {0,0,1,-1};

void input() {
	for(int i=0; i<r; i++) {
		for(int j=0; j<c; j++) {
			cin >> a[i][j];
			if(a[i][j]=='J') {
				jihoon.push({i, j});
			} else if(a[i][j]=='F') {
				fire.push({i, j});
			}
		}
	}	
}

void bfs() {
	int size, y, x, cnt=1;
	int ny, nx;
	
	while(1) {
		if(jihoon.empty()) break;	
		size = fire.size();
		while(size--) {
			y = fire.front().first;
			x = fire.front().second;
			fire.pop();
			for(int i=0; i<4; i++) {
				ny=y+dy[i];
				nx=x+dx[i];
				if(ny<0 || nx<0 || ny>r-1 || nx>c-1) continue;
				//if(a[ny][nx]=='#' || a[ny][nx]=='F' || a[ny][nx]=='J') continue;
				
				if(a[ny][nx]=='.' || a[ny][nx]=='j') {
					a[ny][nx]='F';
					fire.push({ny, nx});
				}
			}
		}
		
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
				ny=y+dy[i];
				nx=x+dx[i];
				if(ny<0 || nx<0 || ny>r-1 || nx>c-1) continue;
				//if(a[ny][nx]=='#' || a[ny][nx]=='F' || a[ny][nx]=='J') continue;
				
				if(a[ny][nx]=='.') {
					a[ny][nx]='j';
					jihoon.push({ny, nx});
				}
			}
		}
		cnt++;
	}
	
	cout << "IMPOSSIBLE";
}

int main() {
	cin >> r >> c;
	input();
	bfs();	
	return 0;
}
