#include <bits/stdc++.h>
using namespace std;

int board[9][9];
vector<pair<int, int> > blank;
int cache[20];
int copyBoard[9][9];

void input() {
	for(int i=0; i<9; i++) 
		for(int j=0; j<9; j++) {
			cin >> board[i][j];
			if(board[i][j] == 0) blank.push_back({i, j});
		}
}

void print() {
	for(int i=0; i<9; i++) {
		for(int j=0; j<9; j++) {
			cout << board[i][j] << " ";
		}
		cout << endl;
	}
}

bool check(int pos, int y, int x) {	
	// 행, 열 체크 
	for(int i = 0; i < 9; i++) {
		if(board[y][x] == board[y][i] && i != x) return false;
		if(board[y][x] == board[i][x] && i != y) return false;
	}
	
	// 3 x 3 체크

	for(int i=y/3*3; i<y/3*3+3; i++) {
		for(int j=x/3*3; j<x/3*3+3; j++) {
			if(board[i][j] == board[y][x]) {
				if(i != y && j != x) return false;
			}
		}
	}

	return true;
}

void solve(int pos) {
	if(pos == blank.size()) {
		print();
		exit(0);
	}
	
	int y = blank[pos].first;
	int x = blank[pos].second;
	for(int i=1; i<=9; i++) {
		board[y][x] = i;
		if(check(pos, y, x)) {
			solve(pos + 1);
		}
	}
	board[y][x] = 0;
	return;
}

int main() {
	input();
	solve(0);
	return 0;
}
