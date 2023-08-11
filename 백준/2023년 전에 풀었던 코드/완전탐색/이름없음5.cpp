#include <bits/stdc++.h>
using namespace std;

int n, m;
int a[8][8];
int dy[4] = {-1,1,0,0}; // ╩С го аб ©Л
int dx[4] = {0,0,-1,1};
bool visited[8][8][4];
vector<pair<int, int>> camera;
int angle[8];
int copy_a[8][8];
int answer=1e9;

void copy(){
    for (int i=0; i<n; i++) {
        for (int j=0; j<m; j++) {
            copy_a[i][j] = a[i][j];
        }
    }
}

int numOfBlindSpot() {
    int cnt=0;
	for(int i=0; i<n; i++) {
		for(int j=0; j<m; j++) {
			if(copy_a[i][j]==0) cnt++;
		}
	}
    return cnt;
}

void solve(int pos) {
	if(pos==camera.size()) {
		for(int i=0; i<camera.size(); i++) {
			int y = camera[i].first;
			int x = camera[i].second;
			for(int j=0; j<4; j++) {
				if(visited[y][x][j]) {
					int ny = y + dy[(angle[i]+j) % 4];
					int nx = x + dx[(angle[i]+j) % 4];
					
					while(1) {
						if(copy_a[ny][nx]==6) break;
						if (!(0<=ny && ny<n && 0<=nx && nx<m)) break;
						
						if(copy_a[ny][nx]==0) copy_a[ny][nx]=-1;						
						ny += dy[(angle[i]+j) % 4];
						nx += dx[(angle[i]+j) % 4];
					}
				}
			}
		}
		
		answer = min(answer, numOfBlindSpot());
		copy();
		return;
	}
	
	for(int i=0; i<4; i++) {
		angle[pos]=i;
		solve(pos+1);
	}
}

int main() {
	ios_base::sync_with_stdio(0);
    cin.tie(0);

	cin >> n >> m;
	for(int i=0; i<n; i++) {
		for(int j=0; j<m; j++) {
			cin >> a[i][j];
			
			if(1<=a[i][j] && a[i][j]<=5) {
				camera.push_back({i, j});
			}
	// ╩С го аб ©Л
			if(a[i][j]==1) {
				visited[i][j][3]=true;
			} 
			else if(a[i][j]==2) {
				visited[i][j][2]=true;
				visited[i][j][3]=true;
			} 
			else if(a[i][j]==3) {
				visited[i][j][0]=true;
				visited[i][j][3]=true;
			} 
			else if(a[i][j]==4) {
				visited[i][j][0]=true;
				visited[i][j][2]=true;
				visited[i][j][3]=true;
			} 
			else if(a[i][j]==5) {
				visited[i][j][0]=true;
				visited[i][j][1]=true;
				visited[i][j][2]=true;
				visited[i][j][3]=true;
			}
		}
	}
	
	copy();
	solve(0);
	cout << answer;
	return 0;
}
