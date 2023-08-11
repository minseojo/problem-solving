#include <bits/stdc++.h>
using namespace std;

int N, M;
int board[1001][1001];
bool visited[2][1001][1001]; // 방문 체크 배열 
int dy[4] = {0, -1, 0, 1}; // 우상좌하 
int dx[4] = {1, 0, -1, 0};

struct st {
	int y;
	int x;
	int wall;
};

void init() {
	cin >> N >> M;
	
	char c;
	for(int i = 1; i < N + 1; i++) {
		for(int j = 1; j < M + 1; j++) {
			cin >> c;
			board[i][j] = c - '0';
		}
	}
}

bool isValidRange(int y, int x, int wall) {
	if (y < 1 || x < 1 || y > N || x > M) return false;

	// 이미 방문한 경우
	if(visited[wall][y][x] != 0) return false;	
	
	return true;
}

int bfs() {
	queue<st> q;
	q.push({1, 1, 0});
	visited[0][1][1] = 1;
	
	int result = 0;
	while(!q.empty()) {
			
		result += 1;
		int size = q.size();
		
		while(size--) {
			st cur = q.front();
			q.pop();
			
			int wall = cur.wall;
			 
			if(cur.y == N && cur.x == M) {
				return result;
			}
			
			for(int i = 0; i < 4; i++) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
			
				if(!isValidRange(ny, nx, wall)) continue;
 
				if(wall == 0 && board[ny][nx] == 1) {
					q.push({ny, nx, wall + 1});
				}

				if(board[ny][nx] == 0) {
					q.push({ny, nx, wall});	
				}

				visited[wall][ny][nx] = 1;
				// 스킬 사용하기 전까지의 경로를 가지 못하게 처리해주어도 답이 나온다.	
				//visited[1][ny][nx] = 1;	 
			}
		}
	}
	
	return -1;
}

void solve() {
	cout << bfs();
}

int main() {
	init();
	solve();
		
	return 0;
}
