#include <bits/stdc++.h>
using namespace std;

#define BLANK 0
#define WALL 1
#define CLEAN 2

struct Robot {
	int y;
	int x;
	int dir;
}robot;


int N, M;
int board[51][51];
int dy[4] = {-1,0,1,0}; //북동남서 
int dx[4] = {0,1,0,-1};

void init() {
	cin >> N >> M;
	
	int r, c, d;
	cin >> r >> c >> d;
	
	robot.y = r;
	robot.x = c;
	robot.dir = d;
	
	for(int i=0; i<N; i++) {
		for(int j=0; j<M; j++) {
			cin >> board[i][j];
		}
	}
}

void back() {
	int d = robot.dir;
	
	// 북 
	if(d == 0) {
		robot.y += 1;
	}
	
	//동 
	else if(d == 1) {
		robot.x -= 1;
	}
	
	//남 
	else if(d == 2) {
		robot.y -= 1;
	}
	
	//서 
	else if(d == 3) {
		robot.x += 1;
	}
}

bool clean() {
	if(board[robot.y][robot.x] == BLANK) {
		board[robot.y][robot.x] = CLEAN;
		return true;
	}
	
	return false;
}

bool leftTurn() {		
	robot.dir -= 1;
	if(robot.dir == -1) robot.dir = 3;
	
	if(board[robot.y + dy[robot.dir]][robot.x + dx[robot.dir]] == BLANK) {
		robot.y += dy[robot.dir];
		robot.x += dx[robot.dir];
		return true;
	}
	
	else return false;
}
 
int solution() {
	int answer = 0;
	int back_cnt = 0;
	while(1) {
		if(clean()) {
			answer += 1;
		}

		for(int i=0; i<4; i++) {
			if(leftTurn()) break;		
			
			if(i==3) {
				back();
				if(robot.y < 0 || robot.x < 0 || robot.y > N-1 || robot.x > M-1 || board[robot.y][robot.x] == WALL) return answer;
			}
		}
	}
}

int main() {
	init();
	cout << solution();
    
    return 0;
}