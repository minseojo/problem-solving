#include <bits/stdc++.h>
using namespace std;

struct st {
	int y;
	int x;
	int d;
};
queue<st> q;

int n, m;
int board[303][303];
int copy_board[303][303];
int dy[4] = {1,-1,0,0};
int dx[4] = {0,0,1,-1};
int ice_bergs = 0;
bool visited[303][303];

void copyBoard() { // 배열 복사 
	for(int i=0; i<n; i++) {
		for(int j=0; j<m; j++) {
			board[i][j] = copy_board[i][j];
		}
	}
}

bool isValidRange(int y, int x) { // 유효범위 체크 
	if(y<0 || x<0 || y>n-1 || x>m-1) return false;
	
	return true;
}

void countIceBerg(int y, int x) { // 빙하 덩어리 개수 세기 
	queue<pair<int, int>> check_q;
	check_q.push({y, x});
	while(!check_q.empty()) {
		int y = check_q.front().first;
		int x = check_q.front().second;

		check_q.pop();
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(!isValidRange(ny, nx)) continue;
			
			if(!visited[ny][nx] && board[ny][nx] > 0) {
				visited[ny][nx] = true;	
				check_q.push({ny, nx});			
			}
		}
	}
}

void melt() { // 빙하 녹이기 
	int size = q.size();		

	while(size--) {
		int y = q.front().y;
		int x = q.front().x;
		int d = q.front().d;
		q.pop();
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(!isValidRange(ny, nx)) continue;
				
			if(d>0 && board[ny][nx] == 0) {
				d--;
			}
		}

		copy_board[y][x] = d;
		if(d==0) ice_bergs -= 1;
		else if(d>0) {
			q.push({y, x, d});	
		}
	}
	
	copyBoard();
} 

void solve() {
	int answer = 0;	
	
	while(1) {
		memset(visited, 0, sizeof(visited));
		int count = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(board[i][j] > 0 && !visited[i][j]) {
					visited[i][j] = true;
					countIceBerg(i, j);
					count += 1;
				}
			}
		}
		
		if(count == 0) { // 다 녹았을 경우 
			answer = 0;
			break;
		}
		else if(count == 1) { // 한 덩어리 
			melt();
			answer += 1;
		}
		else if(count > 1) { // 두 덩어리 이상 
			break;
		}
	}
	
	cout << answer;
}

void init() {
	cin >> n >> m;
	for(int i=0; i<n; i++) {
		for(int j=0; j<m; j++) {
			cin >> copy_board[i][j];
 
			if(copy_board[i][j] > 0) {
				ice_bergs += 1;
				q.push({i, j, copy_board[i][j]});
			}
		}
	}
	
	copyBoard();
}

int main() {
	init();
	solve();
	
	return 0;	
}
