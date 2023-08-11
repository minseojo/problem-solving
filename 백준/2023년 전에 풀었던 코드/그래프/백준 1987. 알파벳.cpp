#include <bits/stdc++.h>
using namespace std;

int r, c;
char a[27][27];
int dy[4]={-1,1,0,0};
int dx[4]={0,0,-1,1};
bool check[27][27];
bool visited[27];
int answer=0;

void solve(int y, int x, int length) {
	answer=max(answer, length);
	 
	for(int i=0; i<4; i++) {
		int ny=y+dy[i];
		int nx=x+dx[i];
		if(ny<0 || nx<0 || ny>r-1 || nx>c-1) continue;
		int alpha=a[ny][nx]-'A';
		if(!visited[alpha]) {
			visited[alpha]=1;
			solve(ny, nx, length+1);
			visited[alpha]=0;
		}
	}
}

int main() {
	cin >> r >> c;
	for(int i=0; i<r; i++) {
		string s;
		cin >> s;
		for(int j=0; j<c; j++) {
			a[i][j]=s[j];
		}
	}

	visited[a[0][0]-'A']=1;
	solve(0, 0, 1);
	cout << answer;
	return 0;
}
