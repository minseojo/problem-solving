#include <bits/stdc++.h>
using namespace std;

struct St {
	int y;
	int x;
};

int n, m;
char board[101][101];
vector<St> door[26];
queue<St> q;
int dy[4] = {1,-1,0,0};
int dx[4] = {0,0,1,-1};
bool visited[101][101];
int answer = 0;

bool isValidRange(int y, int x) {
	if(y < 0 || x < 0 || y > n-1 || x > m-1) return false;
	
	if(visited[y][x]) return false;
	
	return true;
}

void openDoor(char find_alpha) {
	int key = find_alpha - 'a';

	for(int i=0; i<door[key].size(); i++) {
		int y = door[key][i].y;
		int x = door[key][i].x;
		board[y][x] = '.';
		
		// 가장자리가 문을 연 경우 
		if(y == 0 || y == n-1 || x == 0 || x == m-1) {
			q.push({y, x});
			visited[y][x] = true;
			continue;
		}
		
		// 문을 열었는데 주변을 이미 탐색한 경우 큐에 넣기 
		for(int j=0; j<4; j++) {
			int ny = y + dy[j];
			int nx = x + dx[j];
			if(visited[ny][nx] == true) {
				visited[y][x] = true;
				q.push({y, x});
				break;
			}
		}
	}
	// 문 다열고 문 지우기
	door[key].clear();
}

void bfs() {	
	while(!q.empty()) {
		int y = q.front().y;
		int x = q.front().x;
		q.pop();
		
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];		
			if(!isValidRange(ny, nx)) continue;
			
			visited[ny][nx] = true;
			if(board[ny][nx] == '$') {
				answer += 1;
				board[ny][nx] = '.';
			 	q.push({ny, nx});
			} else if('a' <= board[ny][nx] && board[ny][nx] <= 'z') {
				q.push({ny, nx});
				openDoor(board[ny][nx]);
				board[ny][nx] = '.';
			} else if(board[ny][nx] == '.') {
				q.push({ny, nx});
			}
		}
	}
}

void init() {
	memset(board, 0, sizeof(board));
	memset(visited, 0, sizeof(visited));
	for(int i=0; i<26; i++) door[i].clear();
	queue<St> q;
		
	cin >> n >> m;
	
	for(int i=0; i<n; i++) {
		for(int j=0; j<m; j++) {
			cin >> board[i][j];
			if('A' <= board[i][j] && board[i][j] <= 'Z') {
				door[board[i][j] - 'A'].push_back({i, j});
			}
		}
	}	
} 

vector<int> answers;
void solution() {
	string k;
	cin >> k;
		
	// 열쇠 있으면 문 다 열기 
	if('a' <= k[0] && k[0] <= 'z') {
		for(int i=0; i<k.size(); i++) {		
			openDoor(k[i]);
		}
	}	
	
	answer = 0;
	
	// 열쇠 열고 가장자리 큐에 넣기 
	for(int i=0; i<n; i++) {
		for(int j=0; j<m; j++) {
			if((i == 0 || i == n-1 || j == 0 || j == m-1)) {
				if(board[i][j] == '.' || board[i][j] == '$') {
					if(board[i][j] == '$') {
						board[i][j] = '.';
						answer += 1;
					}
					q.push({i, j});
					visited[i][j] = true;	
				} else if('a' <= board[i][j] && board[i][j] <= 'z') {
					openDoor(board[i][j]);
					q.push({i, j});
					visited[i][j] = true;
				}
			}
		}
	}
		
	bfs();
	
	answers.push_back(answer);
}

int main() {
	int tc;
	cin >> tc;
	while(tc--) {		
		init();		
		solution();
	}
	
	for(int i=0; i<answers.size(); i++) {
		cout << answers[i] << endl;
	}
	return 0;
}
