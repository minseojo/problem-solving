#include <bits/stdc++.h>
#define WALL 2
using namespace std;


int N, M;
int board[8][8];
queue<pair<int, int> > virus;
int dy[4] = {0, -1, 0, 1}; // 우상좌하
int dx[4] = {1, 0, -1, 0};
bool visited[8][8];
int answer = 0;
int copyBoard[8][8];

void init() {
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> board[i][j];
			if(board[i][j] == 2) {
				virus.push({i, j});
			}
		}
	}
}

void copy() {
	for(int i = 0; i < N; i++) {
		for(int j = 0; j < M; j++) {
			copyBoard[i][j] = board[i][j];
		}
	}
}

bool isValidRange(int y, int x) {
	if(y < 0 || x < 0 || y > N - 1 || x > M - 1) return false;
	if(visited[y][x]) return false;
	
	return true;
}

void bfs() {
	memset(visited, 0, sizeof(visited));
	copy();
	
	queue<pair<int, int> > q;
	q = virus;
	
	while(!q.empty()) {
		int y = q.front().first;
		int x = q.front().second;
		q.pop();
		
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(!isValidRange(ny, nx)) continue;
			
			if(copyBoard[ny][nx] == 0) {
				visited[ny][nx] = true;
				copyBoard[ny][nx] = 2;
				q.push({ny, nx});
			}	
		}
	} 
}

int getArea() {
	int result = 0;
	for(int i = 0; i < N; i++) {
		for(int j = 0; j < M; j++) {
			if(copyBoard[i][j] == 0) result += 1;
		}
	}
	
	return result;
}

void solve(int count) {
	if(count == 3) {
		bfs();
		answer = max(answer, getArea());
		return;
	}

	for(int i = 0; i < N; i++) {
		for(int j = 0; j < M; j++) {
			if(board[i][j] == 0) {
				board[i][j] = 1; // 벽 세우기
				solve(count + 1);
				board[i][j] = 0; // 벽 내리기 
			}
		}
	}
}

int main() {
	init();
	solve(0);
	cout << answer;
	return 0;
} 
