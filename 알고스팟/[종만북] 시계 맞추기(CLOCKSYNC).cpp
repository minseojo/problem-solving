#include <bits/stdc++.h>
#define INF 987654321
#define SWITCH 10
using namespace std;

int clocks[16];
vector<int> link[SWITCH];
int linked[SWITCH][5] = {
{-1,1,2}, {3,7,9,11}, {4,10,14,15},
{-1,4,5,6,7}, {6,7,8,10,12}, {-1,2,14,15},
{3,14,15}, {4,5,7,14,15}, {1,2,3,4,5},
{3,4,5,9,13}
};

vector<int> cache;
int answer = INF;
int copyClocks[16];

void linkClock() {
	for(int i = 0; i < SWITCH; i++) {
		for(int j=0; j<5; j++) {
			if(linked[i][j] == -1) link[i].push_back(0);
			else if(linked[i][j] != 0) link[i].push_back(linked[i][j]);
			else if(linked[i][j] == 0) break;
		}
	}
}

void copy() {
	for(int i = 0; i < 16; i++) {
		copyClocks[i] = clocks[i];
	}
}

void push(int here, int cnt) {
	for(int i = 0; i < link[here].size(); i++) {
		int index = link[here][i];
		copyClocks[index] += (3 * cnt);
		if(copyClocks[index] > 12) copyClocks[index] = copyClocks[index] % 12;
	}
}

bool check() {
	for(int i = 0; i < 16; i++) {
		if(copyClocks[i] != 12) return false;
	}

	return true;
}

void solve(int pos) {
	if(pos == 10) {
		int sum = 0;
		copy();
		for(int i = 0; i < 10; i++) {
			push(i, cache[i]);
			sum += cache[i];
		}
		if(check()) answer = min(answer, sum);
		return;
	}
	
	for(int i = 0; i < 4; i++) {
		cache.push_back(i);
		solve(pos + 1);
		cache.pop_back();
	}
}

int main() {
	linkClock();

	int tc;
	cin >> tc;
	while(tc--) {
		answer = INF;
		for(int i=0; i<16; i++) {
			cin >> clocks[i];
		}
		
		solve(0);
		if(answer == INF) cout << -1 << endl;
		else cout << answer << endl;
	}
	
	return 0;
}
