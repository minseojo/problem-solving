#include <bits/stdc++.h>
using namespace std;

int N;
int paper[2187][2187]; // 3^7 = 2187
int answers[3]; // -1 0 1
void solve(int sy, int sx, int size);

void init() {
	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> paper[i][j];
		}
	}
}

void solve(int sy, int sx, int size) {
	if(size < 1) return;

	int minus_cnt = 0;
	int zero_cnt = 0;
	int plus_cnt = 0;
	
	for (int i = sy; i < sy + size; i++) {
		for (int j = sx; j < sx + size; j++) {
			if (paper[i][j] == -1) minus_cnt += 1;
			else if (paper[i][j] == 0) zero_cnt += 1;
			else if (paper[i][j] == 1) plus_cnt += 1;
		}
	}
	
	if (minus_cnt == size * size) answers[0] += 1;
	else if (zero_cnt == size * size) answers[1] += 1;
	else if (plus_cnt == size * size) answers[2] += 1;
	
	else {
		size = size / 3;
		for (int i = 0; i < 3; i++) {
			solve(sy, sx + size * i, size); // a b c
			solve(sy + size, sx + size * i, size); // d e f
			solve(sy + size * 2, sx + size * i, size); // g h i
		}
	}
}

void getAnswer() {
	for (int answer : answers) {
		cout << answer << endl;	
	}
}

int main() {
	init();
	solve(0, 0, N);
	getAnswer();

	return 0;
}
