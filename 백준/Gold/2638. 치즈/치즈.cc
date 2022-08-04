#include <bits/stdc++.h>
using namespace std;

struct st {
	int y;
	int x;
};

int n, m;
int board[101][101];
int copy_board[101][101];
int dy[4] = {1,-1,0,0};
int dx[4] = {0,0,1,-1};
bool visited[101][101];
int total_cheese = 0; // 처음 전체 치즈 
int count_cheese = 0; // 지금까지 내가 녹인 치즈 

void copyBoard() {
	for(int i=0; i<n; i++) {
		for(int j=0; j<m; j++) {
			if(copy_board[i][j] == -20) {
				copy_board[i][j] = 0;
				board[i][j] = 0;
			}
			else if(copy_board[i][j] == -10) {
				board[i][j] = 1;
				copy_board[i][j] = 1;
			}
			else board[i][j] = copy_board[i][j];
		}
	}	
}

void init() {
	cin >> n >> m;
	for(int i=0; i<n; i++) {
		for(int j=0; j<m; j++) {
			cin >> board[i][j];
			copy_board[i][j] = board[i][j];
			if(board[i][j] == 1) total_cheese += 1;
		}
	}
}

bool isValidRange(int y, int x) {
	if(y < 0 || x < 0 || y > n-1 || x > m-1) return false;
	
	if(visited[y][x]) return false;
	
	return true;
}

 
bool bfs(int sy, int sx) {
	queue<st> q;
	q.push({sy, sx});
	visited[sy][sx] = true;

	while(!q.empty()) {
		int size = q.size();
		while(size--) {
			int y = q.front().y;
			int x = q.front().x;
			q.pop();
			
			for(int i=0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(!isValidRange(ny, nx)) continue;

				if(board[y][x] == 0) {				
					if(copy_board[ny][nx] == 1) {
						copy_board[ny][nx] = -10;
					}
					else if(copy_board[ny][nx] == -10) {
						copy_board[ny][nx] = -20;
						count_cheese += 1;
					}
					
					if(board[ny][nx] == 0) {
						q.push({ny, nx});
						visited[ny][nx] = true;
					}	
				}
			}
		}
	}	
	
	if(count_cheese == total_cheese) return true;
	else return false;
}

void solution() {
	int time = 0;
	
	// 모두 0 인 경우 
	bool flag = false;
	for(int i=0; i<n; i++) {
		for(int j=0; j<m; j++) {
			if(board[i][j] == 1) flag = true;
		}
	}
	if(!flag) goto EXIT;
	
	while(1) {
		memset(visited, 0, sizeof(visited));
		time += 1;
		if(bfs(0, 0)) break;
		copyBoard();
	}
	
	EXIT:
	cout << time;
}

int main() {
	init();
	solution();
	
	return 0;
}