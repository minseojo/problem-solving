#include <bits/stdc++.h>
#define MAX 10
#define INF 987654321
using namespace std;

int paper[11][11];
int sticker[6];
int answer = INF;

void init() {
	for (int i = 1; i <= MAX; i++) {
		for (int j = 1; j <= MAX; j++) {
			cin >> paper[i][j];
		}
	}
}

pair<int, int> findPos() {
	for (int i = 1; i <= MAX; i++) {
		for (int j = 1; j <= MAX; j++) {
			if(paper[i][j] == 1) return {i, j};
		}
	}
	
	return {-1, -1};
}

bool isValidRange(int y, int x, int type) {
	if(y + type > MAX + 1 || x + type > MAX + 1) return false;
	
	return true;
}

bool isPossible(int y, int x, int type) {
	for (int i = y; i < y + type; i++) {
		for (int j = x; j < x + type; j++) {
			if(paper[i][j] == 0) return false;
		}
	}
	
	return true;
}

void fill(int y, int x, int type, int state) {
	for (int i = y; i < y + type; i++) {
		for (int j = x; j < x + type; j++) {
			paper[i][j] = state;
		}
	}
}

void solve(int count) {
	if(count > answer) return;
	
	pair<int, int> pos = findPos();
	int y = pos.first;
	int x = pos.second;

	if(y == -1) {
		answer = min(answer, count);
		return;
	}
	
	for(int type = 5; type > 0; type--) {
		if(sticker[type] > 4) continue;
		if(!isValidRange(y, x, type)) continue;	
		if(!isPossible(y, x, type)) continue;

		fill(y, x, type, 0);
		sticker[type] += 1;
		solve(count + 1);	
		sticker[type] -= 1;
		fill(y, x, type, 1);	
	}
}

void getAnswer() {
	if(answer == INF) cout << -1;
	else cout << answer;
}

int main() {
	init();
	solve(0);
	getAnswer();
	return 0;
}
