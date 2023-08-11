#include <bits/stdc++.h>
using namespace std;

int n;
int arr[51][51];
int answer[51][51];

int dy[4]={0,0,1,-1};
int dx[4]={1,-1,0,0};

void dfs(int y, int x, int cnt) {
	if(y>n || x>n || x<0 || y<0) return;

	if(answer[y][x]<=arr[y][x]+cnt) return;
	answer[y][x]=arr[y][x]+cnt;
	
	for(int i=0; i<4; i++) {
		int ny=y+dy[i];
		int nx=x+dx[i];
		dfs(ny, nx, answer[y][x]);
	}
}

int main() {
	cin >> n;
	for(int i=0; i<n; i++) {
		for(int j=0; j<n; j++) {
			answer[i][j]=1e9;
		}
	}
	
	string s;
	for(int i=0; i<n; i++) {
		cin >> s;
		for(int j=0; j<s.size(); j++) {
			arr[i][j]=1-(s[j]-'0');
		}
	}
	dfs(0, 0, 0);

	cout << answer[n-1][n-1];
}
