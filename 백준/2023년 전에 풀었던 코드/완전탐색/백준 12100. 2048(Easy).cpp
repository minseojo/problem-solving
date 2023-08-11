#include <bits/stdc++.h>
using namespace std;

int n;
int board[20][20];
int copyBoard[20][20];
int cache[5];
int answer =-1;

void input() {
	cin >> n;
	for(int i=0; i<n; i++) {
		for(int j=0; j<n; j++) {
			cin >> board[i][j];
		}
	}	
}

void copy() {
	for(int i=0; i<n; i++) {
		for(int j=0; j<n; j++) {
			copyBoard[i][j] = board[i][j];
		}
	}
}

int findOfMax() {
	int result = -1;
	for(int i=0; i<n; i++) {
		for(int j=0; j<n; j++) {
			result = max(result, copyBoard[i][j]);
		}
	}
	return result;
}

void shift(int dir) {
	queue<int> q;
	
	if(dir==0) { // left
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(copyBoard[i][j]>0)
					q.push(copyBoard[i][j]);
				copyBoard[i][j] = 0;
			}
			
			int x = 0;
			while(!q.empty()) {
				int front = q.front();
				q.pop();
				if(copyBoard[i][x] == 0) {
					copyBoard[i][x] = front;
				} else if(copyBoard[i][x] == front) {
					copyBoard[i][x]*= 2;
					x++;
				} else {
					x++;
					copyBoard[i][x] = front;
				}
			}
		}
	}
	
	if(dir==1) { // right
		for(int i=0; i<n; i++) {
			for(int j=n-1; j>=0; j--) {
				if(copyBoard[i][j]>0)
					q.push(copyBoard[i][j]);
				copyBoard[i][j] = 0;
			}
			
			int x = n-1;
			while(!q.empty()) {
				int front = q.front();
				q.pop();
				if(copyBoard[i][x] == 0) {
					copyBoard[i][x] = front;
				} else if(copyBoard[i][x] == front) {
					copyBoard[i][x]*= 2;
					x--;
				} else {
					x--;
					copyBoard[i][x] = front;
				}
			}
		}
	}
	
	if(dir==2) { // up
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(copyBoard[j][i]>0)
					q.push(copyBoard[j][i]);
				copyBoard[j][i] = 0;
			}
			
			int y = 0;
			while(!q.empty()) {
				int front = q.front();
				q.pop();
				if(copyBoard[y][i] == 0) {
					copyBoard[y][i] = front;
				} else if(copyBoard[y][i] == front) {
					copyBoard[y][i]*= 2;
					y++;
				} else {
					y++;
					copyBoard[y][i] = front;
				}
			}
		}
	}
	
	if(dir==3) { // down
		for(int i=0; i<n; i++) {
			for(int j=n-1; j>=0; j--) {
				if(copyBoard[j][i]>0)
					q.push(copyBoard[j][i]);
				copyBoard[j][i] = 0;
			}
			
			int y = n-1;
			while(!q.empty()) {
				int front = q.front();
				q.pop();
				if(copyBoard[y][i] == 0) {
					copyBoard[y][i] = front;
				} else if(copyBoard[y][i] == front) {
					copyBoard[y][i]*= 2;
					y--;
				} else {
					y--;
					copyBoard[y][i] = front;
				}
			}
		}
	}	
}

void solve(int pos) {
	if(pos==5) {
		copy();
		for(int i=0; i<pos; i++) {
			shift(cache[i]);
		}
		answer = max(answer, findOfMax());
		return;
	}
	
	for(int i=0; i<4; i++) {
		cache[pos]=i;
		solve(pos+1);
	}
}

int main() {
	input();
	solve(0);
	cout << answer;
	return 0;
} 
