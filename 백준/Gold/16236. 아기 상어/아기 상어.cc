#include <bits/stdc++.h>
using namespace std;
 
struct Shark {
	int y;
	int x;
	int size;
	int eaten;
	int move;
}shark;

int N;
int board[21][21];
int dy[4] = {-1,0,0,1};
int dx[4] = {0,-1,1,0};
bool visited[21][21];
 
void init() {
	cin >> N;
	for(int i=0; i<N; i++) {
		for(int j=0; j<N; j++) {
			cin >> board[i][j];
			if(board[i][j] == 9) {
				shark.y = i;
				shark.x = j;
				shark.size = 2;
				shark.eaten = 0;
				shark.move = 0;
				board[i][j] = 0;
			}
		}
	}
}
 
bool comp(Shark &a, Shark &b) {
	if(a.y == b.y) return a.x < b.x;
	else return a.y < b.y;
}
 
bool bfs() {
	queue<Shark> q;
	q.push({shark.y, shark.x});
	visited[shark.y][shark.x] = true;
 
	vector<Shark> preys;
	int move = 1;
	int size = shark.size;
	while(!q.empty()) {
		int q_size = q.size();
		while(q_size--) {
			int y = q.front().y;
			int x = q.front().x;
			q.pop();
 
			for(int i=0; i<4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
 
				if(visited[ny][nx]) continue;
				if(ny < 0 || nx < 0 || ny > N-1 || nx > N-1) continue;
				visited[ny][nx] = true;
 
				// 먹이 먹기 
				if(board[ny][nx] < size && board[ny][nx] != 0) {
					preys.push_back({ny, nx});
					if(preys.size() == 1) {
						shark.eaten += 1;
						shark.move += move;
					}
 
					if(shark.eaten == size) {
						shark.eaten = 0;
						shark.size += 1;
					}
				} 
                // 지나가기
                else if (preys.size() < 1 && (board[ny][nx] == 0 || board[ny][nx] == size)) {
					q.push({ny, nx});
				}
			} 
		}
        if(preys.size() > 0) break;
        
        move += 1;
	}
 
	if(preys.size() > 0) {
		sort(preys.begin(), preys.end(), comp);
		shark.y = preys[0].y;
		shark.x = preys[0].x;
		board[shark.y][shark.x] = 0;
		return true;
	}
 
	return false;
}
 
void solution() {
	while(1) {
		memset(visited, 0, sizeof(visited));
		if(!bfs()) break;
	}
 
	cout << shark.move;
}
 
int main() {
	init();
	solution();
 
	return 0;
}