#include <bits/stdc++.h>
using namespace std;

int n;
int a[111][111];
int visited[111][111];
int dy[4]={-1,1,0,0};
int dx[4]={0,0,-1,1};

bool bfs(int left, int right) {
	queue<pair<int, int> > q;
	memset(visited, false, sizeof(visited));
	if(a[0][0]<left || a[0][0]>right) return false;
	q.push({0, 0});
	visited[0][0]=true;
	
	while(!q.empty()) {
		int y=q.front().first;
		int x=q.front().second;
		q.pop();
		for(int i=0; i<4; i++) {
			int ny=y+dy[i];
			int nx=x+dx[i];
			if(ny<0 || nx<0 || ny>n-1 || nx>n-1) continue;
			if(visited[ny][nx]) continue;
			if(a[ny][nx]<left || a[ny][nx]>right) continue;
			
			visited[ny][nx]=true;
			q.push({ny, nx});
		}
	}
	
	return visited[n-1][n-1];
}

bool solve(int mid) {
	for(int i=0; mid+i<=200; i++) {
		if(bfs(i, mid+i)) return true;
	}
	return false;
}

int binary_search() {
	int left=0, right=200, ans=0;
	
	while(left<=right) {  // n개의 숫자가 모두 같을행 수 있다. =>  left==right 같을때까지 실 
		int mid=(left+right)/2;
		if(solve(mid)) {
			ans=mid;
			right=mid-1;
		} else {
			left=mid+1;
		}
	}
	
	return ans;
}
int main() {

	
	cin >> n;
	for(int i=0; i<n; i++) {
		for(int j=0; j<n; j++) {
			cin >> a[i][j];
		}
	}
	
	cout << binary_search();
	return 0;
}
